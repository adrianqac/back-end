package com.dish.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dish.model.DUsuario;


/**
 * Clase que define un repositorio de DUsuario, para crear nuestras propias consultas
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */
public class UsuarioCustomRepositoryImpl implements UsuarioCustomRepository {
	
	@PersistenceContext
    EntityManager entityManager;

	
	/**
	 * Método que compara el usuario y contraseña respecto a la tabla dusuario
	 *
	 * @param Recibe un DUsuario como parámetro, que funciona como usuario para logearse
	 * @return regresa un DUsuario si es que esiten coincidencias si no regresa null 
	 */
	@Override
	public DUsuario login(DUsuario usuario) {
		Query query = entityManager.createNativeQuery("SELECT * FROM dusuario where usuario = ? and pass = ? ", DUsuario.class);				
		
        query.setParameter(1, usuario.getUsuario());
        query.setParameter(2, usuario.getPass());
        return (DUsuario)query.getSingleResult();
	}

}
