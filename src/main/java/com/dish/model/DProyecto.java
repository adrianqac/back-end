package com.dish.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Esta clase define el modelo DProyecto respecto a la base de datos
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */

@Entity
@Table(name = "dproyecto" )
public class DProyecto {
	
	
	// Campos de la clase
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="proyectoID")
	private Integer proyectoID;
	
	@NotEmpty
	@Column(name="nombre")
	private String nombre;
	
	@NotEmpty
	@Column(name="descripcion")
	private String descripcion;	
	
	@NotEmpty
	@Column(name="projectManager")
	private String projectManager;	
	
	/**
	 * Métodos getter y setters
	 */	
	public Integer getProyectoID() {
		return proyectoID;
	}
	public void setProyectoID(Integer proyectoID) {
		this.proyectoID = proyectoID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	
}
