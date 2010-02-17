package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("gradeHorariaItemList")
public class GradeHorariaItemList extends EntityQuery<GradeHorariaItem> {

	private static final String EJBQL = "select gradeHorariaItem from GradeHorariaItem gradeHorariaItem";

	private static final String[] RESTRICTIONS = {};

	private GradeHorariaItem gradeHorariaItem = new GradeHorariaItem();

	public GradeHorariaItemList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GradeHorariaItem getGradeHorariaItem() {
		return gradeHorariaItem;
	}
}
