package br.com.pratica.login.controller;

import br.com.pratica.login.model.UsuarioModel;
import br.com.pratica.login.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class UsuarioController {
    
    private final UsuarioService service;
    
    public UsuarioController(UsuarioService service){
        this.service = service;
    }
    
    @PostMapping("/cadastro")
    public UsuarioModel cadastrar(@RequestBody UsuarioModel usuarioModel){
        return service.cadastro(usuarioModel);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioModel usuarioModel){
        boolean autenticado =
                service.autenticar(
                        request.getNome(),
                        request.getSenha()
                );
        
        if(autenticado){
            return ResponseEntity.ok("Login realizado com sucesso");
        }
        
        return ResponseEntity
                .badRequest()
                .body("Usuário ou senha incorretos.");
}
}
}
