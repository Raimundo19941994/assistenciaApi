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
public class Aparelho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String ano;
    private String descricao;
    private String modelo;
    private String cor;
    private String clientes_id;

    // Getters
    public String getId() {
        return id;
    }
    public String getAno() {
        return ano;
    }

    public String getDescricao() {
        return descricao;
    }

     public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }
    public String getClientes_id() {
        return clientes_id;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
     public void setCor(String  cor) {
        this.cor = cor;
    }
      public void setClientes_id(String  clientes_id) {
        this.clientes_id = clientes_id;
    }

    


}

