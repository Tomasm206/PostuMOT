package co.edu.uco.postumot.postulant.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.postumot.postulant.dto.PostulanteDTO;

@RestController
@RequestMapping
public final class PostulanteController {
	@GetMapping("/dummy")	
	public PostulanteDTO getDummy() {
		return PostulanteDTO.create();
	}
	
	@PostMapping
	public PostulanteDTO create(@RequestBody PostulanteDTO postulante) {
		return postulante;
	}
	
	@PutMapping
	public PostulanteDTO update(@PathVariable String id, @RequestBody PostulanteDTO postulante) {
		return postulante;
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		return id;
	}
	
	@GetMapping
	public List<PostulanteDTO> retrive() {
		var list = new ArrayList<PostulanteDTO>();
		
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		list.add(getDummy());
		return list;
	}
	
	@GetMapping("/{id}")
	public PostulanteDTO retriveById(@PathVariable String id) {
		return getDummy();
	}
	
}
