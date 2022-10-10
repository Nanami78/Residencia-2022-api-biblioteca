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

    return emprestimoRepository.findById(id).get();

}
public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
	return emprestimoRepository.save(emprestimo);
}

public Emprestimo updateEmprestimo(Emprestimo emprestimo, Integer id) {
	//Emprestimo emprestimoExistenteNoBanco = emprestimoRepository.findById(id).get();	
	//empretimoExistenteNoBanco.setAluno(Aluno);
	Emprestimo emprestimoExistenteNoBanco = getEmprestimoById(id);
	emprestimoExistenteNoBanco.setCodigoemprestimo(emprestimo.getCodigoemprestimo());
	
	emprestimoExistenteNoBanco.setDataemprestimo(emprestimo.getDataemprestimo());
	emprestimoExistenteNoBanco.setDataentrega(emprestimo.getDataentrega());
	emprestimoExistenteNoBanco.setLivro(emprestimo.getLivro());
	emprestimoExistenteNoBanco.setAluno(emprestimo.getAluno());
	emprestimoExistenteNoBanco.setValoremprestimo(emprestimo.getValoremprestimo());
	

	
	return emprestimoRepository.save(emprestimoExistenteNoBanco);
}

public Emprestimo deleteEmprestimo(Integer id)
{
	emprestimoRepository.deleteById(id);
	return getEmprestimoById(id);
}
}


