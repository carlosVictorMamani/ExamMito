package com.pe.freelo.service;

import com.pe.freelo.documento.Estudiantes;

import reactor.core.publisher.Flux;

public interface IEstudiantesService extends ICRUD<Estudiantes, String>{

	public Flux<Estudiantes> findByOrderByEdadDesc();

}
