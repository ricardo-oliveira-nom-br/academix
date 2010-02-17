package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("professorList")
public class ProfessorList extends EntityQuery<Professor> {

	private static final String EJBQL = "select professor from Professor professor";

	private static final String[] RESTRICTIONS = {
			"lower(professor.desComplemento) like lower(concat(#{professorList.professor.desComplemento},'%'))",
			"lower(professor.nomProfessor) like lower(concat(#{professorList.professor.nomProfessor},'%'))",
			"lower(professor.numRm) like lower(concat(#{professorList.professor.numRm},'%'))", };

	private Professor professor = new Professor();

	public ProfessorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Professor getProfessor() {
		return professor;
	}
}
