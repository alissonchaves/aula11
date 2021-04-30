package br.una.alisson.aula11.controllers;

import br.una.alisson.aula11.domain.Cliente;
import br.una.alisson.aula11.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService repository;

    @GetMapping
    public List<Cliente> listAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Object> listById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping
    public @ResponseBody
    Cliente create(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    Cliente update(
            @PathVariable(name = "id") Long id,
            @RequestBody Cliente cliente) {
        return repository.update(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Long id) {

        repository.deleteById(id);
    }
}
