package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.impl;

import java.util.List;

import co.edu.uco.crosscutting.helpers.UUIDHelper;
import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.crosscutting.exception.PostuMOTException;
import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.dto.PostulanteDTOAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.adapter.entity.PostulanteEntityAdapter;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.FindPostulante;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.domain.PostulanteDomain;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public final class FindPostulanteImpl implements FindPostulante {

	@Override
	public List<PostulanteDomain> execute(final PostulanteDomain data) {
	    var factory = DAOFactoryPostulante.getFactory(DAOSource.POSTGRESQL);

	    try {
	        // Convierte el DTO a un objeto de dominio
	        var postulanteDomain = PostulanteDTOAdapter.getPostulanteDTOAdapter().adaptTarget(data);
	        var postulanteDAO = factory.getPostulanteDAO();

	        // Obtén el UUID desde el objeto de dominio
	        var id = UUIDHelper.convertToUUID(postulanteDomain.getId());

	        // Llama a findByID usando el UUID
	        PostulanteEntity postulanteEntity = postulanteDAO.findByID(id);

	        // Lanza una excepción si no se encuentra el postulante
	        if (postulanteEntity == null) {
	            throw BusinessLogicPostuMOTException.crear("No se encontró el postulante con el ID especificado");
	        }

	        // Si se encuentra el postulante, conviértelo a PostulanteDomain y luego a PostulanteDTO
	        var postulanteDomainResult = PostulanteEntityAdapter.getPostulanteEntityAdapter().adaptSource(postulanteEntity);
	        return List.of(postulanteDomainResult);

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
