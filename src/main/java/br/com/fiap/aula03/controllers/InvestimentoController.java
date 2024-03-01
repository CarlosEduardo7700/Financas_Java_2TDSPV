package br.com.fiap.aula03.controllers;

import br.com.fiap.aula03.model.CategoriaInvestimento;
import br.com.fiap.aula03.model.Investimento;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("investimentos")
public class InvestimentoController {

    @GetMapping
    public Investimento get(){
        return new Investimento("CDI", CategoriaInvestimento.RENDA_FIXA, 1000.0);
    }


}
