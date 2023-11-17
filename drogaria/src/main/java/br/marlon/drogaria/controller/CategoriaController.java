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

import br.marlon.drogaria.domain.Categoria;
import br.marlon.drogaria.exception.RecursoNaoEncontradoException;
import br.marlon.drogaria.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaService.listar();
		return categorias;
	}
	
	@GetMapping("/por-codigo/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo) {
		try {
			Categoria categoria = categoriaService.buscarPorCodigo(codigo);
			return categoria;
		}catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", excecao);
		}
	}
	
	@PostMapping
	public Categoria inserir(@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaService.inserir(categoria);
		return categoriaSalva;
	}
	
	@DeleteMapping("/{codigo}")
	public Categoria excluir(@PathVariable Short codigo) {
		try {
			Categoria categoria = categoriaService.excluir(codigo);
			return categoria;
		}catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", excecao);
		}
	}
	
	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaService.editar(categoria);
		return categoriaEditada;
	}
	
	@GetMapping("/por-nome")
	public List<Categoria> buscaPorNome(@RequestParam String nome){
		try {
			List<Categoria> resultado = categoriaService.buscaPorNome(nome);
			return resultado;
		}catch(RecursoNaoEncontradoException excecao) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", excecao);
		}
	}
}
