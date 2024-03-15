package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.Investimento;

public record ListagemInvestimentoDto(
        Long id,
        String nome,
        Double valor
) {
    public ListagemInvestimentoDto(Investimento investimento) {
        this(investimento.getId(), investimento.getNome(), investimento.getValor());
    }
}
