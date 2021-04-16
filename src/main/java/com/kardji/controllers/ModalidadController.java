package com.kardji.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kardji.models.entity.Modalidades;
import com.kardji.models.services.IModalidadesService;

@RestController
public class ModalidadController {
	
	@Autowired(required=true)
	private IModalidadesService modalidadService;
	
	@GetMapping("/modalidad")
	public List<Modalidades> index() {
		return modalidadService.findAll();
	}
	
	@GetMapping("/modalidad/{id}")
	public Modalidades show(@PathVariable int id) {
		return modalidadService.findById(id);
	}

}
