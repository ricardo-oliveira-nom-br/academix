package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("discGradeCurricularList")
public class DiscGradeCurricularList extends EntityQuery<DiscGradeCurricular> {

	private static final String EJBQL = "select discGradeCurricular from DiscGradeCurricular discGradeCurricular";

	private static final String[] RESTRICTIONS = {};

	private DiscGradeCurricular discGradeCurricular = new DiscGradeCurricular();

	public DiscGradeCurricularList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public DiscGradeCurricular getDiscGradeCurricular() {
		return discGradeCurricular;
	}
}
