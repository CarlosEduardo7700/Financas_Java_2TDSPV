package br.com.fiap.aula03.model;

import br.com.fiap.aula03.dto.CadastroInvestimentosDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "investimentos")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated
    private CategoriaInvestimento categoria;
    private Double valor;

    public Investimento(CadastroInvestimentosDto dto) {
        this.nome = dto.getNome();
        this.categoria = dto.getCategoria();
        this.valor = dto.getValor();
    }
}
