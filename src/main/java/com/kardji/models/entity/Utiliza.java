package com.kardji.models.entity;
// Generated 27 mar. 2021 17:10:37 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Utiliza generated by hbm2java
 */
@Entity
@Table(name = "utiliza")
public class Utiliza implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private UtilizaId id;
	private Lecciones lecciones;
	private Modalidades modalidades;
	private Usuarios usuarios;
	private Integer fallos;

	public Utiliza() {
	}

	public Utiliza(UtilizaId id, Lecciones lecciones, Modalidades modalidades, Usuarios usuarios) {
		this.id = id;
		this.lecciones = lecciones;
		this.modalidades = modalidades;
		this.usuarios = usuarios;
	}

	public Utiliza(UtilizaId id, Lecciones lecciones, Modalidades modalidades, Usuarios usuarios, Integer fallos) {
		this.id = id;
		this.lecciones = lecciones;
		this.modalidades = modalidades;
		this.usuarios = usuarios;
		this.fallos = fallos;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idModalidad", column = @Column(name = "idModalidad", nullable = false)),
			@AttributeOverride(name = "idLeccion", column = @Column(name = "idLeccion", nullable = false)),
			@AttributeOverride(name = "idUsuario", column = @Column(name = "idUsuario", nullable = false)),
			@AttributeOverride(name = "fecha", column = @Column(name = "fecha", nullable = false)) })
	public UtilizaId getId() {
		return this.id;
	}

	public void setId(UtilizaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idLeccion", nullable = false, insertable = false, updatable = false)
	public Lecciones getLecciones() {
		return this.lecciones;
	}

	public void setLecciones(Lecciones lecciones) {
		this.lecciones = lecciones;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idModalidad", nullable = false, insertable = false, updatable = false)
	public Modalidades getModalidades() {
		return this.modalidades;
	}

	public void setModalidades(Modalidades modalidades) {
		this.modalidades = modalidades;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario", nullable = false, insertable = false, updatable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@Column(name = "fallos")
	public Integer getFallos() {
		return this.fallos;
	}

	public void setFallos(Integer fallos) {
		this.fallos = fallos;
	}

}
