package com.kardji.models.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.kardji.controllers.dto.UserRegisterDto;
import com.kardji.models.entity.Usuarios;

public interface IUsuarioService {
	
	public List<Usuarios> findAll();
	
	public Usuarios findById(int id);
		
	public Usuarios login(String name, String password) throws NoSuchAlgorithmException;
	
	public void register(UserRegisterDto userDto) throws NoSuchAlgorithmException;
}
