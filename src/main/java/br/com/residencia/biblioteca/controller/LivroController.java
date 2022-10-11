package br.com.residencia.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.biblioteca.entity.Livros;
import br.com.residencia.biblioteca.service.LivrosService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	LivrosService livroService;
	
	@GetMapping
	public ResponseEntity<List<Livros>> getAllLivros(){
		return new ResponseEntity<>(livroService.getAllLivros(),
				HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livros> getLivroById(@PathVariable Integer id) {
		Livros livro = livroService.getLivrosById(id);
		if(null != livro)
			return new ResponseEntity<>(livro,
					HttpStatus.OK);
		else
			return new ResponseEntity<>(livro,
					HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Livros> saveLivro(@RequestBody Livros livro) {
		return new ResponseEntity<>(livroService.saveLivro(livro),
				HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livros> updateLivro(@RequestBody Livros livro, 
			@PathVariable Integer id){
		return new ResponseEntity<>(livroService.updateLivro(livro, id),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Livros> deleteLivro(@PathVariable Integer id) {
		Livros livro = livroService.getLivrosById(id);
		if(null == livro)
			return new ResponseEntity<>(livro,
					HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(livroService.deleteLivros(id),
					HttpStatus.OK);
	}

}
