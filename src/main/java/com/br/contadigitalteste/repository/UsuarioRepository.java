package com.br.contadigitalteste.repository;

import com.br.contadigitalteste.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID> {
}
