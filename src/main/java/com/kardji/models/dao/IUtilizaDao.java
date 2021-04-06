package com.kardji.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.kardji.models.entity.Utiliza;
import com.kardji.models.entity.UtilizaId;

public interface IUtilizaDao extends CrudRepository<Utiliza,UtilizaId> {

}
