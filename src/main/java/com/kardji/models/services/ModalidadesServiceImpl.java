package com.kardji.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kardji.models.dao.IModalidadesDao;
import com.kardji.models.entity.Modalidades;

@Service
public class ModalidadesServiceImpl implements IModalidadesService {
	@Autowired
	private IModalidadesDao modalidadesDao;
	
	@Override
	@Transactional(readOnly=true) 
	public List<Modalidades> findAll() {
		return (List<Modalidades>) modalidadesDao.findAll();
	}

	@Override
	public Modalidades findById(int id) {
		return modalidadesDao.findById(id).orElse(null);
	}
}
