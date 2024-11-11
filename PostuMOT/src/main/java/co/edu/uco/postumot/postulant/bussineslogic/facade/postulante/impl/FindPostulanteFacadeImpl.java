package co.edu.uco.postumot.postulant.bussineslogic.facade.postulante.impl;

import java.util.List;

import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.crosscutting.exception.PostuMOTException;
import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.dto.PostulanteDTOAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.facade.postulante.FindPostulanteFacade;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.impl.FindPostulanteImpl;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;

public final class FindPostulanteFacadeImpl implements FindPostulanteFacade{

	@Override
	public List<PostulanteDTO> execute(final PostulanteDTO data) {
		var factory = DAOFactoryPostulante.getFactory(DAOSource.POSTGRESQL);
		
		try {	
			var findPostulanteUseCase = new FindPostulanteImpl();
			var postulanteDomain = PostulanteDTOAdapter.getPostulanteDTOAdapter().adaptSource(data);	
		
			return PostulanteDTOAdapter.getPostulanteDTOAdapter().adaptTarget(findPostulanteUseCase.execute(postulanteDomain));
			
		} catch (final PostuMOTException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema tratando de consultar la informacion de la nueva ciudad...";
			var technicalMessage = "Se ha presentado un problema inesperado consultando la informacion de la nueva ciudad. por favor reise el log de errores para tener mas detalles...";
			
			throw BusinessLogicPostuMOTException.crear(userMessage, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}
	}
}
