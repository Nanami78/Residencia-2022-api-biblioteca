package br.com.residencia.biblioteca.entity;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoemprestimo")
	private Integer codigoemprestimo;

	@Column(name = "dataemprestimo")
	private Instant dataemprestimo;

	@Column(name = "dataentrega")
	private Instant dataentrega;

	@Column(name = " valoremprestimo")
	private BigDecimal valoremprestimo;

	@ManyToOne
	@JoinColumn(name = "codigolivro", referencedColumnName = "codigolivro")
	Livros livro;

	@ManyToOne
	@JoinColumn(name = "numeromatriculaaluno", referencedColumnName = "numeromatriculaaluno")
	private Aluno aluno;

	public Integer getCodigoemprestimo() {
		return codigoemprestimo;
	}

	public void setCodigoemprestimo(Integer codigoemprestimo) {
		this.codigoemprestimo = codigoemprestimo;
	}

	public Instant getDataemprestimo() {
		return dataemprestimo;
	}

	public void setDataemprestimo(Instant dataemprestimo) {
		this.dataemprestimo = dataemprestimo;
	}

	public Instant getDataentrega() {
		return dataentrega;
	}

	public void setDataentrega(Instant dataentrega) {
		this.dataentrega = dataentrega;
	}

	public BigDecimal getValoremprestimo() {
		return valoremprestimo;
	}

	public void setValoremprestimo(BigDecimal valoremprestimo) {
		this.valoremprestimo = valoremprestimo;
	}

	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
