package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Professor;

public class ProfessorRepository extends AbstractRepository<Professor, Long> {

	public ProfessorRepository() {
		super(Professor.class);
	}

	public boolean validaDados(Professor entidade) {
		// TODO Implementar validação
		return true;
	}

}
