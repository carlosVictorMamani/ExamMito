package com.pe.freelo.service;


import com.pe.freelo.documento.Usuario;
import com.pe.freelo.security.User;

import reactor.core.publisher.Mono;

public interface IUsuarioService extends ICRUD<Usuario, String>{
	
	Mono<User> buscarPorUsuario(String usuario);
}
