package co.edu.uco.postumot.postulant.controllers.response.concrete;

import java.util.List;

import co.edu.uco.postumot.postulant.controllers.response.Response;
import co.edu.uco.postumot.postulant.controllers.response.ResponseWithData;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;

public final class PostulanteResponse extends ResponseWithData<PostulanteDTO> {
	
	public static final Response build(final List<String> messages, final List<PostulanteDTO> data) {
		var response = new PostulanteResponse();
		response.setMessages(messages);
		response.setData(data);
		
		return response;
	}

}
