package br.com.pratica.login.service;

import br.com.pratica.login.model.UsuarioModel;
import br.com.pratica.login.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    
    public UsuarioModel cadastro(UsuarioModel usuarioModel) {
        usuarioModel.setSenha(
                encoder.encode(usuarioModel.getSenha())
        );
        
        return repository.save(usuarioModel);
    }
    
    public boolean autenticar(String nome, String senha){
        UsuarioModel usuarioModel = repository
                .findByNome(nome)
                .orElse(null);
        
        if(usuarioModel == null) {
            return false;
        }
        
        return encoder.matches(
                senha,
                usuarioModel.getSenha()
                );
    }
}