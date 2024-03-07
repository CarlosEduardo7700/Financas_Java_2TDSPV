package br.com.fiap.aula03.controllers;

import br.com.fiap.aula03.dto.CadastroInvestimentosDto;
import br.com.fiap.aula03.model.CategoriaInvestimento;
import br.com.fiap.aula03.model.Investimento;
import br.com.fiap.aula03.repositories.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoRepository repository;

    @GetMapping
    public Investimento get(){
        List<Investimento> investimentos = repository.findAll();
        return new Investimento(1l, "CDI", CategoriaInvestimento.RENDA_FIXA, 1000.0);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CadastroInvestimentosDto> post(@RequestBody CadastroInvestimentosDto investimentoDto, UriComponentsBuilder uriBuilder) {
        Investimento investimento = new Investimento(investimentoDto);
        repository.save(investimento);
        var uri = uriBuilder.path("/investimento/{id}").buildAndExpand(investimento.getId()).toUri();
        return ResponseEntity.created(uri).body(investimentoDto);
    }

}
