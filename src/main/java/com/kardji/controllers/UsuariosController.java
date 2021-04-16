package com.kardji.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kardji.models.entity.Usuarios;
import com.kardji.models.services.IUsuarioService;

@RestController
public class UsuariosController {

	@Autowired(required=true)
	private IUsuarioService usuariosService;
	
	@GetMapping("/users")
	public List<Usuarios> index() {
		return usuariosService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Usuarios show(@PathVariable int id) {
		return usuariosService.findById(id);
	}
	
	
}