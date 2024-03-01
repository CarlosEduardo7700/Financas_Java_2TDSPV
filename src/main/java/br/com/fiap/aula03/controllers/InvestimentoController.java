package br.com.fiap.aula03.controllers;

import br.com.fiap.aula03.dto.CadastroInvestimentosDto;
import br.com.fiap.aula03.model.CategoriaInvestimento;
import br.com.fiap.aula03.model.Investimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("investimentos")
public class InvestimentoController {

    @GetMapping
    public Investimento get(){
        return new Investimento(1l, "CDI", CategoriaInvestimento.RENDA_FIXA, 1000.0);
    }

    @PostMapping
    public ResponseEntity<CadastroInvestimentosDto> post(@RequestBody CadastroInvestimentosDto investimento, UriComponentsBuilder uriBuilder) {
        System.out.println(investimento.getNome());
        var uri = uriBuilder.path("/investimento/{id}").buildAndExpand(1).toUri();
        return ResponseEntity.created(uri).body(investimento);
    }

}
