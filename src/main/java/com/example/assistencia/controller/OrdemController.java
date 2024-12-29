package com.example.assistencia.controller;

import com.example.assistencia.model.Ordem;
import com.example.assistencia.repository.OrdemRepository;
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



@RestController
@RequestMapping({"/ordem"})
public class OrdemController {
	
	 private OrdemRepository repository;

	 	OrdemController(OrdemRepository OrdemRepository) {
	        this.repository = OrdemRepository;
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
	    public Ordem create(@RequestBody Ordem orde) {
	        return repository.save(orde);
	    }

	    @PutMapping(value = "/{id}")
	    public ResponseEntity update(@PathVariable("id") long id,
	            @RequestBody Ordem orde) {
	        return repository.findById(id)
	                .map(record -> {
	                    record.setId(orde.getId());
	                    record.setData_abertura(orde.getData_abertura());
	                    record.setData_entrada(orde.getData_entrada());
	                    record.setDefeito(orde.getDefeito());
	                    record.setTotal_servico(orde.getTotal_servico());
	                    record.setTotal_pecas(orde.getTotal_pecas());
	                    record.setTotal_ordem(orde.getTotal_ordem());
	                    record.setFuncionarios_id(orde.getFuncionarios_id());
	                    record.setClientes_id(orde.getClientes_id());
	                    record.setAparelho_id(orde.getAparelho_id());
	                    Ordem updated = repository.save(record);
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

