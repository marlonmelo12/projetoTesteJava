package br.marlon.drogaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.marlon.drogaria.domain.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Short>{
	@Query("SELECT fornecedor FROM Fornecedor fornecedor WHERE LOWER(fornecedor.nome) = LOWER(:nome)")
    List<Fornecedor> buscarPorNome(@Param("nome") String nome);
}
