package br.una.alisson.aula11.services;

import br.una.alisson.aula11.domain.Pedido;
import br.una.alisson.aula11.repositories.PedidoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepositoryJPA repository;

    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Pedido> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Pedido update(Pedido pedido) {
        Optional<Pedido> pedidoOptional = findById(pedido.getId());
        if (pedidoOptional.isPresent()) {
            deleteById(pedido.getId());
            save(pedido);
        }
        return pedido;
    }
}
