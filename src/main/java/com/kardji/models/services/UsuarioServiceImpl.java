package com.kardji.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Usuarios save(Usuarios usuario) {
		return usuariosDao.save(usuario);
	}
}
