package com.kardji.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kardji.models.dao.ILeccionesDao;
import com.kardji.models.entity.Lecciones;

@Service
public class LeccionesServiceImpl implements ILeccionesService {
	
	@Autowired
	private ILeccionesDao leccionesDao;
	
	@Override
	@Transactional(readOnly=true) 
	public List<Lecciones> findAll() {
		return (List<Lecciones>) leccionesDao.findAll();
	}

	@Override
	public Lecciones findById(int id) {
		return leccionesDao.findById(id).orElse(null);
	}
}
