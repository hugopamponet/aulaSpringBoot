package br.com.pratica.login.service;

import br.com.pratica.login.dto.ArquivoDto;
import br.com.pratica.login.model.ArquivoModel;
import br.com.pratica.login.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArquivoService {
    
    @Autowired
    private ArquivoRepository repository;
    
    public ArquivoDto cadastro(ArquivoDto dto) {
        
        ArquivoModel arquivo = new ArquivoModel();
        
        arquivo.setNome(dto.getNome());
        arquivo.setDescricao(dto.getDescricao());
        arquivo.setData(dto.getData());
        
        ArquivoModel arquivoSalvo = repository.save(arquivo);
        
        return new ArquivoDto(
                arquivoSalvo.getNome(),
                arquivoSalvo.getDescricao(),
                arquivoSalvo.getData()
        );
    }
    
    
}
