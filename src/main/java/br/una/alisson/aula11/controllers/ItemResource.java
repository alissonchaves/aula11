package br.una.alisson.aula11.controllers;

import br.una.alisson.aula11.domain.Item;
import br.una.alisson.aula11.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/itens")
public class ItemResource {

    @Autowired
    private ItemService repository;

    @GetMapping
    public List<Item> listAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Object> listById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping
    public @ResponseBody
    Item create(@RequestBody Item item) {
        return repository.save(item);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    Item update(
            @PathVariable(name = "id") Long id,
            @RequestBody Item item) {
        return repository.update(item);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Long id) {

        repository.deleteById(id);
    }
}
