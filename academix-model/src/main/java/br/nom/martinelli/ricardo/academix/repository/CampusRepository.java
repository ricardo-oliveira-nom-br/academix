package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Campus;

public class CampusRepository extends AbstractRepository<Campus, Long> {

	public CampusRepository() {
		super(Campus.class);
	}

	@Override
	public boolean validaDados(Campus campus) {
		// TODO Implementar validação
		return false;
	}
	
}
