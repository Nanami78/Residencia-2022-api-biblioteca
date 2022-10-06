package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.*;
import br.com.residencia.biblioteca.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository ;
	
	public List<Emprestimo>getAllEmprestimo(){
		return emprestimoRepository.findAll();
	}

public Emprestimo getEmprestimoById(Integer id) {
//	return alunoRepository.findById(id).orElse(null);
    return emprestimoRepository.findById(id).get();

}
public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
	return emprestimoRepository.save(emprestimo);
}

public Emprestimo updateEmprestimo(Emprestimo emprestimo, Integer id) {
	Emprestimo alunoExistenteNoBanco = emprestimoRepository.findById(id).get();	
	alunoExistenteNoBanco.setCodigoemprestimo(emprestimo.getCodigoemprestimo());
	alunoExistenteNoBanco.setCodigolivro(emprestimo.getCodigolivro());
	alunoExistenteNoBanco.setDataemprestimo(emprestimo.getDataemprestimo());
	alunoExistenteNoBanco.setDataentrega(emprestimo.getDataentrega());
	alunoExistenteNoBanco.setLivro(emprestimo.getLivro());
	alunoExistenteNoBanco.setNumeromatriculaaluno(emprestimo.getNumeromatriculaaluno());
	alunoExistenteNoBanco.setValoremprestimo(emprestimo.getValoremprestimo());
	

	
	return emprestimoRepository.save(alunoExistenteNoBanco);
}

public Emprestimo deleteEmprestimo(Integer id)
{
	emprestimoRepository.deleteById(id);
	return getEmprestimoById(id);
}
}
