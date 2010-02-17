package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("historicoList")
public class HistoricoList extends EntityQuery<Historico> {

	private static final String EJBQL = "select historico from Historico historico";

	private static final String[] RESTRICTIONS = {};

	private Historico historico = new Historico();

	public HistoricoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Historico getHistorico() {
		return historico;
	}
}
