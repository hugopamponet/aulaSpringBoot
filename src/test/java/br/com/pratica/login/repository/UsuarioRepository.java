package br.com.pratica.login.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pratica.login.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByNome(String nome);
}