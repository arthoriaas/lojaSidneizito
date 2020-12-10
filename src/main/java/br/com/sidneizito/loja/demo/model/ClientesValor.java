package br.com.sidneizito.loja.demo.model;

public class ClientesValor {
    public String nome;
    public Double valorTotal;

    public ClientesValor(String nome, Double valorTotal) {
        this.nome = nome;
        this.valorTotal = valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
