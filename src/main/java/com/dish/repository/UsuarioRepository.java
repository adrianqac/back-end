package com.dish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dish.model.DUsuario;

/**
 * Clase que define un repositorio de DUsuario
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */

public interface UsuarioRepository extends JpaRepository<DUsuario, Integer>, UsuarioCustomRepository {

}
