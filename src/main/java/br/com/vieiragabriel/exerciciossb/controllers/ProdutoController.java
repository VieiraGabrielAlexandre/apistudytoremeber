package br.com.vieiragabriel.exerciciossb.controllers;

import br.com.vieiragabriel.exerciciossb.models.entities.Produto;
import br.com.vieiragabriel.exerciciossb.models.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto criarProduto(@Valid @ModelAttribute Produto produto) {
        produtoRepository.save(produto);

        return produto;
    }

    @GetMapping
    public Iterable<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProduto(@PathVariable int id) {
        return produtoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable int id, @Valid @ModelAttribute Produto produto) {
        if (produtoRepository.existsById(id)) {
            produto.setId(id);
            produtoRepository.save(produto);
            return produto;
        }
        return null; // ou lançar uma exceção
    }

    @PatchMapping("/{id}")
    public Produto atualizarParcialProduto(@PathVariable int id, @Valid @ModelAttribute Produto produto) {
        if (produtoRepository.existsById(id)) {
            Produto produtoExistente = produtoRepository.findById(id).orElseThrow();
            if (produto.getNome() != null) {
                produtoExistente.setNome(produto.getNome());
            }
            if (produto.getPreco() != 0) {
                produtoExistente.setPreco(produto.getPreco());
            }
            produtoRepository.save(produtoExistente);
            return produtoExistente;
        }
        return null; // ou lançar uma exceção
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable int id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        }
    }

    @GetMapping("/paginacao/{page}/{size}")
    public Page<Produto> getProdutosPaginados(@PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        return produtoRepository.findAll(pageable);
    }

    @GetMapping("/nome/{nome}")
    public Iterable<Produto> getProdutosPorNome(@PathVariable String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

}
