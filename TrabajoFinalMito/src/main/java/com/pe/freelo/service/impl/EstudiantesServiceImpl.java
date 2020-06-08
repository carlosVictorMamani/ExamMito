package com.pe.freelo.service.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pe.freelo.documento.Cursos;
import com.pe.freelo.documento.Estudiantes;
import com.pe.freelo.repo.ICursosRepo;
import com.pe.freelo.repo.IEstudiantesRepo;
import com.pe.freelo.repo.IGenericRepo;
import com.pe.freelo.service.ICursosService;
import com.pe.freelo.service.IEstudiantesService;

import reactor.core.publisher.Flux;

@Service
public class EstudiantesServiceImpl extends ICRUDImpl<Estudiantes, String> implements IEstudiantesService{


	@Autowired
	private IEstudiantesRepo repo;
	
	@Override
	protected IGenericRepo<Estudiantes, String> getRepo(){
		return repo;
	}

	@Override
	public Flux<Estudiantes> findByOrderByEdadDesc() {
		return 	repo.findByOrderByEdadDesc();
		
	}

	
	
}
