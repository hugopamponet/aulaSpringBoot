package br.com.pratica.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.pratica.login.service.UsuarioService;
import br.com.pratica.login.dto.LoginDto;
import br.com.pratica.login.dto.UsuarioDto;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastrar")
    public UsuarioDto cadastrar(@RequestBody UsuarioDto usuario) {

        return service.cadastro(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto usuario) {

        boolean autenticado =
                service.login(
                        usuario.getNome(),
                        usuario.getSenha());

        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso!");
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Usuário ou senha inválidos!");
    }
}