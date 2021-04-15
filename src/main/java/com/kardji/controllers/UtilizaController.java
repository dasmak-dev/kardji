package com.kardji.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kardji.models.entity.Utiliza;
import com.kardji.models.services.IUtilizaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UtilizaController {
	
	@Autowired(required=true)
	private IUtilizaService utilizaService;
	
	@GetMapping("/utiliza")
	public List<Utiliza> index() {
		return utilizaService.findAll();
	}
	
	@PostMapping("/utiliza")
	@ResponseStatus(HttpStatus.CREATED)
	public Utiliza create(@RequestBody Utiliza utiliza) {
		
		System.out.println("a ver si sale " + utiliza.getFallos());
		utilizaService.save(utiliza);
		return utiliza;
	}
	
	

}
