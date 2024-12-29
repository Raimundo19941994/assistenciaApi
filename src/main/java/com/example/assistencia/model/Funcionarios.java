
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
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String salario;

    // Getters
    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

     public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    public String getSalario() {
        return salario;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }

    // Outros métodos...


}

