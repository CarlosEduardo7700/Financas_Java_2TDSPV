package br.com.fiap.aula03.model;

import br.com.fiap.aula03.dto.AlterarUsuarioDto;
import br.com.fiap.aula03.dto.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    private String telefone;
    private LocalDate dataCadastro;

    public Usuario(CadastroUsuarioDto dto) {
        this.email = dto.email();
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.dataCadastro = dto.dataCadastro();
    }

    public void alterarDados(AlterarUsuarioDto dto) {
        if (dto.email() != null)
            this.email = dto.email();
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.telefone() != null)
            this.telefone = dto.telefone();
    }
}
