package br.com.residencia.biblioteca.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoeditora")
	private Integer codigoeditora;


@Column(name = "nome")
private String nome;


@OneToMany(mappedBy = "editora")
private Set<Livros> livros;


public Integer getCodigoEditora() {
	return codigoeditora;
}


public void setCodigoEditora(Integer codigoEditora) {
	this.codigoeditora = codigoEditora;
}


public Set<Livros> getLivros() {
	return livros;
}


public void setLivros(Set<Livros> livros) {
	this.livros = livros;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}



}

