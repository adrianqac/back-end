package com.dish.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Esta clase define el modelo DUsuario respecto a la base de datos
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */

@Entity
@Table(name = "dusuario" )
public class DUsuario {
	
	
	// Campos de la clase
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="usuarioID")
	private Integer usuarioID;
	
	@NotEmpty
	@Column(name="usuario")
	private String usuario;
	
	@NotEmpty
	@Column(name="pass")
	private String pass;

	
	/**
	 * Métodos getter y setters
	 */
		
	public Integer getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(Integer usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}		

}
