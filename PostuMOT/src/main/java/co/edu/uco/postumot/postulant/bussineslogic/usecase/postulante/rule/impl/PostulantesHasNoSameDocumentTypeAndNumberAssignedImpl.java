package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.impl;

import co.edu.uco.postumot.common.bussineslogic.usecase.DAOFactory;
import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.PostulantesHasNoSameDocumentTypeAndNumberAssigned;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;
import co.edu.uco.postumot.postulant.entity.TipoDocumentoEntity;

public class PostulantesHasNoSameDocumentTypeAndNumberAssignedImpl implements PostulantesHasNoSameDocumentTypeAndNumberAssigned{

	@Override
	public void execute(final PostulanteDomain data, final DAOFactoryPostulante factory) {
		final var documentoYTipoDoc = new PostulanteEntity();
		documentoYTipoDoc.setDocumento(data.getDocumento());
		documentoYTipoDoc.setFirstName(data.getFirstName());
		documentoYTipoDoc.setLastName(data.getLastName());
		
		final var tipoDocumento = new TipoDocumentoEntity();
		tipoDocumento.setId(data.getTipoDocumento().getId());
		
		documentoYTipoDoc.setTipoDocumento(tipoDocumento);
		
		var results = factory.getPostulanteDAO().findByFilter(documentoYTipoDoc);
		
		if (!results.isEmpty()) {
			var userMessage = "Ya existe una Postulante con Tipo de Documento " + results.get(0).getTipoDocumento().getName() + " para el número de documento " 
		+ results.get(0).getDocumento() + " asignado a " + results.get(0).getFirstName() + " " + results.get(0).getLastName();
			throw BusinessLogicPostuMOTException.crear(userMessage);
		}
	}

	@Override
	public void execute(PostulanteDomain data, DAOFactory factory) {
		// TODO Auto-generated method stub
		
	}


}
