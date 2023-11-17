package br.marlon.drogaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.marlon.drogaria.service.FornecedorService;
import br.marlon.drogaria.domain.Fornecedor;
import br.marlon.drogaria.exception.RecursoNaoEncontradoException;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public List<Fornecedor> listar(){
		List<Fornecedor> listar = fornecedorService.listar();
		return listar;
	}
	
	@GetMapping("/por-codigo/{codigo}")
	public Fornecedor buscarPorCodigo(@PathVariable Short codigo) {
		try {
			Fornecedor resultado = fornecedorService.buscarPorCodigo(codigo);
			return resultado;
		}catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado", excecao);
		}
	}
	
	@PostMapping
	public Fornecedor inserir(@RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorSalvo = fornecedorService.inserir(fornecedor);
		return fornecedorSalvo;
	}
	
	@DeleteMapping("/{codigo}")
	public Fornecedor excluir(@PathVariable Short codigo) {
		try {
			Fornecedor resultado = fornecedorService.excluir(codigo);
			return resultado;
		}catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado", excecao);
		}
	}
	
	@PutMapping
	public Fornecedor editar(Fornecedor fornecedor) {
		Fornecedor fornecedorSalvo = fornecedorService.editar(fornecedor);
		return fornecedorSalvo;
	}
	
	@GetMapping("/por-nome")
	public List<Fornecedor> buscarPorNome(String nome){
		try {
			List<Fornecedor> resultado = fornecedorService.buscarPorNome(nome);
			return resultado;
		}catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado", excecao);
		}
	}

}
