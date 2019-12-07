package com.dish.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dish.model.DProyecto;

/**
 * Interfaz define el respositorio de DProyecto
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */
public interface ProyectoRepository extends JpaRepository<DProyecto, Integer> {

}
