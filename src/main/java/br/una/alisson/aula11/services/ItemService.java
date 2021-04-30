package br.una.alisson.aula11.services;

import br.una.alisson.aula11.domain.Item;
import br.una.alisson.aula11.repositories.ItemRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepositoryJPA repository;

    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Item save(Item item) {
        return repository.save(item);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Item update(Item item) {
        Optional<Item> itemOptional = findById(item.getId());
        if (itemOptional.isPresent()) {
            deleteById(item.getId());
            save(item);
        }
        return item;
    }
}
