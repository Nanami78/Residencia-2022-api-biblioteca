package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.residencia.biblioteca.entity.Aluno;

import br.com.residencia.biblioteca.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository ;
	
	public List<Aluno>getAllAlunos(){
		return alunoRepository.findAll();
	}

public Aluno getAlunoById(Integer id) {
//	return alunoRepository.findById(id).orElse(null);
    return alunoRepository.findById(id).get();

}
public Aluno saveAluno(Aluno aluno) {
	return alunoRepository.save(aluno);
}

public Aluno updateAluno(Aluno aluno, Integer id) {
	Aluno alunoExistenteNoBanco = alunoRepository.findById(id).get();
	
	//Aluno alunoExistenteNoBanco = getAlunoById(id);		
			
	alunoExistenteNoBanco.setBairro(aluno.getBairro());
	alunoExistenteNoBanco.setCidade(aluno.getBairro());
	alunoExistenteNoBanco.setComplemento(aluno.getBairro());
	alunoExistenteNoBanco.setCpf(aluno.getCpf());
	alunoExistenteNoBanco.setDatadenascimento(aluno.getDatadenascimento());
	alunoExistenteNoBanco.setEmprestimos(aluno.getEmprestimos());
	alunoExistenteNoBanco.setLogradouro(aluno.getLogradouro());
	alunoExistenteNoBanco.setNome(aluno.getNome());
	alunoExistenteNoBanco.setNumerologradouro(aluno.getNumerologradouro());
	alunoExistenteNoBanco.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
	return alunoRepository.save(alunoExistenteNoBanco);
}

public Aluno deleteAluno(Integer id) {
	alunoRepository.deleteById(id);
    return getAlunoById(id);

}


/*public Boolean deleteAlunoBool(Integer id) {
	alunoRepository.deleteById(id);
    if(null != getAlunoById(id))
    	return false;
    else
    	return true;}*/


}



