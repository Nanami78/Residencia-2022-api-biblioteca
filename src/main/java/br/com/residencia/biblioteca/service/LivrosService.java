package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.dto.LivrosDTO;
import br.com.residencia.biblioteca.entity.Livros;
import br.com.residencia.biblioteca.repository.LivrosRepository;

@Service
public class LivrosService {
	@Autowired
	LivrosRepository livroRepository;
	
	public List<Livros> getAllLivros(){
		return livroRepository.findAll();
	}
	
	public Livros getLivroById(Integer id) {
		return livroRepository.findById(id).get();
		//return livroRepository.findById(id).orElse(null);
	}
	
	public Livros saveLivro(Livros livro) {
		return livroRepository.save(livro);
	}

	public LivrosDTO saveLivrosDTO(LivrosDTO livroDTO) {
		Livros livro = toEntidade(livroDTO);
		Livros novoLivro = livroRepository.save(livro);
		
		LivrosDTO livroAtualizadoDTO = toDTO(novoLivro);
		return livroAtualizadoDTO;
	}
	
	public Livros updateLivro(Livros livro, Integer id) {
		//Livro livroExistenteNoBanco = livroRepository.findById(id).get();
		
		Livros livroExistenteNoBanco = getLivroById(id);

		livroExistenteNoBanco.setCodigoIsbn(livro.getCodigoIsbn());
		livroExistenteNoBanco.setDataLancamento(livro.getDataLancamento());
		//livroExistenteNoBanco.setEditora(Editora);
		//livroExistenteNoBanco.setEmprestimo(Emprestimo);
		livroExistenteNoBanco.setNomeAutor(livro.getNomeAutor());
		livroExistenteNoBanco.setNomeLivro(livro.getNomeLivro());
		
		return livroRepository.save(livroExistenteNoBanco);
		
		//return livroRepository.save(livro);
	}
	
	public LivrosDTO updateLivroDTO(LivrosDTO livroDTO, Integer id) {
		Livros livroExistenteNoBanco = getLivroById(id);
		LivrosDTO livroAtualizadoDTO = new LivrosDTO();
		
		if(livroExistenteNoBanco != null) {
			
			livroExistenteNoBanco = toEntidade(livroDTO);
			
			Livros livroAtualizado = livroRepository.save(livroExistenteNoBanco);
			
			livroAtualizadoDTO = toDTO(livroAtualizado);
			
		}
		return livroAtualizadoDTO;
	}
	
	public Livros toEntidade (LivrosDTO livroDTO) {
		Livros livro = new Livros();
		livro.setNomeLivro(livroDTO.getNomeLivro());
		livro.setNomeAutor(livroDTO.getNomeAutor());
		livro.setDataLancamento(livroDTO.getDataLancamento());
		livro.setCodigoIsbn(livroDTO.getCodigoIsbn());
		
		
		
		return livro;
	}
	
	public LivrosDTO toDTO(Livros livro) {
		LivrosDTO livroDTO = new LivrosDTO();
		livroDTO.setCodigoLivro(livro.getCodigoLivro());
		livroDTO.setNomeAutor(livro.getNomeAutor());
		livroDTO.setNomeLivro(livro.getNomeLivro());
		livroDTO.setDataLancamento(livro.getDataLancamento());
		livroDTO.setCodigoIsbn(livro.getCodigoIsbn());
		livroDTO.setCodigoLivro(livro.getCodigoLivro());

		return livroDTO;
	}

	public Livros deleteLivro(Integer id) {
		livroRepository.deleteById(id);
		return getLivroById(id);
	}
	
}