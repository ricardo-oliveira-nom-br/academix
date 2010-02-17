package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("faltaList")
public class FaltaList extends EntityQuery<Falta> {

	private static final String EJBQL = "select falta from Falta falta";

	private static final String[] RESTRICTIONS = {};

	private Falta falta = new Falta();

	public FaltaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Falta getFalta() {
		return falta;
	}
}
