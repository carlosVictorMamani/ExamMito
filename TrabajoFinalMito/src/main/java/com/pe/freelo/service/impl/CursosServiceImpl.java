package com.pe.freelo.service.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.freelo.documento.Cursos;
import com.pe.freelo.repo.ICursosRepo;
import com.pe.freelo.repo.IGenericRepo;
import com.pe.freelo.service.ICursosService;

@Service
public class CursosServiceImpl extends ICRUDImpl<Cursos, String> implements ICursosService{

	@Autowired
	private ICursosRepo repo;
	
	@Override
	protected IGenericRepo<Cursos, String> getRepo(){
		return repo;
	}

	
}
