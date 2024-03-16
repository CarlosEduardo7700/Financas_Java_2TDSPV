package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.CategoriaInvestimento;
import jakarta.persistence.Enumerated;

public record AlterarInvestimentoDto(
        String nome,
        CategoriaInvestimento categoria
) {
}
