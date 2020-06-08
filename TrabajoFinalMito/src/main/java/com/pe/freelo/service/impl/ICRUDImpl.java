package com.pe.freelo.service.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.pe.freelo.documento.Estudiantes;
import com.pe.freelo.repo.IGenericRepo;
import com.pe.freelo.service.ICRUD;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class ICRUDImpl<T, ID> implements ICRUD<T, ID> {
	
	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public Mono<T> registrar(T t) {
		return getRepo().save(t);
	}

	@Override
	public Mono<T> modificar(T t) {
		return getRepo().save(t);
	}

	@Override
	public Flux<T> listar() {
		return getRepo().findAll();
	}

	
	@Override
	public Mono<Void> eliminar(ID v) {
		return getRepo().deleteById(v);		
		/*return getRepo().findById(v)
				.flatMap(x -> getRepo().deleteById(v));*/
	}
	
	@Override
	public Mono<T> listarPorId(ID v) {
		return getRepo().findById(v);
	}
	

	
}
