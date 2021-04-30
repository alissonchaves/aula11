package br.una.alisson.aula11.controllers;

import br.una.alisson.aula11.domain.Pedido;
import br.una.alisson.aula11.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService repository;

    @GetMapping
    public List<Pedido> listAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<Object> listById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping
    public @ResponseBody
    Pedido create(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    Pedido update(
            @PathVariable(name = "id") Long id,
            @RequestBody Pedido pedido) {
        return repository.update(pedido);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Long id) {

        repository.deleteById(id);
    }
}
