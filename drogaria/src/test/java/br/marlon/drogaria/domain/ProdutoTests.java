package br.marlon.drogaria.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTests {
	@Test
	public void criar() {
		Produto p = new Produto();
		p.setCodigo(Short.valueOf("1"));
		p.setNome("Coca-Cola");
		p.setQuantidade(Short.valueOf("15"));
		p.setPreco(BigDecimal.valueOf(10.50));
		LocalDate.of(2023, 11, 23);
		
		System.out.println(p);
	}
	
}
