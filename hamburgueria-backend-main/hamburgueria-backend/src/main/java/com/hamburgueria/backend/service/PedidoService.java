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

	    public List<Pedido> listarPedidos() {
	        return pedidoRepository.findAll();
	    }

}
