package co.edu.uco.postumot.postulant.bussineslogic.facade.postulante.impl;

import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.crosscutting.exception.PostuMOTException;
import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.dto.PostulanteDTOAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.facade.postulante.RegisterNewPostulanteFacade;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.impl.RegisterNewPostulanteImpl;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;

public final class RegisterNewPostulanteFacadeImpl implements RegisterNewPostulanteFacade {

	@Override
	public void execute(PostulanteDTO data) {
		var factory = DAOFactoryPostulante.getFactory(DAOSource.POSTGRESQL);
		
		try {
//			transaccion good
			factory.initTransaction();
			
//			Lo que entra a la capa de negocio son los DTOS
			var registerNewPostulanteUseCase = new RegisterNewPostulanteImpl();
			var postulanteDomain = PostulanteDTOAdapter.getPostulanteDTOAdapter().adaptSource(data);
			
			registerNewPostulanteUseCase.execute(postulanteDomain);
			
			factory.commitTransaction();
		} catch (final PostuMOTException exception) {
			factory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			factory.rollbackTransaction();
			var usserMessage = "Se ha presentado un problema tratando de registrar la informacion de una nuevo postulante";
			var technicalMessage = "Se ha presentado un problema inesperado registrando la informacion de la nuevo postulante. Por favor revise el log para tener más detalles...";
			
			throw BusinessLogicPostuMOTException.crear(usserMessage, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}
	}
}
