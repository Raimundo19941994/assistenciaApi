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
public class Servicos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private String id;
	 private String descricao;
	 private String preco;
	 private String horas;
	 
	 
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
		
		public String getPreco() {
			return preco;
		}
		public void setPreco(String preco) {
			this.preco = preco;
		}
		public String getHoras() {
			return horas;
		}
		public void setHoras(String horas) {
			this.horas = horas;
		}
	 
	 

}
