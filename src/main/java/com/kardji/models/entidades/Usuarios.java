package com.kardji.models.entidades;
// Generated 27 mar. 2021 17:10:37 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "usuarios")
public class Usuarios implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String type;
	private String name;
	private Date registerDate;
	private Date lastLogIn;
	private String password;
	private String imageUrl;
	private Set<Utiliza> utilizas = new HashSet<Utiliza>(0);

	public Usuarios() {
	}

	public Usuarios(int id, Date registerDate, String password) {
		this.id = id;
		this.registerDate = registerDate;
		this.password = password;
	}

	public Usuarios(int id, String type, String name, Date registerDate, Date lastLogIn, String password,
			String imageUrl, Set<Utiliza> utilizas) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.registerDate = registerDate;
		this.lastLogIn = lastLogIn;
		this.password = password;
		this.imageUrl = imageUrl;
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

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "registerDate", nullable = false, length = 13)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lastLogIn", length = 13)
	public Date getLastLogIn() {
		return this.lastLogIn;
	}

	public void setLastLogIn(Date lastLogIn) {
		this.lastLogIn = lastLogIn;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "imageUrl")
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Utiliza> getUtilizas() {
		return this.utilizas;
	}

	public void setUtilizas(Set<Utiliza> utilizas) {
		this.utilizas = utilizas;
	}

}
