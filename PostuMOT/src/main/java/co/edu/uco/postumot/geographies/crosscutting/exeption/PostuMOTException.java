package co.edu.uco.postumot.geographies.crosscutting.exeption;

import co.edu.uco.crosscutting.exceptions.MOTException;
import co.edu.uco.crosscutting.exceptions.enums.Layer;

public class PostuMOTException extends MOTException{

	private static final long serialVersionUID = 1L;

	public PostuMOTException(final String userMessage, final String technicalMessage, final Exception rootException, final Layer layer) {
		super(userMessage, technicalMessage, rootException, layer);
	}
	
	public static PostuMOTException crear(final String userMessage, final String technicalMessage,
			final Exception rootException, final Layer layer) {
		return new PostuMOTException(userMessage, technicalMessage, rootException, layer);
	}
	// Cuando queremos mostrar mensajes con toda la informacion del sistema

	public static PostuMOTException crear(final String userMessage) {
		return new PostuMOTException(userMessage, userMessage, new Exception(), Layer.GENERAL);
	}
	// Que pasa cuando la app no envia todos los datos?
	// se realizan mas metodos con sobre carga, retornando valores null o por
	// defecto.

	public static PostuMOTException crear(final String userMessage, final String technicalMessage) {
		return new PostuMOTException(userMessage, technicalMessage, new Exception(), Layer.GENERAL);
	}
	// Sigue la misma logica

	// para que construir la base de excepciones?
	// identificar que puede suceder, como puede fallar el sistema.
}
