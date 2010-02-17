package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("avaliacaoHome")
public class AvaliacaoHome extends EntityHome<Avaliacao> {

	@In(create = true)
	DisciplinaHome disciplinaHome;
	@In(create = true)
	TurmaHome turmaHome;

	public void setAvaliacaoIdtAvaliacao(Integer id) {
		setId(id);
	}

	public Integer getAvaliacaoIdtAvaliacao() {
		return (Integer) getId();
	}

	@Override
	protected Avaliacao createInstance() {
		Avaliacao avaliacao = new Avaliacao();
		return avaliacao;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Disciplina disciplina = disciplinaHome.getDefinedInstance();
		if (disciplina != null) {
			getInstance().setDisciplina(disciplina);
		}
		Turma turma = turmaHome.getDefinedInstance();
		if (turma != null) {
			getInstance().setTurma(turma);
		}
	}

	public boolean isWired() {
		if (getInstance().getDisciplina() == null)
			return false;
		if (getInstance().getTurma() == null)
			return false;
		return true;
	}

	public Avaliacao getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<AvaliacaoItem> getAvaliacaoItems() {
		return getInstance() == null ? null : new ArrayList<AvaliacaoItem>(
				getInstance().getAvaliacaoItems());
	}

}
