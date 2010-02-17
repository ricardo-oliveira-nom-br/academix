package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("avaliacaoList")
public class AvaliacaoList extends EntityQuery<Avaliacao> {

	private static final String EJBQL = "select avaliacao from Avaliacao avaliacao";

	private static final String[] RESTRICTIONS = { "lower(avaliacao.codAvaliacao) like lower(concat(#{avaliacaoList.avaliacao.codAvaliacao},'%'))", };

	private Avaliacao avaliacao = new Avaliacao();

	public AvaliacaoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
}
