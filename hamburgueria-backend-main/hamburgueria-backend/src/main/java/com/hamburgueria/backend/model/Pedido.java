package com.hamburgueria.backend.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pedido")
public class Pedido {
	
	@Id
    private String id;
	private int idInt; 
    private List<ItemPedido> itens;
    private String enderecoEntrega;
    private double total;
    
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	public int getIdInt() {
		return idInt;
	}
	public void setIdInt(int idInt) {
		this.idInt = idInt;
	}

}
