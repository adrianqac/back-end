package com.dish.service;

import com.dish.model.DUsuario;

/**
 * Servicio que define las firma que usremos para logearnos
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */
public interface UsuarioService {
	
	public DUsuario login(DUsuario usuario);

}
