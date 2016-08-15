package br.nom.martinelli.ricardo.academix.repository;

import br.nom.martinelli.ricardo.academix.model.Localizacao;

public class LocalizacaoRepository extends AbstractRepository<Localizacao, Long> {

	public LocalizacaoRepository() {
		super(Localizacao.class);
	}

	@Override
	public boolean validaDados(Localizacao entidade) {
		// TODO Implementar validação
		return false;
	}

}
