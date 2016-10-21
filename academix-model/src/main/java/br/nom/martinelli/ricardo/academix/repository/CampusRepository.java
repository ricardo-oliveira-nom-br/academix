package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Campus;

public class CampusRepository extends AbstractRepository<Campus, Long> {

	public CampusRepository() {
		super(Campus.class);
	}

	public boolean validaDados(Campus campus) {
		boolean valido = false;
		
		valido = campus.getNome() != null && !"".equals(campus.getNome());
		valido = campus.getEndereco() != null && campus.getEndereco().getId() != null;
		valido = campus.getNumero() != null && campus.getNumero().intValue() > 0;
		valido = (campus.getComplemento() == null) ? true : !"".equals(campus.getComplemento()) && campus.getComplemento().length() <= 30;
		
		return valido;
	}
	
}
