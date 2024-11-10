package co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.impl;

import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.postumot.common.crosscutting.exception.BusinessLogicPostuMOTException;
import co.edu.uco.postumot.postulant.bussineslogic.usecase.postulante.rule.PostulanteNameConsistencyIsValid;

public class PostulanteNameConsistencyIsValidImpl implements PostulanteNameConsistencyIsValid {

	@Override
	public void execute(final String data) {
		validateNotNull(data);
		validateLen(data);
		validateFormat(data);
	}
	
	private void validateLen(final String data) {
		if (TextHelper.maxlenIsValid(data, 60)){
			var userMessage = "Los nombres o apellidos del postulante debe tener máximo 60 caracteres...";
			throw BusinessLogicPostuMOTException.crear(userMessage);
		}
	}
	
	private void validateFormat(final String data) {
		if (TextHelper.containsOnlyLettersAndSpaces(data)) {
			var userMessage = "Los nombres o apellidos del Postulante solo puede contener letras y espacios...";
			throw BusinessLogicPostuMOTException.crear(userMessage);
		}
	}
	
	private void validateNotNull(final String data) {
		if (TextHelper.isEmpty(data)) {
			var userMessage = "El nombre y apellidos del Postulante no puede estar vacío...";
			throw BusinessLogicPostuMOTException.crear(userMessage);
		}
	}
}
