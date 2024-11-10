package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.impl;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.crosscutting.exception.DataPostuMOTException;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.entity.PostulanteEntityAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.RegisterNewPostulante;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.PostulanteAlredyExists;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.PostulanteNameConsistencyIsValid;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.PostulantesHasNoSameDocumentTypeAndNumberAssigned;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.impl.PostulanteAlreadyExistsImpl;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.impl.PostulanteNameConsistencyIsValidImpl;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.impl.PostulantesHasNoSameDocumentTypeAndNumberAssignedImpl;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;

public final class RegisterNewPostulanteImpl implements RegisterNewPostulante{
	
	 private DAOFactoryPostulante daoFactory;
	 private PostulanteAlredyExists postulanteAlredyExists = new PostulanteAlreadyExistsImpl();
	 private PostulanteNameConsistencyIsValid postulanteNameConsistencyIsValid = new PostulanteNameConsistencyIsValidImpl();
	 private PostulantesHasNoSameDocumentTypeAndNumberAssigned postulantesHasNoSameDocumentTypeAndNumberAssigned = new PostulantesHasNoSameDocumentTypeAndNumberAssignedImpl();
	 
	 
	 
	@Override
	public void execute(final PostulanteDomain data) {
		postulanteAlredyExists.execute(data.getId(), daoFactory);
		postulanteNameConsistencyIsValid.execute(data.getFirstName());
		postulanteNameConsistencyIsValid.execute(data.getSecondName());
		postulanteNameConsistencyIsValid.execute(data.getLastName());
		postulanteNameConsistencyIsValid.execute(data.getLastSecondName());
		postulantesHasNoSameDocumentTypeAndNumberAssigned.execute(data, daoFactory);
		
		var postulanteDomainToMap = PostulanteDomain.create(generateId(), data.getDocumento(), data.getFirstName(), 
				data.getSecondName(), data.getLastName(), data.getLastSecondName(), data.getPhone(), data.getEmail(), data.getSex(), data.getTipoDocumento(), data.getCity());
		var postulanteEntity = PostulanteEntityAdapter.getPostulanteEntityAdapter().adaptTarget(postulanteDomainToMap);
		daoFactory.getPostulanteDAO().create(postulanteEntity);
	}
	
	private UUID generateId() {
		var id = UUIDHelper.generate();
		var postulanteEntity = daoFactory.getPostulanteDAO().findByID(id);
		
		if(UUIDHelper.isEqual(postulanteEntity.getId(), id)) {
			id = generateId();
		}//genere un mismo Id
		
		return id;
//		Generar el id ya sea que exista o no
	}
	
	private void setDAOFactory(final DAOFactoryPostulante daoFactory) {
		if (ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se presentado un problema tratendo de realizar el registro de la nueva ciudad";
			var technicalMessage = "El DAOFactory requerido para crear la clase que actualiza la ciudad llego nula...";
			throw DataPostuMOTException.crear(userMessage, technicalMessage);
		}
		
		this.daoFactory = daoFactory;	
	}
	
}
