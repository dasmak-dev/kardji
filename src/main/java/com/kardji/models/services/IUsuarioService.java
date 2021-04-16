package com.kardji.models.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.kardji.models.entity.Usuarios;

public interface IUsuarioService {
	
	public List<Usuarios> findAll();
	
	public Usuarios findById(int id);
	
	public Usuarios save(Usuarios usuario);
	
	public Usuarios login(String name, String password) throws NoSuchAlgorithmException;
}
