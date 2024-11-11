package co.edu.uco.postumot.geografias.businesslogic.usecase.state.impl;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.geografias.businesslogic.usecase.state.StateExists;
import co.edu.uco.postumot.geografias.data.dao.DAOFactoryGeografias;
import co.edu.uco.postumot.geografias.entity.StateEntity;

public final class StateExistsImpl implements StateExists {

	@Override
	public void execute(final UUID data, final DAOFactoryGeografias factory) {
		var state = ObjectHelper.getDefault(factory.getStateDAO().findByID(data), new StateEntity());

		if (data.compareTo(state.getId()) != 0) {
			var userMessage = "No existe un departamento con el identificador " + data.toString();
			throw BusinessLogicPostuMOTException.crear(userMessage);
		}
	}
}
