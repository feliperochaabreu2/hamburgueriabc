package com.hamburgueria.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamburgueria.backend.exception.UsuarioJaExisteException;
import com.hamburgueria.backend.model.Usuario;
import com.hamburgueria.backend.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	 @Autowired
	 private UsuarioRepository usuarioRepository;
	 
	 public Usuario cadastrarUsuario(Usuario usuario) {
		    Usuario usuarioExistente = usuarioRepository.findFirstByEmail(usuario.getEmail()).get();
		    if (usuarioExistente != null) {
		    	throw new UsuarioJaExisteException("Usuário já existe.");
		    }
		    return usuarioRepository.save(usuario);
		}
	 
	 public Usuario login(String email, String senha) {
	        Usuario usuario = usuarioRepository.findByEmail(email);
	        if (usuario != null && usuario.getSenha().equals(senha)) {
	            return usuario;
	        }
	        throw new RuntimeException("Email ou senha inválidos");
	 }

}
