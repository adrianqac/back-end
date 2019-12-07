package com.dish.repository;

import com.dish.model.DUsuario;

/**
 * Interfaz que define un repositorio de DUsuario, para crear nuestras propias consultas
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */

public interface UsuarioCustomRepository {
	
	public DUsuario login(DUsuario usuario);

}
