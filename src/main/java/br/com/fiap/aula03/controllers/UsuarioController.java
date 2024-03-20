package br.com.fiap.aula03.controllers;

import br.com.fiap.aula03.dto.CadastroUsuarioDto;
import br.com.fiap.aula03.dto.DetalhesUsuarioDto;
import br.com.fiap.aula03.model.Usuario;
import br.com.fiap.aula03.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

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
}
