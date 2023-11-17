package br.marlon.drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.marlon.drogaria.domain.Fornecedor;
import br.marlon.drogaria.exception.RecursoNaoEncontradoException;
import br.marlon.drogaria.repository.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor buscarPorCodigo(Short codigo) {
		Optional <Fornecedor> resultado = fornecedorRepository.findById(codigo);
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		return resultado.get();	
	}
	
	public List<Fornecedor> listar(){
		List<Fornecedor> resultado = fornecedorRepository.findAll();
		return resultado;
	}
	
	public Fornecedor inserir(Fornecedor fornecedor) {
		Fornecedor fornecedorSalvo = fornecedorRepository.save(fornecedor);
		return fornecedorSalvo;
	}
	
	public Fornecedor excluir(Short codigo) {
		Optional <Fornecedor> resultado = fornecedorRepository.findById(codigo);
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		fornecedorRepository.delete(resultado.get());
		return resultado.get();
	}
	
	public Fornecedor editar(Fornecedor fornecedor) {
		Fornecedor fornecedorEditado = fornecedorRepository.save(fornecedor);
		return fornecedorEditado;
	}
	
	public List<Fornecedor> buscarPorNome(String nome) {
		List<Fornecedor> resultado = fornecedorRepository.buscarPorNome(nome);
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		return resultado;
	}

}
