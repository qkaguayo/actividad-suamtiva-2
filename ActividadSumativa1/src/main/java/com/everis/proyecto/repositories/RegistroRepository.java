package com.everis.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.proyecto.models.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {

}
