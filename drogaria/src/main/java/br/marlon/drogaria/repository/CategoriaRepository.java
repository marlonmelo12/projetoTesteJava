package br.marlon.drogaria.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.marlon.drogaria.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short> {
	@Query("SELECT categoria FROM Categoria categoria WHERE LOWER(categoria.nome) = LOWER(:nome)")
    List<Categoria> buscarPorNome(@Param("nome") String nome);
}
