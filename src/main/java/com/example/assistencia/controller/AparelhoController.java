package com.example.assistencia.controller;

import com.example.assistencia.model.Aparelho;
import com.example.assistencia.repository.AparelhoRepository;
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
@RequestMapping({"/aparelho"})
public class AparelhoController {
    
    private AparelhoRepository repository;

    AparelhoController(AparelhoRepository aparelhoRepository) {
        this.repository = aparelhoRepository;
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
    public Aparelho create(@RequestBody Aparelho aparelh) {
        return repository.save(aparelh);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
            @RequestBody Aparelho aparelh) {
        return repository.findById(id)
                .map(record -> {
                    record.setId(aparelh.getId());
                    record.setAno(aparelh.getAno());
                    record.setDescricao(aparelh.getDescricao());
                    record.setModelo(aparelh.getModelo());
                    record.setCor(aparelh.getCor());
                    record.setClientes_id(aparelh.getClientes_id());
                    Aparelho updated = repository.save(record);
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