package co.edu.uco.postumot.common.crosscutting.exception;

import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class DataPostuMOTException extends PostuMOTException{

	private static final long serialVersionUID = 1L;

	public DataPostuMOTException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DATA); // Cambia ya que no manda Layer
	}

	public static final DataPostuMOTException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataPostuMOTException(userMessage, technicalMessage, rootException);
	}

	public static final DataPostuMOTException crear(final String userMessage) {
		return new DataPostuMOTException(userMessage, userMessage, new Exception());
	}

	public static final DataPostuMOTException crear(final String userMessage, final String technicalMessage) {
		return new DataPostuMOTException(userMessage, technicalMessage, new Exception());
	}
	// Los hijos usan el "final", lo que da a entender que son datos de escritura
	// final
	// En caso del papa "UcoBetException", no puede tener el final ya que esta clase
	// evidentemente sobreescribe.
}
