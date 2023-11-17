package br.marlon.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.marlon.drogaria.domain.Produto;
import br.marlon.drogaria.exception.RecursoNaoEncontradoException;
import br.marlon.drogaria.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscarPorCodigo(Short codigo) {
		Optional<Produto> resultado = produtoRepository.findById(codigo);
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		return resultado.get();	
	}
	
	public List<Produto> listar(){
		List<Produto> resultado = produtoRepository.findAll();
		return resultado;
	}
	
	public Produto inserir(Produto produto) {
		Produto produtoSalvo = produtoRepository.save(produto);
		return produtoSalvo;
	}
	
	public Produto excluir(Short codigo) {
		Optional<Produto> produto = produtoRepository.findById(codigo);
		if(produto.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		produtoRepository.delete(produto.get());
		return produto.get();
	}
	
	public Produto editar(Produto produto) {
		Produto produtoEditado = produtoRepository.save(produto);
		return produtoEditado;
	}
	
	public List<Produto> buscarPorNome(String nome){
		List<Produto> resultado = produtoRepository.buscarPorNome(nome);
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		return resultado;
	}

}
