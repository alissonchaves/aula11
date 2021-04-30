package br.una.alisson.aula11.controllers;

import br.una.alisson.aula11.domain.Produto;
import br.una.alisson.aula11.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService repository;

    @GetMapping
    public List<Produto> listAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Object> listById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping
    public @ResponseBody
    Produto create(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    Produto update(
            @PathVariable(name = "id") Long id,
            @RequestBody Produto produto) {
        return repository.update(produto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Long id) {

        repository.deleteById(id);
    }
}
