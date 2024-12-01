package com.hamburgueria.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hamburgueria.backend.model.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

}
