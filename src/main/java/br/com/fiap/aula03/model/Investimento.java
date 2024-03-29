package br.com.fiap.aula03.model;

import br.com.fiap.aula03.dto.investimento.AlterarInvestimentoDto;
import br.com.fiap.aula03.dto.investimento.CadastroInvestimentosDto;
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
        this.nome = dto.nome();
        this.categoria = dto.categoria();
        this.valor = dto.valor();
    }

    public void alterarInformacoes(AlterarInvestimentoDto dto) {
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.categoria() != null)
            this.categoria = dto.categoria();
    }
}
