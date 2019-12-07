/**
*
* @author Adrian Vazquez
*/
package com.dish.service;

import java.util.List;
import java.util.Optional;

import com.dish.model.DProyecto;

/**
 * Interfaz que define las firmas de los metodos que vamos a implementar
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */
public interface ProyectoService {
	
	public List<DProyecto> getAllProyectos() throws Exception;
	
	public Optional<DProyecto> getProyectoById(Integer id) throws Exception;
	
	public boolean delete(Integer id) throws Exception;
	
	public boolean nuevo(DProyecto proyecto) throws Exception;
	
	public boolean update(DProyecto proyecto) throws Exception;
}
