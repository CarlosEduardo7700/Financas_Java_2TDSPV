package br.com.fiap.aula03.controllers;

import br.com.fiap.aula03.dto.usuario.AlterarUsuarioDto;
import br.com.fiap.aula03.dto.usuario.CadastroUsuarioDto;
import br.com.fiap.aula03.dto.usuario.DetalhesUsuarioDto;
import br.com.fiap.aula03.dto.usuario.ListagemUsuarioDto;
import br.com.fiap.aula03.model.Usuario;
import br.com.fiap.aula03.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<ListagemUsuarioDto>> get(Pageable page) {
        var usuarios = repository.findAll(page);
        var listaDeUsuarios = usuarios.stream().map(ListagemUsuarioDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(listaDeUsuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuarioDto> getById(@PathVariable("id") Long id) {
        Usuario usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody CadastroUsuarioDto dto, UriComponentsBuilder uriBuilder) {
        Usuario usuario = new Usuario(dto);
        repository.save(usuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesUsuarioDto(usuario));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> put(@PathVariable("id") Long id, @RequestBody AlterarUsuarioDto dto){
        Usuario usuario = repository.getReferenceById(id);
        usuario.alterarDados(dto);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
