package br.una.alisson.aula11.controllers;

import br.una.alisson.aula11.domain.Categoria;
import br.una.alisson.aula11.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService repository;

    @GetMapping
    public List<Categoria> listAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Object> listById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping
    public @ResponseBody
    Categoria create(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    Categoria update(
            @PathVariable(name = "id") Long id,
            @RequestBody Categoria categoria) {
        return repository.update(categoria);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Long id) {

        repository.deleteById(id);
    }
}
