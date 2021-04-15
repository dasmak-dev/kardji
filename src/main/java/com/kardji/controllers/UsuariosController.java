package com.kardji.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.kardji.models.entity.Usuarios;
import com.kardji.models.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
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
	
	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuarios create(@RequestBody Usuarios users) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(users.getId() + ", " + users.getName() + ", " + users.getPassword());
		
		users.setRegisterDate(dtf.format(LocalDateTime.now()));
		users.setLastLogIn(dtf.format(LocalDateTime.now()));
		usuariosService.save(users);
		return users;
	}
	
}