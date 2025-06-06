package br.com.vieiragabriel.exerciciossb.controllers;

import br.com.vieiragabriel.exerciciossb.models.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable int id) {
            return new Cliente(id, "Gabriel", "123.456.789-00");
    }

    @PostMapping("/{id}")
    public Cliente criarCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        // Aqui você poderia criar o cliente no banco de dados
        // Por enquanto, apenas retornamos o cliente atualizado
        cliente.setId(Integer.parseInt(id));
        return cliente;
    }

    @PatchMapping("/{id}")
    public Cliente atualizarParcialmenteCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        // Aqui você poderia atualizar parcialmente o cliente no banco de dados
        // Por enquanto, apenas retornamos o cliente atualizado
        cliente.setId(Integer.parseInt(id));
        return cliente;
    }

    @GetMapping("/obter-query")
    public Cliente obterClientePorQuery(@RequestParam String nome, @RequestParam int id) {
        // Aqui você poderia buscar o cliente no banco de dados
        // Por enquanto, apenas retornamos um cliente fictício
        return new Cliente(id, nome, "123.456.789-00");
    }
}
