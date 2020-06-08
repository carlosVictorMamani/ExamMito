package com.pe.freelo.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.pe.freelo.documento.Cursos;
import com.pe.freelo.documento.Estudiantes;
import com.pe.freelo.service.ICursosService;
import com.pe.freelo.service.IEstudiantesService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {
	
	private static final Logger log = LoggerFactory.getLogger(EstudiantesController.class);

	@Autowired
	private IEstudiantesService service;
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Estudiantes>>> listar(){	
		
		
		Flux<Estudiantes> fxEstudiantes = service.listar();
		
		return Mono.just(ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(fxEstudiantes));
	}
	
	@GetMapping("/order")
	public Mono<ResponseEntity<Flux<Estudiantes>>> order(){	
		
		
		Flux<Estudiantes> fxEstudiantes = service.findByOrderByEdadDesc();
		
		return Mono.just(ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(fxEstudiantes));
	}
	

	@PostMapping
	public Mono<ResponseEntity<Estudiantes>> registrar(@Valid @RequestBody Estudiantes estudiante, final ServerHttpRequest req){
		
		return service.registrar(estudiante)
				.map(p -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(p)
				);
	}
	
	@PutMapping
	public Mono<ResponseEntity<Estudiantes>> modificar(@Valid @RequestBody Estudiantes estudiante){
		return service.modificar(estudiante)
				.map(p -> ResponseEntity.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(p)
				).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable("id") String id){
		return service.listarPorId(id)
				.flatMap(p -> {
					return service.eliminar(p.getId())
							.then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
				})
				.defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
	
}
