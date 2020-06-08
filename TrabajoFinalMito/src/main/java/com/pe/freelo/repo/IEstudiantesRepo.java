package com.pe.freelo.repo;

import com.pe.freelo.documento.*;

import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.Query;


public interface IEstudiantesRepo  extends IGenericRepo<Estudiantes, String> {

	Flux<Estudiantes> findByOrderByEdadDesc();
}
