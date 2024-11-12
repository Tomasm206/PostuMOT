package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.impl;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.postumot.common.crosscutting.exception.DataPostuMOTException;
import co.edu.uco.postumot.common.data.dao.enums.DAOSource;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.PostulanteAlredyExists;
import co.edu.uco.postumot.postulant.data.dao.DAOFactoryPostulante;
import co.edu.uco.postumot.postulant.entity.PostulanteEntity;

public class PostulanteAlreadyExistsImpl implements PostulanteAlredyExists {
	
	
//	public PostulanteAlreadyExistsImpl() {
//        DAOFactoryPostulante.getFactory(DAOSource.POSTGRESQL);
//    }
	
	@Override
	public void execute(final UUID data, final DAOFactoryPostulante factory) {
		var postulante = ObjectHelper.getDefault(factory.getPostulanteDAO().findByID(data), new PostulanteEntity());

		if (data.compareTo(postulante.getId()) != 0) {
			var userMessage = "No existe un postulante con el identificador " + data.toString();
			throw DataPostuMOTException.crear(userMessage);
		}
	}
}