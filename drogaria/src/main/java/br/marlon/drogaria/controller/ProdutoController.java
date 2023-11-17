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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.marlon.drogaria.domain.Produto;
import br.marlon.drogaria.exception.RecursoNaoEncontradoException;
import br.marlon.drogaria.service.ProdutoService;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping 
	public List<Produto> listar(){
		List<Produto> listar = produtoService.listar();
		return listar;
	}
	
	@GetMapping("/por-codigo/{codigo}")
	public Produto buscarPorCodigo(@PathVariable Short codigo) {
		try {
			Produto produto = produtoService.buscarPorCodigo(codigo);
			return produto;
		}catch(RecursoNaoEncontradoException excecao){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", excecao);
		}
	}
	
	@PostMapping
	public Produto inserir(@RequestBody Produto produto) {
		Produto produtoSalvo = produtoService.inserir(produto);
		return produtoSalvo;
	}
	
	@DeleteMapping("/{codigo}")
	public Produto excluir(@PathVariable Short codigo) {
		try {
			Produto produto = produtoService.excluir(codigo);
			return produto;
		}catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", excecao);
		}
	}
	
	@PutMapping
	public Produto editar(Produto produto) {
		Produto produtoEditado = produtoService.editar(produto);
		return produtoEditado;
	}
	
	@GetMapping("/por-nome")
	public List<Produto> buscaPorNome(@RequestParam String nome) {
		try {
			List<Produto> resultado = produtoService.buscarPorNome(nome);
			return resultado;
		}catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado", excecao);
		}
	}
	
	
}
