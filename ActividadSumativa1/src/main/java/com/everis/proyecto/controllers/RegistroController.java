package com.everis.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.proyecto.models.Registro;
import com.everis.proyecto.services.RegistroServicio;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	
	
	//dependencia servicio
	private final RegistroServicio gato;
	
	public RegistroController(RegistroServicio registroServicio) {
		this.gato = registroServicio;
	}
	
//@ModelAttribute("empleado") Empleado empleado, ejemplo pasar entidad a un jsp
	@RequestMapping("")
	public String index(@ModelAttribute("registro") Registro registro,Model model ) {
		//System.out.println("index");
		
		List<Registro> lista_registros = gato.findAll();
		model.addAttribute("lista_registros", lista_registros);
		
		return "registro.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("registro") Registro registro) {
		System.out.println("crear "+ registro);
		//llamado a guardar la entidad
	
		
		
		//return "redirect:/usuario"; 
		 
		//Validación
		
		//En caso de un campo vacío
  	  	if( registro.getApellido().isBlank() || registro.getNombre().isBlank() || registro.getRut().isBlank() || registro.getEmail().isBlank() || registro.getPassword().isBlank() ) {
			
 			System.out.println("Error de tipo campo vacio");
			
 			return "redirect:/registro";
	 } 
		  
		
		//Verificar largo de apellido y nombre
		 if(registro.getApellido().length() < 3 || registro.getApellido().length() > 20 || registro.getNombre().length() < 3 || registro.getNombre().length() > 20) {
			
			System.out.println("Error El de longitud en el apellido/nombre");
			System.out.println("minimo de 3 carácteres y máximo de 20");
			
			return "redirect:/registro";
		  }
		
		//verificar si el email tiene una length correcta
	 	if(registro.getEmail().length() < 10){
			
			System.out.println("Error de longitud en el Email");
			
			return "redirect:/registro";
		}
		
		
		//Verificar si el ruta tiene un largo correcto
		if(registro.getRut().length() != 9) {
			
			System.out.println("Error rut incorrecto");
			return "redirect:/registro";
	}   
		
		//Verificar Password 
		if(registro.getPassword()!="CLIENTE") {
			System.out.println("Error password incorrecto");
			return "redirect:/registro";
			
		}
		
	    Registro regis =  gato.insertarRegistro(registro);
		return "registro.jsp"; 
	}
	
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: "+ id); 
		
		Registro regis=gato.buscarRegistro(id); 
		model.addAttribute("registro", regis);
		//model.addAttribute("lista_usuarios",usuarioServicio.findAll())
		
		return "modificarRegistro.jsp";
	} 
	
	
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("registro") Registro registro) {
		System.out.println("modificar");
		
		
		  
		
		if(registro.getApellido().isBlank() || registro.getNombre().isBlank() || registro.getRut().isBlank() || registro.getEmail().isBlank()) {
			
			System.out.println("Error de tipo campo vacio");
			
			gato.modificarRegistro(registro);
			return "redirect:/registro";
		}
		
		//Verificar largo de apellido y nombre
		if(registro.getApellido().length() < 3 || registro.getApellido().length() > 20 || registro.getNombre().length() < 3 || registro.getNombre().length() > 20) {
			
			System.out.println("Error El de longitud en el apellido/nombre");
			System.out.println("minimo de 3 carácteres y máximo de 20");
			
			return "redirect:/registro";
		}
		
		//verificar si el email tiene una length correcta
		if(registro.getEmail().length() < 10){
			
			System.out.println("Error de longitud en el Email");
			
		    return "redirect:/registro";
		}
		
		
		//Verificar si el ruta tiene un largo correcto
		if(registro.getRut().length() != 9) {
			
		System.out.println("Modificacion de rut incorrecto");
			return "redirect:/registro";
		}
		gato.modificarRegistro(registro);
		return "redirect:/registro";
	}
	
	
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
	System.out.println("Eliminar id: "+ id);
		gato.eliminarRegistro(id);
		return "redirect:/registro";
}
	
	
	@RequestMapping(value="/eliminar2/{id}", method = RequestMethod.DELETE)
	public String eliminar2(@PathVariable("id") Long id) {
		System.out.println("Eliminar2 id: "+ id);
		gato.eliminarRegistro(id);
		return "redirect:/registro";
}
	
	
	@RequestMapping("/buscar")
	public String buxcar() {
		return "redirect:/registro";
	}

}
