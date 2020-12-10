package br.com.sidneizito.loja.demo.repository;

import br.com.sidneizito.loja.demo.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
}
