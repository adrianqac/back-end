package com.dish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dish.model.DUsuario;
import com.dish.repository.UsuarioRepository;

/**
 * Servicio que implementa la firma de nuestra interfaz
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	/**
	 * Método que sirve para logearse dependiendo de las credenciales 
	 *
	 * @param DUsuario de donde sacaremos las credenciales
	 * @return Regresa un usuario en caso de haber coincidencia, de lo contrario regresa null
	 */
	@Override
	public DUsuario login(DUsuario usuario) {
		return repository.login(usuario);
	}

}
