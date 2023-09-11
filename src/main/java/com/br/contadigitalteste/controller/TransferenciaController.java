package com.br.contadigitalteste.controller;

import com.br.contadigitalteste.dto.Request.TransferenciaRequestDto;
import com.br.contadigitalteste.dto.Response.TransferenciaResponseDto;
import com.br.contadigitalteste.entity.Transferencia;
import com.br.contadigitalteste.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "transferencia")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    TransferenciaResponseDto transferenciaResponseDto;

    @PostMapping()
    public ResponseEntity<TransferenciaResponseDto> postTransferencia(@RequestBody TransferenciaRequestDto transferenciaRequestDto){

        transferenciaResponseDto = transferenciaService.transferir(transferenciaRequestDto);

        return ResponseEntity.ok(transferenciaResponseDto);
    }
}
