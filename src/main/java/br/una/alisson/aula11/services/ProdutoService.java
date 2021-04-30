package br.una.alisson.aula11.services;

import br.una.alisson.aula11.domain.Produto;
import br.una.alisson.aula11.repositories.ProdutoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositoryJPA repository;

    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Produto update(Produto produto) {
        Optional<Produto> produtoOptional = findById(produto.getId());
        if (produtoOptional.isPresent()) {
            deleteById(produto.getId());
            save(produto);
        }
        return produto;
    }
}
