package br.marlon.drogaria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Short codigo;
	
	@Column(length = 50, nullable = false, unique = true)
	private String nome;
	
	@OneToMany
	@JoinColumn(nullable = false)
	private Produto produtoFornecido;
}
