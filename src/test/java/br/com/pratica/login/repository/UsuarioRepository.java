package br.com.pratica.login.repository;

import br.com.pratica.login.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
    Optional<UsuarioModel> findByNome(String nome);
}
