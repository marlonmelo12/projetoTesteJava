package br.marlon.drogaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.marlon.drogaria.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Short>{
	@Query("SELECT produto FROM Produto produto WHERE LOWER(produto.nome) = LOWER(:nome)")
    List<Produto> buscarPorNome(@Param("nome") String nome);
}
