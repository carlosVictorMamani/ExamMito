package com.pe.freelo.repo;

import com.pe.freelo.*;
import com.pe.freelo.documento.Usuario;

import reactor.core.publisher.Mono;

public interface IUsuarioRepo extends IGenericRepo<Usuario, String> {
	
	 Mono<Usuario> findOneByUsuario(String usuario);
}
