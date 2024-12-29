package com.example.assistencia.controller;

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

import com.example.assistencia.model.Pecas_ordem;
import com.example.assistencia.repository.Pecas_ordemRepository;

@RestController
@RequestMapping({"/pecas_ordem"})
public class Pecas_ordemController {
	 private Pecas_ordemRepository repository;

	    Pecas_ordemController(Pecas_ordemRepository pecas_ordemRepository) {
	        this.repository = pecas_ordemRepository;
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
	    public Pecas_ordem create(@RequestBody Pecas_ordem peca_ordem) {
	        return repository.save(peca_ordem);
	    }

	    @PutMapping(value = "/{id}")
	    public ResponseEntity update(@PathVariable("id") long id,
	            @RequestBody Pecas_ordem peca_ordem) {
	        return repository.findById(id)
	                .map(record -> {
	                    record.setId(peca_ordem.getId());
	                    record.setQuantidade(peca_ordem.getQuantidade());
	                    record.setPreco(peca_ordem.getPreco());
	                    record.setPecas_id(peca_ordem.getPecas_id());
	                    record.setOrdem_id(peca_ordem.getOrdem_id());
	                    Pecas_ordem updated = repository.save(record);
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



