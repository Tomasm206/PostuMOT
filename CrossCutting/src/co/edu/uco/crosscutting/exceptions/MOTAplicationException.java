package co.edu.uco.crosscutting.exceptions;

import co.edu.uco.crosscutting.exceptions.enums.Layer;
import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;

public class MOTAplicationException extends RuntimeException{

	private static final long serialVersionUID = 6572638353638850354L;

	private String userMessage;
	private Layer layer;
	
	
	public MOTAplicationException(final String userMessage,
			final String technicalMessage,
			final Exception rootException, 
			final Layer layer) {
		super(TextHelper.applyTrim(technicalMessage), ObjectHelper.getDefault(rootException, new Exception()));

		setUserMessage(userMessage);
		setLayer(layer);
	}
	private void setUserMessage(final String userMessage) {
		this.userMessage = TextHelper.applyTrim(userMessage);
	}
	
	
	private void setLayer(final Layer layer) {
		this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
	public Layer getLayer() {
		return layer;
	}
}


