package br.com.fiap.aula03.dto.investimento;

import br.com.fiap.aula03.model.CategoriaInvestimento;

public record CadastroInvestimentosDto(
        String nome,
        CategoriaInvestimento categoria,
        Double valor
) {}
