package br.com.residencia.biblioteca.entity;

import java.time.Instant;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numeromatriculaaluno")
	private Integer numeromatriculaaluno;
	@Column(name = "nome")
	private String nome;
	public Integer getNumeroMatriculaAluno() {
		return numeromatriculaaluno;
	}
	public void setNumeroMatriculaAluno(Integer numeroMatriculaAluno) {
		this.numeromatriculaaluno = numeroMatriculaAluno;
	}
	@Column(name = "datanascimento")
	private Instant datanascimento;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "numerologradouro")
	private String numerologradouro;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "bairro")
	private String bairro;
	@Column(name = "cidade")
	private String cidade;
	
	@OneToMany(mappedBy = "aluno")
	private Set<Emprestimo> emprestimos;
	
	public Set<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(Set<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Instant getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Instant data) {
		this.datanascimento = data;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumerologradouro() {
		return numerologradouro;
	}
	public void setNumerologradouro(String numerologradouro) {
		this.numerologradouro = numerologradouro;
	}
	public String getComplemento() { 
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	






	
	
	
	
}
