package br.com.pratica.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pratica.login.model.UsuarioModel;
import br.com.pratica.login.repository.UsuarioRepository;
import br.com.pratica.login.dto.UsuarioDto;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    

    public UsuarioDto cadastro(UsuarioDto dto) {

        UsuarioModel usuario = new UsuarioModel();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        UsuarioModel usuarioSalvo = repository.save(usuario);

        return new UsuarioDto(
                usuarioSalvo.getNome(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getSenha()
        );
    }

    public boolean login(String nome, String senha) {

        Optional<UsuarioModel> usuario = repository.findByNome(nome);

        if(usuario.isPresent()) {
            return usuario.get().getSenha().equals(senha);
        }

        return false;
    }
}