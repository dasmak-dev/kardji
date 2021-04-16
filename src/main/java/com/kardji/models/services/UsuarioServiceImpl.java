package com.kardji.models.services;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kardji.controllers.dto.UserRegisterDto;
import com.kardji.models.dao.IUsuariosDao;
import com.kardji.models.entity.Usuarios;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuariosDao usuariosDao;
	
	@Override
	@Transactional(readOnly=true) 
	public List<Usuarios> findAll() {
		return (List<Usuarios>) usuariosDao.findAll();
	}

	@Override
	public Usuarios findById(int id) {
		return usuariosDao.findById(id).orElse(null);
	}
	
	@Override
	public Usuarios login(String name, String password) throws NoSuchAlgorithmException {
		return this.usuariosDao.login(name, password);
	}

	@Override
	public void register(UserRegisterDto userDto) throws NoSuchAlgorithmException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Usuarios usuario = new Usuarios();
		usuario.setId(userDto.getId());
		usuario.setName(userDto.getName());
		usuario.setPassword(userDto.getPassword());
		usuario.setImageUrl(userDto.getImageUrl());
		usuario.setRegisterDate(dtf.format(LocalDateTime.now()));
		usuario.setLastLogIn(dtf.format(LocalDateTime.now()));
		usuario.setType(userDto.getType());
		this.usuariosDao.save(usuario);
		
	}
	
}
