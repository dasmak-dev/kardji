package com.kardji.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kardji.models.entity.Utiliza;
import com.kardji.models.entity.UtilizaId;
import com.kardji.models.services.IUtilizaService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class UtilizaController {
	
	@Autowired(required=true)
	private IUtilizaService utilizaService;
	
	@GetMapping("/utiliza")
	public List<Utiliza> index() {
		return utilizaService.findAll();
	}
	
	@GetMapping("/utiliza/{id}")
	public Utiliza findById(@PathVariable UtilizaId id) {
		
		System.out.println("********************************************************************************************");
		System.out.println("********************************************************************************************");
		System.out.println("********************************************************************************************");
		System.out.println("********************************************************************************************");
		System.out.println("********************************************************************************************");
		System.out.println("UtilizaId -> " + id);
		return utilizaService.findById(id);
		
	}
	
	@PostMapping("/utiliza")
	@ResponseStatus(HttpStatus.CREATED)
	public Utiliza create(@RequestBody Utiliza utiliza) {
		utilizaService.save(utiliza);
		return utiliza;
	}
	
	

}
