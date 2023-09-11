package com.br.contadigitalteste.service;

import com.br.contadigitalteste.dto.Request.TransferenciaRequestDto;
import com.br.contadigitalteste.dto.Response.TransferenciaResponseDto;
import com.br.contadigitalteste.entity.Transferencia;
import com.br.contadigitalteste.entity.Usuario;
import com.br.contadigitalteste.mapper.TransferenciaMapper;
import com.br.contadigitalteste.repository.TransferenciaRepository;
import com.br.contadigitalteste.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Optional;

@Service
public class TransferenciaService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Autowired
    TransferenciaMapper transferenciaMapper;

    String URI = "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6";

    // @Transactional
    public TransferenciaResponseDto transferir(TransferenciaRequestDto transferenciaRequestDto){

        Optional<Usuario> usuarioOrigem = usuarioRepository.findById(transferenciaRequestDto.getOrigemId());
        Optional<Usuario> usuarioDestino = usuarioRepository.findById(transferenciaRequestDto.getDestinoId());

        RestTemplate restTemplate = new RestTemplate();
        String autorizacao = restTemplate.getForObject(URI, String.class);
        if (autorizacao.equals("Autorizado")){
            System.out.println(autorizacao);
        }

        //Transferencia transferencia = transferenciaMapper.toTransferencia(transferenciaRequestDto);

        Transferencia transferencia = new Transferencia();
        transferencia.setOrigemId(usuarioOrigem.get());
        transferencia.setDestinoId(usuarioDestino.get());
        transferencia.setValor(transferenciaRequestDto.getValor());

        usuarioOrigem.get().setSaldo(usuarioOrigem.get().getSaldo() - transferencia.getValor());
        usuarioDestino.get().setSaldo(usuarioDestino.get().getSaldo() + transferencia.getValor());

        transferencia.setDataTranferencia(Instant.now());
        transferenciaRepository.save(transferencia);

        TransferenciaResponseDto transferenciaResponseDto = new TransferenciaResponseDto();
        transferenciaResponseDto.setSaldo(usuarioOrigem.get().getSaldo());

        return transferenciaResponseDto;
    }
}
