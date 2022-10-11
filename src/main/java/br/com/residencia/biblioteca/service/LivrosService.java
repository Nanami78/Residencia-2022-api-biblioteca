package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.Livros;
import br.com.residencia.biblioteca.repository.LivroRepository;

@Service
public class LivrosService {
	@Autowired
	LivroRepository livroRepository;
	
	public List<Livros> getAllLivros(){
		return livroRepository.findAll();
	}
	
	public Livros getLivrosById(Integer id) {
		return livroRepository.findById(id).get();
		//return livroRepository.findById(id).orElse(null);
	}
	
	public Livros saveLivro(Livros livro) {
		return livroRepository.save(livro);
	}
	
	public Livros updateLivro(Livros livro, Integer id) {
		//Livro livroExistenteNoBanco = livroRepository.findById(id).get();
		
		Livros livroExistenteNoBanco = getLivrosById(id);

		livroExistenteNoBanco.setCodigoIsbn(livro.getCodigoIsbn());
		livroExistenteNoBanco.setDataLancamento(livro.getDataLancamento());
		//livroExistenteNoBanco.setEditora(Editora);
		//livroExistenteNoBanco.setEmprestimo(Emprestimo);
		livroExistenteNoBanco.setNomeAutor(livro.getNomeAutor());
		livroExistenteNoBanco.setNomeLivro(livro.getNomeLivro());
		
		return livroRepository.save(livroExistenteNoBanco);
		
		//return livroRepository.save(livro);
	}

	public Livros deleteLivros(Integer id) {
		livroRepository.deleteById(id);
		return getLivrosById(id);
	}
	
}