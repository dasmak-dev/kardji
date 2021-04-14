package com.kardji.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kardji.models.entity.Lecciones;
import com.kardji.models.services.ILeccionesService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class LeccionesController {

	@Autowired(required=true)
	private ILeccionesService leccionesService;
	
	@GetMapping("/lecciones")
	public List<Lecciones> index() {
		return leccionesService.findAll();
	}
	
	@GetMapping("/lecciones/{id}")
	public Lecciones show(@PathVariable int id) {
		return leccionesService.findById(id);
	}
	
}
