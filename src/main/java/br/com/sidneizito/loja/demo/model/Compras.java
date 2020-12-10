package br.com.sidneizito.loja.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.List;

@Entity
public class Compras {

    @Id
    @GeneratedValue
    public Long id;
    public String codigo;
    public String data;
    public String cliente;
    @OneToMany(mappedBy = "produto")
    public List<Produtos> itens;
    public double valorTotal;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public List<Produtos> getItens() {
        return itens;
    }
    public void setItens(List<Produtos> itens) {
        this.itens = itens;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}