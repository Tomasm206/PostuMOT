package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.impl;

import java.util.List;

import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.crosscutting.exception.PostuMOTException;
import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.dto.PostulanteDTOAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.FindPostulante;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;

public final class FindPostulanteImpl implements FindPostulante {

	@Override
	public List<PostulanteDTO> execute(PostulanteDTO data) {
		var factory = DAOFactoryPostulante.getFactory(DAOSource.POSTGRESQL);

		try {
//			transaccion good
			
//			Lo que entra a la capa de negocio son los DTOS
			var findPostulanteUseCase = new FindPostulanteImpl();
			var postulanteDomain = PostulanteDTOAdapter.getPostulanteDTOAdapter().adaptSource(data);
			
			return PostulanteDTOAdapter.getPostulanteDTOAdapter().adaptSource(findPostulanteUseCase.execute(postulanteDomain));
			

		} catch (final PostuMOTException exception) {
//			Falla la transaccion
			throw exception;
		}  catch (final Exception exception) { 
			var usserMessage = "Se ha presentado un problema tratando de consultar la informacion de una nueva ciudad";
			var technicalMessage = "Se ha presentado un problema inesperado consultando la informacion de la nueva ciudad. Por favor revise el log para tener más detalles...";
			
			throw BusinessLogicPostuMOTException.crear(usserMessage, technicalMessage);
		}finally {
			factory.closeConnection();
		}
	}
}
