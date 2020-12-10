package br.com.sidneizito.loja.demo.model;

public class ClienteQtCompras {
    public String nome;
    public int qtCompras;

    public ClienteQtCompras(String nome, int qtCompras) {
        this.nome = nome;
        this.qtCompras = qtCompras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int qtCompras() {
        return qtCompras;
    }

    public void setValorTotal(int qtCompras) {
        this.qtCompras = qtCompras;
    }
}
