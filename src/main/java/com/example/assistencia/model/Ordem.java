package com.example.assistencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author R
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ordem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private String id;
	 private String data_abertura;
	 private String data_entrada;
	 private String defeito;
	 private String total_servico;
	 private String total_pecas;
	 private String total_ordem;
	 private String funcionarios_id;
	 private String clientes_id;
	 private String aparelho_id;
	 
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getData_abertura() {
		return data_abertura;
	}
	public void setData_abertura(String data_abertura) {
		this.data_abertura = data_abertura;
	}
	public String getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}
	public String getDefeito() {
		return defeito;
	}
	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	public String getTotal_servico() {
		return total_servico;
	}
	public void setTotal_servico(String total_servico) {
		this.total_servico = total_servico;
	}
	public String getTotal_pecas() {
		return total_pecas;
	}
	public void setTotal_pecas(String total_pecas) {
		this.total_pecas = total_pecas;
	}
	public String getTotal_ordem() {
		return total_ordem;
	}
	public void setTotal_ordem(String total_ordem) {
		this.total_ordem = total_ordem;
	}
	public String getFuncionarios_id() {
		return funcionarios_id;
	}
	public void setFuncionarios_id(String funcionarios_id) {
		this.funcionarios_id = funcionarios_id;
	}
	public String getClientes_id() {
		return clientes_id;
	}
	public void setClientes_id(String clientes_id) {
		this.clientes_id = clientes_id;
	}
	public String getAparelho_id() {
		return aparelho_id;
	}
	public void setAparelho_id(String aparelho_id) {
		this.aparelho_id = aparelho_id;
	}

}
