package br.com.fiap.aula03.controllers;

import br.com.fiap.aula03.dto.CadastroInvestimentosDto;
import br.com.fiap.aula03.dto.DetalhesInvestimentoDto;
import br.com.fiap.aula03.dto.ListagemInvestimentoDto;
import br.com.fiap.aula03.model.CategoriaInvestimento;
import br.com.fiap.aula03.model.Investimento;
import br.com.fiap.aula03.repositories.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoRepository repository;

    @GetMapping
    public ResponseEntity<List<ListagemInvestimentoDto>> get(){
        List<Investimento> investimentos = repository.findAll();
        List<ListagemInvestimentoDto> listaDeInvestimentos = investimentos.stream().map(ListagemInvestimentoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(listaDeInvestimentos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesInvestimentoDto> post(@RequestBody CadastroInvestimentosDto investimentoDto, UriComponentsBuilder uriBuilder) {
        Investimento investimento = new Investimento(investimentoDto);
        repository.save(investimento);
        var uri = uriBuilder.path("/investimentos/{id}").buildAndExpand(investimento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesInvestimentoDto(investimento));
    }

}
