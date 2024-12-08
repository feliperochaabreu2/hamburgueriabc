/*
package com.hamburgueria.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }
    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha) {
        return usuarioService.login(email, senha);
    }
    
    @PostMapping("/email")
    public ResponseEntity<?> validarEmail(@RequestBody String email) {
        boolean emailExiste = usuarioService.validarEmail(email);
        if (emailExiste) {
            return ResponseEntity.ok("Email válido.");
        } else {
            return ResponseEntity.badRequest().body("Email não encontrado.");
        }
    }

    @PostMapping("/reset")
    public ResponseEntity<?> redefinirSenha(@RequestBody Usuario usuario) {
        boolean senhaAtualizada = usuarioService.redefinirSenha(usuario.getEmail(), usuario.getSenha());
        if (senhaAtualizada) {
            return ResponseEntity.ok("Senha redefinida com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Erro ao redefinir a senha.");
        }
    }

}
*/

package com.hamburgueria.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestParam String identificacao, @RequestParam String senha) {
        return usuarioService.login(identificacao, senha);
    }
    
    @PostMapping("/email")
    public ResponseEntity<?> validarEmail(@RequestBody String email) {
        boolean emailExiste = usuarioService.validarEmail(email);
        if (emailExiste) {
            return ResponseEntity.ok("Email válido.");
        } else {
            return ResponseEntity.badRequest().body("Email não encontrado.");
        }
    }

    @PostMapping("/reset")
    public ResponseEntity<?> redefinirSenha(@RequestBody Usuario usuario) {
        boolean senhaAtualizada = usuarioService.redefinirSenha(usuario.getEmail(), usuario.getSenha());
        if (senhaAtualizada) {
            return ResponseEntity.ok("Senha redefinida com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Erro ao redefinir a senha.");
        }
    }
}


