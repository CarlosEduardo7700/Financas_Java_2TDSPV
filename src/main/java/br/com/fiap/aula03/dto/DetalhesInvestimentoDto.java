package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.CategoriaInvestimento;
import br.com.fiap.aula03.model.Investimento;

public record DetalhesInvestimentoDto(
        Long id,
        String nome,
        CategoriaInvestimento categoria,
        Double valor
) {
    public DetalhesInvestimentoDto(Investimento investimento) {
        this(investimento.getId(), investimento.getNome(), investimento.getCategoria(), investimento.getValor());
    }
}
