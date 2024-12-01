package com.hamburgueria.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hamburgueria.backend.model.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
		Optional<Pedido> findTopByOrderByIdIntDesc();
}
