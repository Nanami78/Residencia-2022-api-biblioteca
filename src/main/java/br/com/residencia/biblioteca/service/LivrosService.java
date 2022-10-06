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
//	return livroRepository.findById(id).orElse(null);
    return livroRepository.findById(id).get();

}
public Livros saveLivros(Livros livro) {
	return livroRepository.save(livro);
}

public Livros updateLivros(Livros livro, Integer id) {
	Livros livroExistenteNoBanco = livroRepository.findById(id).get();	
	livroExistenteNoBanco.setCodigoisbn(livro.getCodigoisbn());
	livroExistenteNoBanco.setCodigolivro(livro.getCodigolivro());
	livroExistenteNoBanco.setDatalancamento(livro.getDatalancamento());
	//livroExistenteNoBanco.setEditora(livro.getEditora());
	//livroExistenteNoBanco.setEmprestimo(livro.getEmprestimo());
	//livroExistenteNoBanco.setEmprestimos(livro.getEmprestimos());
	livroExistenteNoBanco.setNomeautor(livro.getNomeautor());
	livroExistenteNoBanco.setNomelivro(livro.getNomelivro());

	
	return livroRepository.save(livroExistenteNoBanco);
}

public Livros deleteLivros(Integer id)
{
	livroRepository.deleteById(id);
	return getLivrosById(id);
}
}
