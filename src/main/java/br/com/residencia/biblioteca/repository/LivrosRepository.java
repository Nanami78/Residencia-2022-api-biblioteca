package br.com.residencia.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.entity.Livros;

public interface LivrosRepository
	extends JpaRepository<Livros,Integer>
{
	public List<Livros> findByEditora(Editora editora);
	
	public List<Livros> findByNomeLivro(String nome);
	
	public List<Livros> findByNomeAutor(String autor);
}
	
