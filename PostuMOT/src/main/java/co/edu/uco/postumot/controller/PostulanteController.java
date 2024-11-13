package co.edu.uco.postumot.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.crosscutting.exceptions.MOTAplicationException;
import co.edu.uco.postumot.common.controller.response.GenerateResponse;
import co.edu.uco.postumot.common.crosscutting.exception.PostuMOTException;
import co.edu.uco.postumot.controller.response.concrete.GenericResponse;
import co.edu.uco.postumot.controller.response.concrete.PostulanteResponse;
import co.edu.uco.postumot.postulant.bussineslogic.facade.postulante.impl.RegisterNewPostulanteFacadeImpl;
import co.edu.uco.postumot.postulant.dto.PostulanteDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/postulante")
public final class PostulanteController {

	@GetMapping("/dummy")
	public PostulanteDTO getDummy() {
		return PostulanteDTO.create();
	}

	@PostMapping("/create")
	public ResponseEntity<GenericResponse> create(@RequestBody PostulanteDTO postulante) {

		var message = new ArrayList<String>();

		try {
			var registerNewPostulanteFacade = new RegisterNewPostulanteFacadeImpl();
			registerNewPostulanteFacade.execute(postulante);

			message.add("Se ha agreado el Postulante correctamente");

			return GenerateResponse.generateSuccessResponse(message);
		} catch (final PostuMOTException exception) {
			message.add(exception.getUserMessage());
			exception.printStackTrace();
		} catch (final MOTAplicationException exception) {
			message.add(exception.getUserMessage());
			exception.printStackTrace();
		} catch (final Exception exception) {
			message.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo el registro de un postulante de forma satisfactoria...");
			exception.printStackTrace();

			return GenerateResponse.generateFailedSuccessResponse(message);
		}

		message.add("El postulante se registró de manera satisfactoria");

		return GenerateResponse.generateSuccessResponse(message);
	}

	@PutMapping("/update")
	public ResponseEntity<GenericResponse> update(@PathVariable String id, @RequestBody PostulanteDTO postulante) {
		var message = new ArrayList<String>();

		message.add("El Postulante se actualizó de manera satisfactoria");

		return GenerateResponse.generateSuccessResponse(message);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<GenericResponse> delete(@PathVariable String id) {
		var message = new ArrayList<String>();

		message.add("El Postulante se eliminó de manera satisfactoria");

		return GenerateResponse.generateSuccessResponse(message);
	}

	@GetMapping("/retrive")
	public ResponseEntity<PostulanteResponse> retrive() {
		PostulanteResponse responseWithData = new PostulanteResponse();
		var message = new ArrayList<String>();

		message.add("Los Postulantes se consultaron de manera satisfactoria");

		var list = new ArrayList<PostulanteDTO>();

		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());

		responseWithData.setData(list);
		responseWithData.setData(list);

		return ((new GenerateResponse<PostulanteResponse>()).generateSuccessResponseWithData(responseWithData));
	}

	@GetMapping("/{id}")
	public PostulanteDTO retriveById(@PathVariable int id) {
		return getDummy().setDocumento(id);
	}

}
