package com.coxinhaexpress.cadastro_pedidos.business;

import com.coxinhaexpress.cadastro_pedidos.infrasctructure.entitys.Cliente;
import com.coxinhaexpress.cadastro_pedidos.infrasctructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        repository.saveAndFlush(cliente);
    }

    public Cliente buscarClientePorEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("E-mail não encontrado!")
        );

    }

    public void deletarClientePorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarClientePorId(Integer id, Cliente cliente){
        Cliente clienteEntity = repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        Cliente clienteAtualizado = Cliente.builder()
                .email(cliente.getEmail() != null ? cliente.getEmail() : clienteEntity.getEmail())
                .nome(cliente.getNome() != null ? cliente.getNome() : clienteEntity.getNome())
                .id(clienteEntity.getId())
                .build();

                repository.saveAndFlush(clienteAtualizado);
    }

}
