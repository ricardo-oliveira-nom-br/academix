package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Curso;

public class CursoRepository extends AbstractRepository<Curso, Long> {

	public CursoRepository() {
		super(Curso.class);
	}

	@Override
	public boolean validaDados(Curso entidade) {
		boolean valido = true;
		
		// TODO Implementar validação
		return valido;
	}

}
