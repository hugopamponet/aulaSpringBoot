package br.com.pratica.login.controller;

import br.com.pratica.login.dto.ArquivoDto;
import br.com.pratica.login.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arquivo")
@CrossOrigin("*")
public class ArquivoController {
    
    @Autowired
    private ArquivoService service;
    
    @PostMapping("/uploadArquivo")
    public ArquivoDto uploadArquivo(@RequestBody ArquivoDto arquivo) {
        return service.cadastro(arquivo);
    }
}
