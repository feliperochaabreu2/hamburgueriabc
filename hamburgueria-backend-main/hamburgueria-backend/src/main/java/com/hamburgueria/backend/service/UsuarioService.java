/*
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
	 
	 public Usuario login(String email, String senha) {
	        Usuario usuario = usuarioRepository.findByEmail(email);
	        if (usuario != null && usuario.getSenha().equals(senha)) {
	            return usuario;
	        }
	        throw new RuntimeException("Email ou senha inválidos");
	 }
	 
	 public boolean validarEmail(String email) {
		 Optional<Usuario> existente = usuarioRepository.findFirstByEmail(email);
		 if (existente.equals(Optional.empty())) {
			return false;
		} else {
			return true;
		}
	        
	    }

	    public boolean redefinirSenha(String email, String novaSenha) {
	    	Usuario usuarioExistente = usuarioRepository.findFirstByEmail(email).get();
	    		if (usuarioExistente != null) {
	    			usuarioExistente.setSenha(novaSenha);
	    			usuarioRepository.save(usuarioExistente);
	    			return true;
	    		} else {
	    			return false;
	    		} 
	    }

}
*/

package com.hamburgueria.backend.service;

import java.util.Optional;
import java.util.regex.Pattern;

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

	public Usuario login(String identificacao, String senha) {
		Usuario usuario;

		// Verifica se o identificador é CPF
		Pattern cpfPattern = Pattern.compile("\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
		if (cpfPattern.matcher(identificacao).matches()) {
			usuario = usuarioRepository.findByCpf(identificacao).orElse(null);
		} else {
			// Assume que é e-mail
			usuario = usuarioRepository.findByEmail(identificacao);
		}

		if (usuario != null && usuario.getSenha().equals(senha)) {
			return usuario;
		}
		throw new RuntimeException("Identificação ou senha inválidos");
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
}


