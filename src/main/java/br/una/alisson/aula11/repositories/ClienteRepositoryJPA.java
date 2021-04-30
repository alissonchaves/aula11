package br.una.alisson.aula11.repositories;

import br.una.alisson.aula11.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<Cliente, Long> {
}
