package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("avaliacaoItemList")
public class AvaliacaoItemList extends EntityQuery<AvaliacaoItem> {

	private static final String EJBQL = "select avaliacaoItem from AvaliacaoItem avaliacaoItem";

	private static final String[] RESTRICTIONS = {};

	private AvaliacaoItem avaliacaoItem = new AvaliacaoItem();

	public AvaliacaoItemList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public AvaliacaoItem getAvaliacaoItem() {
		return avaliacaoItem;
	}
}
