package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("historicoHome")
public class HistoricoHome extends EntityHome<Historico> {

	@In(create = true)
	CursoHome cursoHome;
	@In(create = true)
	AlunoHome alunoHome;

	public void setHistoricoIdtHistorico(Integer id) {
		setId(id);
	}

	public Integer getHistoricoIdtHistorico() {
		return (Integer) getId();
	}

	@Override
	protected Historico createInstance() {
		Historico historico = new Historico();
		return historico;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Curso curso = cursoHome.getDefinedInstance();
		if (curso != null) {
			getInstance().setCurso(curso);
		}
		Aluno aluno = alunoHome.getDefinedInstance();
		if (aluno != null) {
			getInstance().setAluno(aluno);
		}
	}

	public boolean isWired() {
		if (getInstance().getCurso() == null)
			return false;
		if (getInstance().getAluno() == null)
			return false;
		return true;
	}

	public Historico getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<HistoricoItem> getHistoricoItems() {
		return getInstance() == null ? null : new ArrayList<HistoricoItem>(
				getInstance().getHistoricoItems());
	}

}
