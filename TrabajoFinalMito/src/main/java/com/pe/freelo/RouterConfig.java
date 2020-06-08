package com.pe.freelo;


import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.pe.freelo.handler.CursosHandler;
import com.pe.freelo.handler.EstudiantesHandler;
import com.pe.freelo.handler.MatriculaHandler;




@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction<ServerResponse> rutasPlatos(CursosHandler handler){
		return route(GET("/v2/cursos"), handler::listar) //req -> handler.listar(req)
				.andRoute(GET("/v2/cursos/{id}"), handler::listarPorId)
				.andRoute(POST("/v2/cursos"), handler::registrar)
				.andRoute(PUT("/v2/cursos"), handler::modificar)
				.andRoute(DELETE("/v2/cursos/{id}"), handler::eliminar);
	}
	
	@Bean
	public RouterFunction<ServerResponse> rutasClientes(EstudiantesHandler handler){
		return route(GET("/v2/estudiantes"), handler::listar) //req -> handler.listar(req)
				.andRoute(GET("/v2/estudiantes/{id}"), handler::listarPorId)
				.andRoute(POST("/v2/estudiantes"), handler::registrar)
				.andRoute(PUT("/v2/estudiantes"), handler::modificar)
				.andRoute(DELETE("/v2/estudiantes/{id}"), handler::eliminar);
	}
	
	@Bean
	public RouterFunction<ServerResponse> rutasMatricula(MatriculaHandler handler){
		return route(GET("/v2/matricula"), handler::listar) //req -> handler.listar(req)
				.andRoute(POST("/v2/matricula"), handler::registrar);
	
	}
}
