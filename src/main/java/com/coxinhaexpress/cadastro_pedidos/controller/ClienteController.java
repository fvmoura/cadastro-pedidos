package com.coxinhaexpress.cadastro_pedidos.controller;

import com.coxinhaexpress.cadastro_pedidos.business.ClienteService;
import com.coxinhaexpress.cadastro_pedidos.infrasctructure.entitys.Cliente;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> salvarCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarClientes(){
        return ResponseEntity
                .ok(clienteService.buscarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@RequestParam Long id) {
        clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(clienteService.buscarClientePorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> inativarClientePorId(@PathVariable Long id) {

        Cliente clienteInativado = clienteService.inativarClientePorId(id);

        return ResponseEntity
                .ok(clienteInativado);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarClientePorId(@RequestParam Long id) {
        clienteService.deletarClientePorId(id);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarClientePorId(@RequestParam Integer id, @RequestBody Cliente cliente) {
        clienteService.atualizarClientePorId(id, cliente);
        return  ResponseEntity
                .ok()
                .build();
    }
}

