package co.edu.uco.postumot.common.crosscutting.exception;

import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class ControllerPostuMOTException extends PostuMOTException{

	private static final long serialVersionUID = 1L;

	public ControllerPostuMOTException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
	}

	public static final ControllerPostuMOTException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ControllerPostuMOTException(userMessage, technicalMessage, rootException);
	}

	public static final ControllerPostuMOTException crear(final String userMessage) {
		return new ControllerPostuMOTException(userMessage, userMessage, new Exception());
	}

	public static final ControllerPostuMOTException crear(final String userMessage, final String technicalMessage) {
		return new ControllerPostuMOTException(userMessage, technicalMessage, new Exception());
	}


}
