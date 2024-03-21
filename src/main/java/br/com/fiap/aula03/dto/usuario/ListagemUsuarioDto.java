package br.com.fiap.aula03.dto.usuario;

import br.com.fiap.aula03.model.Usuario;

public record ListagemUsuarioDto(
        Long id,
        String email,
        String nome
) {
    public ListagemUsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getEmail(), usuario.getNome());
    }

}
