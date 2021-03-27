package com.kardji.models.servicios;

import java.util.List;

import com.kardji.models.entidades.Cartas;


public interface ICartasService {
	
	public List<Cartas> findAll();
	
	public Cartas findeById(int id);
}
