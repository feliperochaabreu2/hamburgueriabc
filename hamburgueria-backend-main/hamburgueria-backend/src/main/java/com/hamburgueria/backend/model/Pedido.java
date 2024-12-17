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
    private String modoPagamento;
    private String cliente;
    private boolean status;
    
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
	public String getModoPagamento() {
		return modoPagamento;
	}
	public void setModoPagamento(String modoPagamento) {
		this.modoPagamento = modoPagamento;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
