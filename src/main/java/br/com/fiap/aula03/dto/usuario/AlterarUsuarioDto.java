package br.com.fiap.aula03.dto.usuario;

import br.com.fiap.aula03.model.Usuario;

public record AlterarUsuarioDto(
        String email,
        String nome,
        String telefone
) {
    public AlterarUsuarioDto(Usuario usuario) {
        this(usuario.getEmail(), usuario.getNome(), usuario.getTelefone());
    }
}
