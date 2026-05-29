package br.com.pratica.login.repository;

import br.com.pratica.login.model.ArquivoModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<ArquivoModel, String>{
    
    Optional<ArquivoModel> findByNome(String nome);
}
