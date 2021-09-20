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

import com.everis.proyecto.models.Venta;
import com.everis.proyecto.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {

	private final VentaService vs;
	public VentaController(VentaService ventaService){
		this.vs = ventaService;
	}
	
	@RequestMapping("")
	public String index (@ModelAttribute("venta") Venta venta, Model model) {
		System.out.println("index");
		
		List<Venta> lista_ventas = vs.findAll();
		model.addAttribute("lista_ventas", lista_ventas);
		
		return "venta.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("venta") Venta venta) {
		System.out.println("crear"+ venta.getId());
		
		Venta ven = vs.insertarVenta(venta);
		return "redirect:/venta";
	}
	
	//METODO ACTUALIZAR
		@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
		public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: "+ id);
		
		Venta venta = vs.buscarVenta(id);
		
		model.addAttribute("venta", venta);
		return "editar_venta.jsp";
		}
		
		@RequestMapping(value="/modificar", method= RequestMethod.PUT)
		public String modificar(@Valid @ModelAttribute("venta") Venta venta) {
			
			System.out.println("el id a modificar es: " + venta.getId());
			vs.modificarVenta(venta);
			
			return "redirect:/venta";
		}
	
		//METODO ELIMINAR
		@RequestMapping(value="/eliminar", method = RequestMethod.POST)
		public String eliminar(@RequestParam("id") Long id) {
			System.out.println("eliminar id: " + id);
			vs.eliminarVenta(id);
			
			return "redirect:/venta";
		}	
		
		
		@RequestMapping("/buscar")
		public String buscar() {
			return "venta.jsp";
		}
		
}
