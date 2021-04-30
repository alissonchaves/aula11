package br.una.alisson.aula11.services;

import br.una.alisson.aula11.domain.Cliente;
import br.una.alisson.aula11.repositories.ClienteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoryJPA repository;

    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Cliente update(Cliente cliente) {
        Optional<Cliente> clienteOptional = findById(cliente.getId());
        if (clienteOptional.isPresent()) {
            deleteById(cliente.getId());
            save(cliente);
        }
        return cliente;
    }
}
