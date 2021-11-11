package com.fiap.ongterraplanetaagua.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.ongterraplanetaagua.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	
	
}
