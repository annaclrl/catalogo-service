package br.com.fiap.microservices.catalogoservice.repository;

import br.com.fiap.microservices.catalogoservice.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
