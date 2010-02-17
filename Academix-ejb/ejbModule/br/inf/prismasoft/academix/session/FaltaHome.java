package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("faltaHome")
public class FaltaHome extends EntityHome<Falta> {

	@In(create = true)
	DisciplinaHome disciplinaHome;
	@In(create = true)
	TurmaHome turmaHome;

	public void setFaltaIdtFalta(Integer id) {
		setId(id);
	}

	public Integer getFaltaIdtFalta() {
		return (Integer) getId();
	}

	@Override
	protected Falta createInstance() {
		Falta falta = new Falta();
		return falta;
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

	public Falta getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<FaltaItem> getFaltaItems() {
		return getInstance() == null ? null : new ArrayList<FaltaItem>(
				getInstance().getFaltaItems());
	}

}
