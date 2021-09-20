package com.everis.proyecto.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.proyecto.models.Registro;
import com.everis.proyecto.repositories.RegistroRepository;

@Service
public class RegistroServicio {

	//logica de negocio o empresarial
			//dependencia repository
			private final RegistroRepository rr;
			
			public RegistroServicio(RegistroRepository RegistroRepositorio) {
				this.rr = RegistroRepositorio;
			}

			public Registro insertarRegistro(@Valid Registro registro) {
				// TODO Auto-generated method stub
				return rr.save(registro);
			}

			public List<Registro> findAll() {
				// retorna una lista de empleados
				return rr.findAll();
			}

			

			public void eliminarRegistro(Long id) {
				// TODO Auto-generated method stub
				rr.deleteById(id);
			}

			
			public void modificarRegistro(@Valid Registro registro) {
				// TODO Auto-generated method stub
				rr.save(registro);
			
			

			
	}

			public Registro buscarRegistro(Long id) {
				// TODO Auto-generated method stub
				
				Optional<Registro> oRegistro= rr.findById(id);
				
				if(oRegistro.isPresent()) {
					return oRegistro.get();
				}
				return null;
			}

			
}
