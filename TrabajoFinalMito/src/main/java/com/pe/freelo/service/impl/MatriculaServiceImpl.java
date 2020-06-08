package com.pe.freelo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.freelo.documento.Cursos;
import com.pe.freelo.documento.Matricula;
import com.pe.freelo.repo.ICursosRepo;
import com.pe.freelo.repo.IGenericRepo;
import com.pe.freelo.repo.IMatriculaRepo;
import com.pe.freelo.service.ICursosService;
import com.pe.freelo.service.IMatriculaService;

@Service
public class MatriculaServiceImpl extends ICRUDImpl<Matricula, String> implements IMatriculaService{

	@Autowired
	private IMatriculaRepo repo;
	
	@Override
	protected IGenericRepo<Matricula, String> getRepo(){
		return repo;
	}


}
