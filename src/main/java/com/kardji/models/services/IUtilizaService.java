package com.kardji.models.services;

import java.util.List;

import com.kardji.models.entity.Utiliza;
import com.kardji.models.entity.UtilizaId;

public interface IUtilizaService {
	
	public List<Utiliza> findAll();
	
	public Utiliza findById(UtilizaId id);

	public Utiliza save(Utiliza utiliza);
}
