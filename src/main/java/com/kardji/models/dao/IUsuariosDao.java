package com.kardji.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kardji.models.entity.Usuarios;
@Transactional
public interface IUsuariosDao extends CrudRepository<Usuarios,Integer>{

	@Query("select u from Usuarios u where name = ?1 and password = ?2")
	Usuarios login(String name, String password);

}
