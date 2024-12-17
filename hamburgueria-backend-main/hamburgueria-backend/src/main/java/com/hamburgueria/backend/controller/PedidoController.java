package com.hamburgueria.backend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamburgueria.backend.model.Pedido;
import com.hamburgueria.backend.model.Usuario;
import com.hamburgueria.backend.repository.PedidoRepository;
import com.hamburgueria.backend.repository.UsuarioRepository;
import com.hamburgueria.backend.service.PedidoService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500") // Permite apenas o frontend
@RequestMapping("/pedido")
public class PedidoController {
	
	
	@Autowired
    private PedidoService pedidoService;
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Autowired
    private PedidoRepository pedidoRepository;
	
	
	
	@CrossOrigin(origins = "http://127.0.0.1:5500") // Permite apenas o frontend
    @PostMapping("/finalizar")
    public Pedido finalizarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }
	
	@PutMapping("/status")
    public ResponseEntity<String> atualizarStatus(@RequestBody Map<String, Integer> request) {
        int pedidoId = request.get("id");

        boolean atualizado = pedidoService.atualizarStatusPedido(pedidoId);

        if (atualizado) {
            return ResponseEntity.ok("Status atualizado para entregue.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado.");
        }
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
    	List<Pedido> pedidos = pedidoRepository.findAll();

        pedidos.forEach(pedido -> {
            if (pedido.getCliente() != null) {
                Optional<Usuario> usuarioOptional = usuarioRepository.findFirstByEmail(pedido.getCliente());
                String nomeUsuario = usuarioOptional.map(Usuario::getNome).orElse("Cliente não cadastrado");
                pedido.setCliente(nomeUsuario);
            } else {
                pedido.setCliente("Cliente não cadastrado");
            }
        });

        return pedidos;
    }

}
