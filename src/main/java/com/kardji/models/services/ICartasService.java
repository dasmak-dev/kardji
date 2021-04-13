package com.kardji.models.services;

import java.util.List;
import com.kardji.models.entity.Cartas;


public interface ICartasService {
	
	public List<Cartas> findAll();
	
	public Cartas findById(int id);
	
	public List<Cartas> findByLesson(int lessonId);
}
