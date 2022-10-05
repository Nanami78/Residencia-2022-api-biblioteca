package br.com.residencia.biblioteca.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.residencia.biblioteca.entity.Livros;

public interface LivroRepository extends JpaRepository<Livros,Integer>
	{
}
