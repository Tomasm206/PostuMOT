package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.crosscutting.exception.DataPostuMOTException;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.entity.PostulanteEntityAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.RegisterNewPostulante;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.PostulanteAlredyExists;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.PostulanteNameConsistencyIsValid;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.impl.PostulanteAlreadyExistsImpl;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.impl.PostulanteNameConsistencyIsValidImpl;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;

public final class RegisterNewPostulanteImpl implements RegisterNewPostulante {
	private PostulanteAlredyExists postulanteAlreadyExists = new PostulanteAlreadyExistsImpl();
	private PostulanteNameConsistencyIsValid postulanteNameConsistencyIsValid = new PostulanteNameConsistencyIsValidImpl();
	private DAOFactoryPostulante daoFactory;

	public RegisterNewPostulanteImpl(DAOFactoryPostulante daoFactoryPostulante) {
		setDAOFactory(daoFactoryPostulante);

	}

	@Override
	public void execute(final PostulanteDomain data) {
		try {
			var postulanteDomainToMap = PostulanteDomain.create(data.getId(), data.getDocumento(),
					data.getFirstName(), data.getSecondName(), data.getLastName(), data.getLastSecondName(),
					data.getPhone(), data.getEmail(), data.getSex(), data.getTipoDocumento(), data.getCity());
			var postulanteEntity = PostulanteEntityAdapter.getPostulanteEntityAdapter().adaptTarget(postulanteDomainToMap);

			daoFactory.getPostulanteDAO().create(postulanteEntity); //Aqui hay problema

			List<String> successMessages = new ArrayList<>();
			successMessages.add("El postulante se registró de manera satisfactoria.");
		} catch (BusinessLogicPostuMOTException e) {
			List<String> errorMessages = new ArrayList<>();
			errorMessages.add(e.getUserMessage());
		} catch (Exception e) {
			List<String> errorMessages = new ArrayList<>();
			errorMessages.add("Se ha presentado un problema tratando de registrar la información de un nuevo postulante.");
		}
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
