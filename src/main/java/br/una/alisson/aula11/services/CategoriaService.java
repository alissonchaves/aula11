package br.una.alisson.aula11.services;

import br.una.alisson.aula11.domain.Categoria;
import br.una.alisson.aula11.repositories.CategoriaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositoryJPA repository;

    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Categoria> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Categoria update(Categoria categoria) {
        Optional<Categoria> categoriaOptional = findById(categoria.getId());
        if (categoriaOptional.isPresent()) {
            deleteById(categoria.getId());
            save(categoria);
        }
        return categoria;
    }
}
