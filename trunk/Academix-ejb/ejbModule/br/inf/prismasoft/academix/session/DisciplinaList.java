package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("disciplinaList")
public class DisciplinaList extends EntityQuery<Disciplina> {

	private static final String EJBQL = "select disciplina from Disciplina disciplina";

	private static final String[] RESTRICTIONS = {
			"lower(disciplina.codDisciplina) like lower(concat(#{disciplinaList.disciplina.codDisciplina},'%'))",
			"lower(disciplina.desDisciplina) like lower(concat(#{disciplinaList.disciplina.desDisciplina},'%'))",
			"lower(disciplina.nomDisciplina) like lower(concat(#{disciplinaList.disciplina.nomDisciplina},'%'))", };

	private Disciplina disciplina = new Disciplina();

	public DisciplinaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}
}
