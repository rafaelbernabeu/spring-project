package br.rafaelbernabeu.springProject.controller;

import br.rafaelbernabeu.springProject.config.cargaInicial.LocalidadesCarga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private LocalidadesCarga localidadesCarga;

    @RequestMapping(method = RequestMethod.GET)
    public String test() throws IOException {
        localidadesCarga.setup();
        return "";
    }

}
