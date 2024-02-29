package br.com.fiap.aula03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Investimento {
    private String nome;
    private CategoriaInvestimento categoria;
    private Double valor;
}
