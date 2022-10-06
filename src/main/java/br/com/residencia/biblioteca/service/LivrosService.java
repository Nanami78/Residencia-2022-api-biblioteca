package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.residencia.biblioteca.entity.Livros;

import br.com.residencia.biblioteca.repository.LivroRepository;

@Service
public class LivrosService {
	@Autowired
	LivroRepository livroRepository ;
	
	public List<Livros>getAllLivros(){
		return livroRepository.findAll();
	}

public Livros getLivrosById(Integer id) {
//	return alunoRepository.findById(id).orElse(null);
    return livroRepository.findById(id).get();

}
public Livros saveLivros(Livros livro) {
	return livroRepository.save(livro);
}

public Livros updateLivros(Livros livro, Integer id) {
	Livros alunoExistenteNoBanco = livroRepository.findById(id).get();	
	alunoExistenteNoBanco.setCodigoisbn(livro.getCodigoisbn());
	alunoExistenteNoBanco.setCodigolivro(livro.getCodigolivro());
	alunoExistenteNoBanco.setDatalancamento(livro.getDatalancamento());
	alunoExistenteNoBanco.setEditora(livro.getEditora());
	alunoExistenteNoBanco.setEmprestimo(livro.getEmprestimo());
	alunoExistenteNoBanco.setEmprestimos(livro.getEmprestimos());
	alunoExistenteNoBanco.setNomeautor(livro.getNomeautor());
	alunoExistenteNoBanco.setNomelivro(livro.getNomelivro());

	
	return livroRepository.save(alunoExistenteNoBanco);
}

public Livros deleteLivros(Integer id)
{
	livroRepository.deleteById(id);
	return getLivrosById(id);
}
}
