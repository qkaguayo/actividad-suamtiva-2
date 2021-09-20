package com.everis.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.proyecto.models.Usuario;
import com.everis.proyecto.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

@Autowired
	private UsuarioService us;

//@Autowired
	//private ProductoService ProductoService;
	
	
	@RequestMapping("")
	public String index(@ModelAttribute("usuario") Usuario usuario,Model model ) {
	List<Usuario> lista_usuarios = us.findAll(); 
	model.addAttribute("lista_usuarios", lista_usuarios);
	
	return "usuario.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario) {
	System.out.println("crear "+ usuario);
	if(usuario.getApellido().isBlank() || usuario.getNombre().isBlank() || usuario.getRut().isBlank()) {
		System.out.println("Error de tipo campo vacio");
		
		return "redirect:/usuario";
	}
	
	//Verificar largo de apellido y nombre
	if(usuario.getApellido().length() < 3 || usuario.getApellido().length() > 20 || usuario.getNombre().length() < 3 || usuario.getNombre().length() > 20) {
		
		System.out.println("Error El de longitud en el apellido/nombre");
		System.out.println("minimo de 3 carácteres y máximo de 20");
		
		return "redirect:/usuario";
	}
	
	//Verificar si el ruta tiene un largo correcto
	if(usuario.getRut().length() != 9) {
		
		System.out.println("Error rut incorrecto");
		return "redirect:/usuario";
	}
	
	// Termino de validación
	
	
	us.insertarUsuario(usuario);
	
	return "redirect:/usuario";
	}
	
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id,Model model) {
	System.out.println("actualizar id: "+ id);
	
	Usuario usuario=us.buscarUsuario(id);
	model.addAttribute("usuario",usuario);
	
	return "editar_usuario.jsp";
	}
	
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario) {
	System.out.println("modificar");
	//En caso de un campo vacío te avisa por consola
		if(usuario.getApellido().isBlank() || usuario.getNombre().isBlank() || usuario.getRut().isBlank()) {
			System.out.println("Error de tipo campo vacio");
			return "redirect:/usuario";
		}
		
		//Verificar largo de apellido y nombre
		if(usuario.getApellido().length() < 3 || usuario.getApellido().length() > 20 || usuario.getNombre().length() < 3 || usuario.getNombre().length() > 20) {
			
			System.out.println("Error El de longitud en el apellido/nombre");
			System.out.println("minimo de 3 carácteres y máximo de 20");
			
			return "redirect:/usuario";
		}
		
		//Verificar si el ruta tiene un largo correcto
		if(usuario.getRut().length() != 9) {
			
			System.out.println("Modificacion de rut incorrecto");
			return "redirect:/usuario";
		}
		
	
	us.modificarUsuario(usuario);
	
	return "redirect:/usuario";
	
	}
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		
	System.out.println("Eliminar id: "+ id);
	
	us.eliminarUsuario(id);
	return "redirect:/usuario";
	}
	
	@RequestMapping("/buscar")
	public String buscar() {
	return "redirect:/usuario";
	}
		
}
