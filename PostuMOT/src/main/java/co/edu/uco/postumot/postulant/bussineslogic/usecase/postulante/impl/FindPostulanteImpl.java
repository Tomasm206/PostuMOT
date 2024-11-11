package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.crosscutting.exception.PostuMOTException;
import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.dto.PostulanteDTOAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.entity.PostulanteEntityAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.FindPostulante;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public final class FindPostulanteImpl implements FindPostulante {

	@Override
	public List<PostulanteDTO> execute(PostulanteDTO data) {
	    var factory = DAOFactoryPostulante.getFactory(DAOSource.POSTGRESQL);

	    try {
	        // Convierte el DTO a un objeto de dominio
	        var postulanteDomain = PostulanteDTOAdapter.getPostulanteDTOAdapter().adaptSource(data);
	        var postulanteDAO = factory.getPostulanteDAO();

	        // Obtén el UUID desde el objeto de dominio
	        UUID id = postulanteDomain.getId();

	        // Llama a findByID usando el UUID
	        PostulanteEntity postulanteEntity = postulanteDAO.findByID(id);

	        // Lanza una excepción si no se encuentra el postulante
	        if (postulanteEntity == null) {
	            throw BusinessLogicPostuMOTException.crear("No se encontró el postulante con el ID especificado");
	        }

	        // Si se encuentra el postulante, conviértelo a PostulanteDomain y luego a PostulanteDTO
	        var postulanteDomainResult = PostulanteEntityAdapter.getPostulanteEntityAdapter().adaptSource(postulanteEntity);
	        return List.of(PostulanteDTOAdapter.getPostulanteDTOAdapter().adaptTarget(postulanteDomainResult));

	    } catch (final PostuMOTException exception) {
	        throw exception;
	    } catch (final Exception exception) {
	        var userMessage = "Se ha presentado un problema tratando de consultar la información de los postulantes.";
	        var technicalMessage = "Se ha presentado un problema inesperado consultando la información de los postulantes. Por favor revise el log para tener más detalles...";
	        throw BusinessLogicPostuMOTException.crear(userMessage, technicalMessage);
	    } finally {
	        factory.closeConnection();
	    }
	}


}
