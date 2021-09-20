package com.everis.proyecto.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.proyecto.models.Producto;
import com.everis.proyecto.repositories.ProductoRepository;

@Service
public class ProductoService {

	private final ProductoRepository pr;
	
	public ProductoService(ProductoRepository productoRepository){
		this.pr = productoRepository;
	}

	public Producto insertarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		
		return pr.save(producto);
	}

	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	public void eliminarProducto(Long id) {
		pr.deleteById(id);
		
	}

	public Producto buscarProducto(Long id) {
		Optional<Producto> oProducto= pr.findById(id);
		
		if(oProducto.isPresent()) {
			return oProducto.get();
			
		}
		
		return null;
	}

	public void modificarProducto(@Valid Producto producto) {
		pr.save(producto);
		
	}
	
	
	
}
