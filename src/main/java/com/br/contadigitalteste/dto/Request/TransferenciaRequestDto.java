package com.br.contadigitalteste.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class TransferenciaRequestDto {

    private UUID origemId;

    private UUID destinoId;

    private Double valor;
}
