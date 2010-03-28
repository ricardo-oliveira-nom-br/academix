package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("localizacaoList")
public class LocalizacaoList extends EntityQuery<Localizacao> {

	private static final long serialVersionUID = 5296178240300834673L;

	private static final String EJBQL = "select localizacao from Localizacao localizacao";

	private static final String[] RESTRICTIONS = { "lower(localizacao.desLocalizacao) like lower(concat(#{localizacaoList.localizacao.desLocalizacao},'%'))", };

	private Localizacao localizacao = new Localizacao();

	public LocalizacaoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}
}
