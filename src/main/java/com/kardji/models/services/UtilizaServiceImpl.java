package com.kardji.models.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kardji.models.dao.IUtilizaDao;
import com.kardji.models.entity.Utiliza;
import com.kardji.models.entity.UtilizaId;

@Service
public class UtilizaServiceImpl implements IUtilizaService {

	@Autowired
	private IUtilizaDao utilizaDao;
	
	@Override
	@Transactional(readOnly=true) 
	public List<Utiliza> findAll() {
		return (List<Utiliza>) utilizaDao.findAll();
	}

	@Override
	public Utiliza findById(UtilizaId id) {
		return utilizaDao.findById(id).orElse(null);
	}
	
	@Override
	public Utiliza save(Utiliza utiliza) {
		return utilizaDao.save(utiliza);
	}

}
