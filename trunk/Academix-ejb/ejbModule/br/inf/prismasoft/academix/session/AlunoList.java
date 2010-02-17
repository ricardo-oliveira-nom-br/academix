package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.*;

import java.util.Arrays;

@Name("alunoList")
public class AlunoList extends EntityQuery<Aluno> {

	private static final String EJBQL = "select aluno from Aluno aluno";

	private static final String[] RESTRICTIONS = {
			"lower(aluno.nomAluno) like lower(concat(#{alunoList.aluno.nomAluno},'%'))",
			"lower(aluno.numCpf) like lower(concat(#{alunoList.aluno.numCpf},'%'))",
			"lower(aluno.numRa) like lower(concat(#{alunoList.aluno.numRa},'%'))",
			"lower(aluno.numRg) like lower(concat(#{alunoList.aluno.numRg},'%'))", };

	private Aluno aluno = new Aluno();

	public AlunoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Aluno getAluno() {
		return aluno;
	}
}
