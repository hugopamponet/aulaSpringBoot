package br.com.pratica.login.controller;

import br.com.pratica.login.dto.PastaDto;
import br.com.pratica.login.service.PastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arquivo")
@CrossOrigin("*")
public class PastaController {
    @Autowired
    private PastaService service;
    
    @PostMapping("/uploadArquivo")
    public PastaDto uploadPasta(@RequestBody PastaDto pasta) {
        return service.pasta(pasta);
    }
}
