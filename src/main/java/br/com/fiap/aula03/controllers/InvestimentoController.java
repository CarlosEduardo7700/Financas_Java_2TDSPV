package br.com.fiap.aula03.controllers;

import br.com.fiap.aula03.dto.investimento.AlterarInvestimentoDto;
import br.com.fiap.aula03.dto.investimento.CadastroInvestimentosDto;
import br.com.fiap.aula03.dto.investimento.DetalhesInvestimentoDto;
import br.com.fiap.aula03.dto.investimento.ListagemInvestimentoDto;
import br.com.fiap.aula03.model.Investimento;
import br.com.fiap.aula03.repositories.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<List<ListagemInvestimentoDto>> get(Pageable pageable){
        var investimentos = repository.findAll(pageable);
        List<ListagemInvestimentoDto> listaDeInvestimentos = investimentos.stream().map(ListagemInvestimentoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(listaDeInvestimentos);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesInvestimentoDto> getById(@PathVariable("id") Long id) {
        var investimento = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesInvestimentoDto(investimento));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesInvestimentoDto> post(@RequestBody CadastroInvestimentosDto investimentoDto, UriComponentsBuilder uriBuilder) {
        Investimento investimento = new Investimento(investimentoDto);
        repository.save(investimento);
        var uri = uriBuilder.path("/investimentos/{id}").buildAndExpand(investimento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesInvestimentoDto(investimento));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesInvestimentoDto> put (@PathVariable("id") Long id, @RequestBody AlterarInvestimentoDto dto) {
        var investimento = repository.getReferenceById(id);
        investimento.alterarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesInvestimentoDto(investimento));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
