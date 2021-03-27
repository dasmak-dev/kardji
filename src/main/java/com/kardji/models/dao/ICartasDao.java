package com.kardji.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.kardji.models.entity.Cartas;

public interface ICartasDao extends CrudRepository<Cartas,Integer> {

}
