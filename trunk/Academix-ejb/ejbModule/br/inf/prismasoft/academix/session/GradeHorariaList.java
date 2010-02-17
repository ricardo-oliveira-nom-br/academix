package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("gradeHorariaList")
public class GradeHorariaList extends EntityQuery<GradeHoraria> {

	private static final String EJBQL = "select gradeHoraria from GradeHoraria gradeHoraria";

	private static final String[] RESTRICTIONS = {};

	private GradeHoraria gradeHoraria = new GradeHoraria();

	public GradeHorariaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GradeHoraria getGradeHoraria() {
		return gradeHoraria;
	}
}
