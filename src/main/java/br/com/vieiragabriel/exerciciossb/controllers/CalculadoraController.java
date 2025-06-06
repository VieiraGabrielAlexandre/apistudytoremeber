package br.com.vieiragabriel.exerciciossb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/calculadora")
public class CalculadoraController {

    @PostMapping("/soma/{a}/{b}")
    public int soma(@PathVariable int a, @PathVariable int b) {
        // retorn object
        return a + b;
    }

    @PostMapping("/subtracao")
    public int subtracao(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }
}
