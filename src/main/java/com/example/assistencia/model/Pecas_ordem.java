package com.example.assistencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pecas_ordem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String quantidade;
	private String preco;
	private String pecas_id;
	private String ordem_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getPecas_id() {
		return pecas_id;
	}
	public void setPecas_id(String pecas_id) {
		this.pecas_id = pecas_id;
	}
	public String getOrdem_id() {
		return ordem_id;
	}
	public void setOrdem_id(String ordem_id) {
		this.ordem_id = ordem_id;
	}
	
	
	

}
