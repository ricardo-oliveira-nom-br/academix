package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("historicoItemList")
public class HistoricoItemList extends EntityQuery<HistoricoItem> {

	private static final String EJBQL = "select historicoItem from HistoricoItem historicoItem";

	private static final String[] RESTRICTIONS = {};

	private HistoricoItem historicoItem;

	public HistoricoItemList() {
		historicoItem = new HistoricoItem();
		historicoItem.setId(new HistoricoItemId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public HistoricoItem getHistoricoItem() {
		return historicoItem;
	}
}
