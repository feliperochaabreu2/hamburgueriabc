package com.hamburgueria.backend.service;

import java.util.Optional;

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
		Optional<Usuario> existente = usuarioRepository.findFirstByEmail(usuario.getEmail());
		if (existente.equals(Optional.empty())) {
			return usuarioRepository.save(usuario);
		} else {
			throw new UsuarioJaExisteException("Usuário já existe.");
		}
	}

	public boolean validarEmail(String email) {
		Optional<Usuario> existente = usuarioRepository.findFirstByEmail(email);
		return existente.isPresent();
	}

	public boolean redefinirSenha(String email, String novaSenha) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findFirstByEmail(email);
		if (usuarioExistente.isPresent()) {
			Usuario usuario = usuarioExistente.get();
			usuario.setSenha(novaSenha);
			usuarioRepository.save(usuario);
			return true;
		}
		return false;
	}
	
	public Usuario loginPorEmail(String email, String senha) {
	    Usuario usuario = usuarioRepository.findByEmail(email);
	    if (usuario != null && usuario.getSenha().equals(senha)) {
	        return usuario;
	    }
	    return null;
	}

	public Usuario loginPorCpf(String cpf, String senha) {
		Usuario usuario = usuarioRepository.findByCpf(cpf);
	    if (usuario != null && usuario.getSenha().equals(senha)) {
	        return usuario;
	    }
	    return null;
	}
}


