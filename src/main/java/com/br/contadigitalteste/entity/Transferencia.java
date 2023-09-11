package com.br.contadigitalteste.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false, name = "origem_id")
    private Usuario origemId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false, name = "destino_id")
    private Usuario destinoId;

    @Column(nullable = false)
    private Double valor;

    @Column(name = "data_criacao", nullable = false)
    private Instant dataTranferencia;

}
