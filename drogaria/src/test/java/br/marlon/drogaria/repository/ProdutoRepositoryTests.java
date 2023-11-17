package br.marlon.drogaria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.marlon.drogaria.domain.Produto;

@SpringBootTest
public class ProdutoRepositoryTests {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	public void inserir() {
		Produto p1 = new Produto();
		p1.setCodigo(null);
		p1.setNome("Coca-Cola");
		p1.setQuantidade(Short.valueOf("15"));
		p1.setPreco(BigDecimal.valueOf(10.50));
		p1.setDataDeValidade(LocalDate.of(2023, 11, 23));
		
		Produto p2 = new Produto();
		p2.setCodigo(null);
		p2.setNome("Heineken");
		p2.setQuantidade(Short.valueOf("23"));
		p2.setPreco(BigDecimal.valueOf(8.00));
		p2.setDataDeValidade(LocalDate.of(2023, 1, 03));
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
	}
}
