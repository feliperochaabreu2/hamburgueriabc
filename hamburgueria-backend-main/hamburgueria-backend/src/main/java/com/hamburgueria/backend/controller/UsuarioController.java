package com.hamburgueria.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hamburgueria.backend.model.Usuario;
import com.hamburgueria.backend.service.UsuarioService;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
    private UsuarioService usuarioService;
	@CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }
	@CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha) {
        return usuarioService.login(email, senha);
    }

}
