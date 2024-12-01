package com.hamburgueria.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hamburgueria.backend.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	Usuario findByEmail(String email);
	
	Optional<Usuario> findFirstByEmail(String email);

}
