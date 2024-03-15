package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.Usuario;

import java.time.LocalDate;

public record DetalhesUsuarioDto(

        Long id,
        String email,
        String nome,
        String telefone,
        LocalDate dataCadastro
) {
    public DetalhesUsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getEmail(), usuario.getNome(), usuario.getTelefone(), usuario.getDataCadastro());
    }
}
