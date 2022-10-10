package br.com.residencia.biblioteca.repository;


	import org.springframework.data.jpa.repository.JpaRepository;

	import br.com.residencia.biblioteca.entity.Editora;
	
	public interface EditoraRepository extends
		JpaRepository<Editora, Integer>{
}
	
	/*public Boolean deleteEditoraBool(Integer id) {
	if(null != getEditoraById(id)) {
		editoraRespository.deleteById(id);
		return true;
	}
	returns false;*/

	/*public Editora deleteEditora(Integer id) {
		if(null != getEditoraById(id))
			editoraRepository.deleteById(id);
		
		return getEditoraById(id);*/
	