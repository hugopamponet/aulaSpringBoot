package br.com.pratica.login.repository;

import br.com.pratica.login.model.PastaModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastaRepository extends JpaRepository<PastaModel, String>{
    
    Optional<PastaModel> findByNome(String nome);
}
