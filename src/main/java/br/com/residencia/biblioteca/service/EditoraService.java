package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.repository.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	EditoraRepository editoraRepository ;
	
	public List<Editora>getAllEditora(){
		return editoraRepository.findAll();
	}

public Editora getEditoraById(Integer id) {
//	return alunoRepository.findById(id).orElse(null);
    return editoraRepository.findById(id).get();

}
public Editora saveEditora(Editora aluno) {
	return editoraRepository.save(aluno);
}

public Editora updateEditora(Editora editora, Integer id) {
	Editora alunoExistenteNoBanco = editoraRepository.findById(id).get();	
	alunoExistenteNoBanco.setCodigoEditora(editora.getCodigoEditora());
	alunoExistenteNoBanco.setLivros(editora.getLivros());
	alunoExistenteNoBanco.setNome(editora.getNome());
	return editoraRepository.save(alunoExistenteNoBanco);
}

public Editora deleteEditora(Integer id)
{
	editoraRepository.deleteById(id);
	return getEditoraById(id);
}

}
