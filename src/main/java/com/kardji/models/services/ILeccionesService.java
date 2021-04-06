package com.kardji.models.services;

import java.util.List;

import com.kardji.models.entity.Lecciones;

public interface ILeccionesService {
	
	public List<Lecciones> findAll();
	
	public Lecciones findById(int id);
}
