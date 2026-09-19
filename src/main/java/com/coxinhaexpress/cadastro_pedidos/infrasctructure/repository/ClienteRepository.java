package com.coxinhaexpress.cadastro_pedidos.infrasctructure.repository;

import com.coxinhaexpress.cadastro_pedidos.infrasctructure.entitys.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findById (Long id);

    @Transactional
    void deleteById(Long id);
}
