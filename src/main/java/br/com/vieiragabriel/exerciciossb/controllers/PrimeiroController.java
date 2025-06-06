package br.com.vieiragabriel.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
    // Este é um exemplo de controlador Spring Boot
    // Aqui você pode definir endpoints, injeção de dependências, etc.

    @RequestMapping({"/", "/hello"})
    public String hello() {
        return "Hello, World!";
    }

    @RequestMapping("/teste")
    public String teste() {
        return "Teste de endpoint! teste";
    }

    @GetMapping("/get")
    public String get() {
        return "GET request received!";
    }
}
