package com.hamburgueria.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hamburgueria.backend.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	Usuario findByEmail(String email);

}
