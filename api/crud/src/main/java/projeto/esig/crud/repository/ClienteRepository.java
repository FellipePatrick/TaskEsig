package projeto.esig.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.esig.crud.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}