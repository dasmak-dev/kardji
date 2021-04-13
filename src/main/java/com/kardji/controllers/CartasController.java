package com.kardji.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kardji.models.entity.Cartas;
import com.kardji.models.services.ICartasService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CartasController {

	@Autowired(required=true)
	private ICartasService cartasService;
	
	@GetMapping("/cartas")
	public List<Cartas> index() {
		return cartasService.findAll();
	}
	
	@GetMapping("/cartas/{id}")
	public Cartas show(@PathVariable int id) {
		return cartasService.findById(id);
		
	}
	
	@GetMapping("/cartasByLesson/{lessonId}")
	public List<Cartas> getByLesson(@PathVariable int lessonId) {
		return cartasService.findByLesson(lessonId);
	}
	
}
