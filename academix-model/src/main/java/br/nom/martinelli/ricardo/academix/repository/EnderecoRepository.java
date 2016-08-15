package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Endereco;

public class EnderecoRepository extends AbstractRepository<Endereco, Long> {
	
	public EnderecoRepository() {
		super(Endereco.class);
	}
	
	public boolean validaDados(Endereco endereco) {
		// TODO Implementar validação
		return false;
	}

}
