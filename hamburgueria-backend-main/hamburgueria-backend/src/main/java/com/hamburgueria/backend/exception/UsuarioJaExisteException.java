package com.hamburgueria.backend.exception;

public class UsuarioJaExisteException extends RuntimeException{

	public UsuarioJaExisteException(String mensagem) {
        super(mensagem);
    }
}
