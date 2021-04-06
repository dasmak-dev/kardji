package com.kardji.models.services;

import java.util.List;

import com.kardji.models.entity.Modalidades;

public interface IModalidadesService {
	
	public List<Modalidades> findAll();
	
	public Modalidades findById(int id);
}
