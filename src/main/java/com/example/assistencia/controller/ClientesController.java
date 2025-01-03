package com.example.assistencia.controller;

import com.example.assistencia.model.Clientes;
import com.example.assistencia.repository.ClientesRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author R
 */
@RestController
@RequestMapping({"/clientes"})
public class ClientesController {
    
    private ClientesRepository repository;

    ClientesController(ClientesRepository clientesRepository) {
        this.repository = clientesRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Clientes create(@RequestBody Clientes cliente) {
        return repository.save(cliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
            @RequestBody Clientes cliente) {
        return repository.findById(id)
                .map(record -> {
                    record.setId(cliente.getId());
                    record.setNome(cliente.getNome());
                    record.setCpf(cliente.getCpf());
                    record.setEndereco(cliente.getEndereco());
                    record.setTelefone(cliente.getTelefone());
                    Clientes updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}




