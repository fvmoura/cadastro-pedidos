package com.coxinhaexpress.cadastro_pedidos.business;

import com.coxinhaexpress.cadastro_pedidos.infrasctructure.entitys.Cliente;
import com.coxinhaexpress.cadastro_pedidos.infrasctructure.entitys.Enums;
import com.coxinhaexpress.cadastro_pedidos.infrasctructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        repository.saveAndFlush(cliente);
    }

    public List<Cliente> buscarClientes() {
        return repository.findAll();
    }

    public Cliente buscarClientePorId(Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Cliente não encontrado!")
        );

    }

    public void deletarClientePorId(Long id){
        repository.deleteById(id);
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

    public Cliente inativarClientePorId(Long id ){

        Cliente clienteEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

                clienteEntity.setStatusCadastro(Enums.StatusCadastro.INATIVO);

                repository.save(clienteEntity);

                return clienteEntity;
    }

}
