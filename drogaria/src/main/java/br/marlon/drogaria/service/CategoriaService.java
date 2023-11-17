package br.marlon.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.marlon.drogaria.domain.Categoria;
import br.marlon.drogaria.exception.RecursoNaoEncontradoException;
import br.marlon.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		if(resultado.isEmpty()){
			throw new RecursoNaoEncontradoException();
		}
		Categoria categoria = resultado.get();
		return categoria;
	}
	
	public List<Categoria> listar(){
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado;
	}
	
	public Categoria inserir(Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	
	public Categoria excluir(Short codigo) {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		if(categoria.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		categoriaRepository.delete(categoria.get());
		return categoria.get();
	}
	
	public Categoria editar(Categoria categoria) {
		Categoria categoriaEditada = categoriaRepository.save(categoria);
		return categoriaEditada;
	}
	
	public List<Categoria> buscaPorNome(String nome) {
		List<Categoria> resultado = categoriaRepository.buscarPorNome(nome);
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		return resultado;
	}
}
