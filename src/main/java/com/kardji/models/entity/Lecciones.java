package com.kardji.models.entity;
// Generated 27 mar. 2021 17:10:37 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Lecciones generated by hbm2java
 */
@Entity
@Table(name = "lecciones")
public class Lecciones implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private String imageUrl;
	private Set<Cartas> cartases = new HashSet<Cartas>(0);
	private Set<Utiliza> utilizas = new HashSet<Utiliza>(0);

	public Lecciones() {
	}

	public Lecciones(int id) {
		this.id = id;
	}

	public Lecciones(int id, String name, String description, String imageUrl, Set<Cartas> cartases, Set<Utiliza> utilizas) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.cartases = cartases;
		this.utilizas = utilizas;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "imageUrl")
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lecciones")
	public Set<Cartas> getCartases() {
		return this.cartases;
	}

	public void setCartases(Set<Cartas> cartases) {
		this.cartases = cartases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lecciones")
	@JsonIgnore
	public Set<Utiliza> getUtilizas() {
		return this.utilizas;
	}

	public void setUtilizas(Set<Utiliza> utilizas) {
		this.utilizas = utilizas;
	}

}
