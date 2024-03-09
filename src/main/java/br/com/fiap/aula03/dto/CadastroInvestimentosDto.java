package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.CategoriaInvestimento;

public record CadastroInvestimentosDto(
        String nome,
        CategoriaInvestimento categoria,
        Double valor
) {}
