package br.com.sidneizito.loja.demo.repository;

import br.com.sidneizito.loja.demo.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
}
