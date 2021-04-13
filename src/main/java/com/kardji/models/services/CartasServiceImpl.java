package com.kardji.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kardji.models.dao.ICartasDao;
import com.kardji.models.entity.Cartas;

@Service
public class CartasServiceImpl implements ICartasService {
	
	List<Cartas> auxKardList;

	@Autowired
	private ICartasDao cartasDao;
	
	@Override
	@Transactional(readOnly=true) 
	public List<Cartas> findAll() {
		return (List<Cartas>) cartasDao.findAll();
	}

	@Override
	public Cartas findById(int id) {
		return cartasDao.findById(id).orElse(null);
	}

	@Override
	public List<Cartas> findByLesson(int lessonId) {
		auxKardList = (List<Cartas>) cartasDao.findAll();
		return auxKardList.stream()
				.filter(carta -> carta.getLecciones().getId() == lessonId)
				.collect(Collectors.toList());
	}

	
}
