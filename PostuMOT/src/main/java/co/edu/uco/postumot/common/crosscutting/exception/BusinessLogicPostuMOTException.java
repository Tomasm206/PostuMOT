package co.edu.uco.postumot.common.crosscutting.exception;

import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class BusinessLogicPostuMOTException extends PostuMOTException {

	private static final long serialVersionUID = 1L;

	public BusinessLogicPostuMOTException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.BUSINESSLOGIC);
	}

	public static final BusinessLogicPostuMOTException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new BusinessLogicPostuMOTException(userMessage, technicalMessage, rootException);
	}

	public static final BusinessLogicPostuMOTException crear(final String userMessage) {
		return new BusinessLogicPostuMOTException(userMessage, userMessage, new Exception());
	}

	public static final BusinessLogicPostuMOTException crear(final String userMessage, final String technicalMessage) {
		return new BusinessLogicPostuMOTException(userMessage, technicalMessage, new Exception());
	}


}
