package br.com.vieiragabriel.exerciciossb.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome do produto não pode estar em branco")
    private String nome;

    @Min(value = 0, message = "O preço deve ser maior ou igual a zero")
    private double preco;

    @Min(value = 0, message = "O desconto deve ser maior ou igual a zero")
    @Max(value = 1, message = "O desconto deve ser menor ou igual a um")
    private double desconto;

    public Produto() {
    }

    public Produto(String nome, double preco, double desconto) {
        super();
        setNome(nome);
        setPreco(preco);
        setDesconto(desconto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
