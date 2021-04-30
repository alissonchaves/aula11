package br.una.alisson.aula11.repositories;

import br.una.alisson.aula11.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoryJPA extends JpaRepository<Categoria, Long> {
}
