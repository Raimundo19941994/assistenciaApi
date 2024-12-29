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
public class Pecas {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String descricao;
	private String quantidade_minima;
	private String quantidade_atual;
	private String pco_custo;
	private String pco_venda;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getQuantidade_minima() {
		return quantidade_minima;
	}
	public void setQuantidade_minima(String quantidade_minima) {
		this.quantidade_minima = quantidade_minima;
	}
	public String getQuantidade_atual() {
		return quantidade_atual;
	}
	public void setQuantidade_atual(String quantidade_atual) {
		this.quantidade_atual = quantidade_atual;
	}
	public String getPco_custo() {
		return pco_custo;
	}
	public void setPco_custo(String pco_custo) {
		this.pco_custo = pco_custo;
	}
	public String getPco_venda() {
		return pco_venda;
	}
	public void setPco_venda(String pco_venda) {
		this.pco_venda = pco_venda;
	}

}
