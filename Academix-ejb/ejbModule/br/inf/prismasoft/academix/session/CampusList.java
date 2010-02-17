package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("campusList")
public class CampusList extends EntityQuery<Campus> {

	private static final String EJBQL = "select campus from Campus campus";

	private static final String[] RESTRICTIONS = { "lower(campus.desCampus) like lower(concat(#{campusList.campus.desCampus},'%'))", };

	private Campus campus = new Campus();

	public CampusList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Campus getCampus() {
		return campus;
	}
}
