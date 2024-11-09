package co.edu.uco.postumot.postulant.bussineslogic.usecase.tipodocumento.rule.impl;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.common.data.dao.DAOFactory;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.tipodocumento.rule.TipoDocumentoExists;
import co.edu.uco.postumot.postulant.entity.TipoDocumentoEntity;

public final class TipoDocumentoExistsImpl implements TipoDocumentoExists {

	@Override
	public void execute(final UUID data, final DAOFactory factory) {
		var tipoDocumento = ObjectHelper.getDefault(factory.getTipoDocumentoDAO().findByID(data), new TipoDocumentoEntity());
	
		if (data.compareTo(tipoDocumento.getId()) != 0) {
			var userMessage = "No existe un departamento con el identificador " + data.toString();
			throw BusinessLogicPostuMOTException.crear(userMessage);
		}
	}
}