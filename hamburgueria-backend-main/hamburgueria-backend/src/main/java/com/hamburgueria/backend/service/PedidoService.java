package com.hamburgueria.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamburgueria.backend.model.Pedido;
import com.hamburgueria.backend.repository.PedidoRepository;

@Service
public class PedidoService {
	 	@Autowired
	    private PedidoRepository pedidoRepository;

	 	public Pedido criarPedido(Pedido pedido) {

	        Optional<Pedido> ultimoPedido = pedidoRepository.findTopByOrderByIdIntDesc();
	        int proximoIdInt = ultimoPedido.map(p -> p.getIdInt() + 1).orElse(1); 

	        pedido.setIdInt(proximoIdInt);

	        return pedidoRepository.save(pedido);
	    }
	 	
	 	public boolean atualizarStatusPedido(int id) {
	        Optional<Pedido> pedidoOptional = pedidoRepository.findByIdInt(id);

	        if (pedidoOptional.isPresent()) {
	            Pedido pedido = pedidoOptional.get();
	            pedido.setStatus(true); // Define o status como entregue (true)
	            pedidoRepository.save(pedido); // Salva a alteração
	            return true;
	        }
	        return false; // Retorna false se o pedido não for encontrado
	    }

	    public List<Pedido> listarPedidos() {
	        return pedidoRepository.findAll();
	    }

}
