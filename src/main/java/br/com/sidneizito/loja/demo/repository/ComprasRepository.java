package br.com.sidneizito.loja.demo.repository;

import br.com.sidneizito.loja.demo.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compras, Integer> {
}
