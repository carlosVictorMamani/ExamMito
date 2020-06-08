package com.pe.freelo.controller;

import java.net.URI;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.freelo.documento.Matricula;
import com.pe.freelo.service.IMatriculaService;

import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/matricula")
public class MatriculaController {

	private static final Logger log = LoggerFactory.getLogger(MatriculaController.class);

	@Autowired
	private IMatriculaService service;
	
	
	@PostMapping
	public Mono<ResponseEntity<Matricula>> registrar( @RequestBody Matricula matricula, final ServerHttpRequest req){

	System.out.println("entro");
		
		return service.registrar(matricula)
				.map(p -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(p)
				);

	}
	
	
}

