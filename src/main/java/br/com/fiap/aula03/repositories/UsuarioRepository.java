package br.com.fiap.aula03.repositories;

import br.com.fiap.aula03.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
