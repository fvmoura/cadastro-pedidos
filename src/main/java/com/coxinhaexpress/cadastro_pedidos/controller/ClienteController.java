package com.coxinhaexpress.cadastro_pedidos.controller;

import com.coxinhaexpress.cadastro_pedidos.business.ClienteService;
import com.coxinhaexpress.cadastro_pedidos.infrasctructure.entitys.Cliente;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Cliente> buscarClientePorEmail(@RequestParam String email) {
        clienteService.buscarClientePorEmail(email);
        return ResponseEntity.ok(clienteService.buscarClientePorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarClientePorEmail(@RequestParam String email) {
        clienteService.deletarClientePorEmail(email);
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

