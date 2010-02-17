package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("gradeCurricularList")
public class GradeCurricularList extends EntityQuery<GradeCurricular> {

	private static final String EJBQL = "select gradeCurricular from GradeCurricular gradeCurricular";

	private static final String[] RESTRICTIONS = {};

	private GradeCurricular gradeCurricular = new GradeCurricular();

	public GradeCurricularList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GradeCurricular getGradeCurricular() {
		return gradeCurricular;
	}
}
