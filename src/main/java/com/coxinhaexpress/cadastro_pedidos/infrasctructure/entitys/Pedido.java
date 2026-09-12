package com.coxinhaexpress.cadastro_pedidos.infrasctructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pedidos")
@Entity


public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    private Long idCliente;

    @Column(name = "descricao")
    private String descricao;


}
