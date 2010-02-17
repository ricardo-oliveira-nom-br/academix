package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("faltaItemList")
public class FaltaItemList extends EntityQuery<FaltaItem> {

	private static final String EJBQL = "select faltaItem from FaltaItem faltaItem";

	private static final String[] RESTRICTIONS = {};

	private FaltaItem faltaItem = new FaltaItem();

	public FaltaItemList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public FaltaItem getFaltaItem() {
		return faltaItem;
	}
}
