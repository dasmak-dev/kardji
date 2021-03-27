package com.kardji.models.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kardji.models.dao.ICartasDao;
import com.kardji.models.entidades.Cartas;

@Service
public class CartasServiceImpl implements ICartasService {

	@Autowired
	private ICartasDao cartasDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cartas> findAll() {
		return (List<Cartas>) cartasDao.findAll();
	}

	@Override
	public Cartas findeById(int id) {
		return cartasDao.findById(id).orElse(null);
	}

	
}
