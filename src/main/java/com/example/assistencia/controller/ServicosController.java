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

import com.example.assistencia.model.Servicos;
import com.example.assistencia.repository.ServicosRepository;


@RestController
@RequestMapping({"/servicos"})
public class ServicosController {
	    
	    private ServicosRepository repository;

	    ServicosController(ServicosRepository servicosRepository) {
	        this.repository = servicosRepository;
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
	    public Servicos create(@RequestBody Servicos servico) {
	        return repository.save(servico);
	    }

	    @PutMapping(value = "/{id}")
	    public ResponseEntity update(@PathVariable("id") long id,
	            @RequestBody Servicos servico) {
	        return repository.findById(id)
	                .map(record -> {
	                    record.setId(servico.getId());
	                    record.setDescricao(servico.getDescricao());
	                    record.setPreco(servico.getPreco());
	                    record.setHoras(servico.getHoras());
	                    Servicos updated = repository.save(record);
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

