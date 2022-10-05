package br.com.residencia.biblioteca.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer codigolivro ;
	@Column(name = "nomelivro")
	private String nomelivro ;
	@Column(name = "nomeautor")
	private String nomeautor ;
	@Column(name = "datalancamento")
	private Instant datalancamento ;
	@Column(name ="codigoisbn")
	private Integer codigoisbn ;
	
	//@Column(name = "codigoeditora")
	//private Integer codigoeditora ;
	
	@ManyToOne
	@JoinColumn(name = "codigoeditora", referencedColumnName = "codigoeditora")
	private Editora editora;
    @OneToOne(mappedBy = "Livros")
	private Emprestimo emprestimos;
	
	public Integer getCodigolivro() {
		return codigolivro;
	}

	public void setCodigolivro(Integer codigolivro) {
		this.codigolivro = codigolivro;
	}

	public String getNomelivro() {
		return nomelivro;
	}

	public void setNomelivro(String nomelivro) {
		this.nomelivro = nomelivro;
	}

	public String getNomeautor() {
		return nomeautor;
	}

	public void setNomeautor(String nomeautor) {
		this.nomeautor = nomeautor;
	}

	public Instant getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(Instant datalancamento) {
		this.datalancamento = datalancamento;
		
	}

	public Integer getCodigoisbn() {
		return codigoisbn;
	}

	public void setCodigoisbn(Integer codigoisbn) {
		this.codigoisbn = codigoisbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}


@OneToOne(mappedBy = "livro")
private Emprestimo emprestimo;

public Emprestimo getEmprestimo() {
	return emprestimo;
}

public void setEmprestimo(Emprestimo emprestimo) {
	this.emprestimo = emprestimo;
}



}

