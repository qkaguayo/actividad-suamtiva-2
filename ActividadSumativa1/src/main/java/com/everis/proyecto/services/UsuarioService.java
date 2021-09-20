package com.everis.proyecto.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.proyecto.models.Usuario;
import com.everis.proyecto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository ur;
	
	public UsuarioService(UsuarioRepository usuarioRepository){
		this.ur = usuarioRepository;
	}

	public Usuario insertarUsuario(@Valid Usuario usuario) {
		// TODO Auto-generated method stub
		
		return ur.save(usuario);
	}

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	public void eliminarUsuario(Long id) {
		ur.deleteById(id);
		
	}

	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> oUsuario= ur.findById(id);
		
		if(oUsuario.isPresent()) {
			return oUsuario.get();
			
		}
		
		return null;
	}

	public void modificarUsuario(@Valid Usuario usuario) {
		ur.save(usuario);
		
	}

	
	
	
}
