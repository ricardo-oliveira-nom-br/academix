package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Disciplina;

public class DisciplinaRepository extends AbstractRepository<Disciplina, Long> {

	public DisciplinaRepository() {
		super(Disciplina.class);
	}

	public boolean validaDados(Disciplina disciplina) {
		boolean valido = false;
		
		valido = disciplina.getNome() != null && !"".equals(disciplina.getNome()) && disciplina.getNome().length() <= 30;
		valido = disciplina.getSigla() != null && !"".equals(disciplina.getSigla()) && disciplina.getSigla().length() <= 8;

		return valido;
	}

}
