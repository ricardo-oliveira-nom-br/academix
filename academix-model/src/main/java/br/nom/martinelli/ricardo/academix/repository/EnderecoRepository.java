package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Endereco;

public class EnderecoRepository extends AbstractRepository<Endereco, Long> {
	
	public EnderecoRepository() {
		super(Endereco.class);
	}
	
	public boolean validaDados(Endereco endereco) {
		boolean valido = false;
		
		valido = endereco.getLogradouro() != null && !"".equals(endereco.getLogradouro()) && endereco.getLogradouro().length() <= 50;
		valido = endereco.getCep() != null && !"".equals(endereco.getCep()) && endereco.getCep().length() <= 8;
		valido = (endereco.getBairro() == null) ? true : endereco.getBairro().length() <= 40;
		valido = (endereco.getCidade() == null) ? true : endereco.getCidade().length() <= 40;
		
		return valido;
	}

}
