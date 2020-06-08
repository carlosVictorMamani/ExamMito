package com.pe.freelo.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.pe.freelo.documento.Cursos;
import com.pe.freelo.documento.Matricula;
import com.pe.freelo.service.ICursosService;
import com.pe.freelo.service.IMatriculaService;
import com.pe.freelo.validators.RequestValidator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public class MatriculaHandler {
	@Autowired
	private IMatriculaService service;
	
	@Autowired
	private Validator validador;
	
	@Autowired
	private RequestValidator validadorGeneral;
	
	public Mono<ServerResponse> listar(ServerRequest req){	
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.listar(), Cursos.class);		
	}	
	
	public Mono<ServerResponse> registrar(ServerRequest req){
		
		Mono<Matricula> matriculaMono = req.bodyToMono(Matricula.class);
		
		
		return matriculaMono
				.flatMap(this.validadorGeneral::validate) 
				.flatMap(p-> service.registrar(p))
				.flatMap(p -> ServerResponse.created(URI.create(req.uri().toString().concat("/").concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(p)));
	}
	

	
	
	
}
