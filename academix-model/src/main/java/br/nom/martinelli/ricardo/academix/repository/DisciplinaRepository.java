package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Disciplina;

public class DisciplinaRepository extends AbstractRepository<Disciplina, Long> {

	public DisciplinaRepository() {
		super(Disciplina.class);
	}

	@Override
	public boolean validaDados(Disciplina entidade) {
		// TODO Implementar validação
		return false;
	}

}
