package co.edu.uco.postumot.common.crosscutting.exception;

import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class EntityPostuMOTException extends PostuMOTException{

	private static final long serialVersionUID = 1L;

	public EntityPostuMOTException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}

	public static final EntityPostuMOTException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new EntityPostuMOTException(userMessage, technicalMessage, rootException);
	}

	public static final EntityPostuMOTException crear(final String userMessage) {
		return new EntityPostuMOTException(userMessage, userMessage, new Exception());
	}

	public static final EntityPostuMOTException crear(final String userMessage, final String technicalMessage) {
		return new EntityPostuMOTException(userMessage, technicalMessage, new Exception());
	}

}
