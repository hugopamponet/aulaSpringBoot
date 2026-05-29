package br.com.pratica.login.service;

import br.com.pratica.login.dto.PastaDto;
import br.com.pratica.login.model.PastaModel;
import br.com.pratica.login.repository.PastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PastaService {
    
    @Autowired
    private PastaRepository repository;
    
    public PastaDto pasta(PastaDto dto) {
        
        PastaModel pastaM = new PastaModel();
        pastaM.setNome(dto.getNome());
        
        PastaModel pastaSalvar = repository.save(pastaM);
        
        return new PastaDto(
                pastaSalvar.getNome()
        );
    }
}
