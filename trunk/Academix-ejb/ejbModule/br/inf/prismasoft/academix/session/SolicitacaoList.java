package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("solicitacaoList")
public class SolicitacaoList extends EntityQuery<Solicitacao> {

	private static final String EJBQL = "select solicitacao from Solicitacao solicitacao";

	private static final String[] RESTRICTIONS = {};

	private Solicitacao solicitacao = new Solicitacao();

	public SolicitacaoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
}
