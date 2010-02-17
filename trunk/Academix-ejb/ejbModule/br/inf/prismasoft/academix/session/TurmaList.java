package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("turmaList")
public class TurmaList extends EntityQuery<Turma> {

	private static final String EJBQL = "select turma from Turma turma";

	private static final String[] RESTRICTIONS = { "lower(turma.codTurma) like lower(concat(#{turmaList.turma.codTurma},'%'))", };

	private Turma turma = new Turma();

	public TurmaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Turma getTurma() {
		return turma;
	}
}
