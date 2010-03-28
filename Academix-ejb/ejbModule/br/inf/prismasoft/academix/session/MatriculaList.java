package br.inf.prismasoft.academix.session;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.Aluno;

@Name("matriculaList")
public class MatriculaList extends EntityQuery<Aluno> {

	private static final long serialVersionUID = 1674503812634213057L;
	
	private static final String EJBQL = "select aluno from Aluno aluno";
	
	private static final String[] RESTRICTIONS = { "lower(aluno.numRa) like concat(lower(#{alunoList.aluno.numRa}),'%')", "lower(aluno.nomAluno) like concat(lower(#{alunoList.aluno.nomAluno}),'%')", "lower(aluno.numRg) like concat(lower(#{alunoList.aluno.numRg}),'%')", "lower(aluno.numCpf) like concat(lower(#{alunoList.aluno.numCpf}),'%')", };

	private Aluno aluno = new Aluno();
	
	public MatriculaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Aluno getAluno() {
		return aluno;
	}
	
}
