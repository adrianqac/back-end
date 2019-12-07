package com.dish.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dish.model.DProyecto;
import com.dish.model.DUsuario;
import com.dish.service.ProyectoService;
import com.dish.service.UsuarioService;

/**
 * Esta clase define la api rest y como es que se va acceder a cada servicio
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DishController {

	//Inyeccion de dependencias
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private UsuarioService usuarioService;

	
	/**
	 * Servicio que no tiene seguridad, acceder a la lsita de todos los proyectos
	 *
	 * @return regresa una lista de todos los proyectos
	 */
	@RequestMapping(value = "/proyectos", method = RequestMethod.GET, produces = "application/json")
	public List<DProyecto> proyectos() {
		try {
			return proyectoService.getAllProyectos();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Servicio que nos regresa un proyecto dependiedo de su ID
	 *
	 * @return regresa un proyecto 
	 */
	@RequestMapping(value = "/proyectos/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<DProyecto> proyectoById(@PathVariable Integer id) {
		try {
			return proyectoService.getProyectoById(id);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Servicio que elimina un proyecto dependiendo del id que se le envíe
	 *
	 * @param id del proyecto que queremos eliminar
	 * @return regresa un booleano para saber si fue exitosa la consulta o no
	 */
	@RequestMapping(value = "/proyectos/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public boolean delete(@PathVariable Integer id) {
		try {
			return proyectoService.delete(id);
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Servicio que inserta un proyecto en base de datos
	 *
	 * @param el parametro es el proyecto que se va a insertar 
	 * @return regresa un booleano para saber si fue exitosa la consulta o no
	 */
	@RequestMapping(value = "/proyectos/nuevo", method = RequestMethod.POST, produces = "application/json")
	public boolean nuevo(DProyecto proyecto) {
		try {
			return proyectoService.nuevo(proyecto);
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Servicio que actualiza un proyecto dependiendo del id que se le envíe y su
	 * información
	 *
	 * @param el parametro es el proyecto que se va a actualizar
	 * @return regresa un booleano para saber si fue exitosa la consulta o no
	 */
	@RequestMapping(value = "/proyectos/update", method = RequestMethod.PATCH, produces = "application/json")
	public boolean update(DProyecto proyecto) {
		try {
			return proyectoService.nuevo(proyecto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	/**
	 * Servicio que tiene seguridad, para acceder favor de loggearse con alguna
	 * de estas credenciales; usuario: user contraseña: pass usuario: admin
	 * contraseña: admin
	 *
	 * @return regresa una lista de todos los proyectos
	 */
	@RequestMapping(value = "/auth/proyectos")
	@ResponseBody
	public List<DProyecto> proyectosAuth() {
		try {
			return proyectoService.getAllProyectos();
		} catch (Exception e) {
			return null;
		}

	}
	
	/**
	 * Servicio que obtiene un usuario dependiendo de las credenciales recibidas
	 *
	 * @param recibe un usuario para poder accedr al user y pass
	 * @return si encuentra coincidencias regresa un usario
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DUsuario login(DUsuario usuario) {
		try {
			return usuarioService.login(usuario);
		} catch (Exception e) {
			return null;
		}

	}

}
