package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.GradeCurricular;

public class GradeCurricularRepository extends AbstractRepository<GradeCurricular, Long> {

	protected GradeCurricularRepository() {
		super(GradeCurricular.class);
	}

	public boolean validaDados(GradeCurricular entidade) {
		return false;
	}

}