/**
*
* @author Adrian Vazquez
*/
package com.dish.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dish.model.DProyecto;
import com.dish.repository.ProyectoRepository;

/**
 * Clase que implementa y da acción a los métodos de la interfaz
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */
@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	@Autowired
	private ProyectoRepository repository;

	@Override
	public List<DProyecto> getAllProyectos() throws Exception {
		return repository.findAll();
	}

	@Override
	public Optional<DProyecto> getProyectoById(Integer id) throws Exception {
		return repository.findById(id);
	}

	@Override
	public boolean delete(Integer id) throws Exception {		
		if (repository.findById(id).isPresent()) {				
			repository.deleteById(id);				
			return true;			
		}		
		return false;
	}

	@Override
	public boolean nuevo(DProyecto proyecto) throws Exception {
		if(Objects.nonNull(proyecto)) {
			repository.save(proyecto);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(DProyecto proyecto) throws Exception {
		Integer id = proyecto.getProyectoID();
		if(Objects.nonNull(id) && repository.findById(id).isPresent()) {
			DProyecto p = new DProyecto();
			p.setDescripcion(proyecto.getDescripcion());
			p.setNombre(proyecto.getNombre());
			p.setProyectoID(proyecto.getProyectoID());
			repository.save(proyecto);
			return true;
		}
		return false;
	}

}
