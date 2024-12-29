package com.example.assistencia.controller;

import java.util.List;
import com.example.assistencia.model.Pecas;
import com.example.assistencia.repository.PecasRepository;
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
@RequestMapping({"/pecas"})
public class PecasController {
	
	    private PecasRepository repository;

	    PecasController(PecasRepository pecasRepository) {
	        this.repository = pecasRepository;
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
	    public Pecas create(@RequestBody Pecas peca) {
	        return repository.save(peca);
	    }

	    @PutMapping(value = "/{id}")
	    public ResponseEntity update(@PathVariable("id") long id,
	            @RequestBody Pecas peca) {
	        return repository.findById(id)
	                .map(record -> {
	                    record.setId(peca.getId());
	                    record.setDescricao(peca.getDescricao());
	                    record.setQuantidade_minima(peca.getQuantidade_minima());
	                    record.setQuantidade_atual(peca.getQuantidade_atual());
	                    record.setPco_custo(peca.getPco_custo());
	                    record.setPco_venda(peca.getPco_venda());
	                    Pecas updated = repository.save(record);
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
