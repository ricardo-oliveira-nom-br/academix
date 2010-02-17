package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("cursoList")
public class CursoList extends EntityQuery<Curso> {

	private static final String EJBQL = "select curso from Curso curso";

	private static final String[] RESTRICTIONS = {
			"lower(curso.desCurso) like lower(concat(#{cursoList.curso.desCurso},'%'))",
			"lower(curso.nomCurso) like lower(concat(#{cursoList.curso.nomCurso},'%'))", };

	private Curso curso = new Curso();

	public CursoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Curso getCurso() {
		return curso;
	}
}
