package com.br.contadigitalteste.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(length = 1, nullable = false, name = "tipo_usuario")
    private Integer tipoUsuario;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf_cnpj;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    private Double saldo;
}
