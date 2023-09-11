package com.br.contadigitalteste.repository;

import com.br.contadigitalteste.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferenciaRepository extends JpaRepository<Transferencia, UUID> {
}
