package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Localizacao;

public class LocalizacaoRepository extends AbstractRepository<Localizacao, Long> {

	public LocalizacaoRepository() {
		super(Localizacao.class);
	}

	@Override
	public boolean validaDados(Localizacao entidade) {
		boolean valido = false;
		
		valido = entidade.getCampus() != null && entidade.getCampus().getId() != null;
		valido = entidade.getNome() != null && !"".equals(entidade.getNome()) && entidade.getNome().length() <= 30;
		valido = entidade.getQuantidade() != null && entidade.getQuantidade() <= 999;
		
		return valido;
	}

}
