package com.hamburgueria.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class teste {
	
	@GetMapping("/ping")
    public String testar() {
        return "OK Sucesso";
    }

}
