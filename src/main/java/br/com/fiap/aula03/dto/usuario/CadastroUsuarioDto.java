package br.com.fiap.aula03.dto.usuario;

import java.time.LocalDate;

public record CadastroUsuarioDto (
        String email,
        String nome,
        String telefone,
        LocalDate dataCadastro
) {}
