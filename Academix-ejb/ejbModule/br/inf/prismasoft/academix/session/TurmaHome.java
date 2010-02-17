package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("turmaHome")
public class TurmaHome extends EntityHome<Turma> {

	@In(create = true)
	GradeCurricularHome gradeCurricularHome;

	public void setTurmaIdtTurma(Integer id) {
		setId(id);
	}

	public Integer getTurmaIdtTurma() {
		return (Integer) getId();
	}

	@Override
	protected Turma createInstance() {
		Turma turma = new Turma();
		return turma;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GradeCurricular gradeCurricular = gradeCurricularHome
				.getDefinedInstance();
		if (gradeCurricular != null) {
			getInstance().setGradeCurricular(gradeCurricular);
		}
	}

	public boolean isWired() {
		if (getInstance().getGradeCurricular() == null)
			return false;
		return true;
	}

	public Turma getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GradeHoraria> getGradeHorarias() {
		return getInstance() == null ? null : new ArrayList<GradeHoraria>(
				getInstance().getGradeHorarias());
	}

	public List<Avaliacao> getAvaliacaos() {
		return getInstance() == null ? null : new ArrayList<Avaliacao>(
				getInstance().getAvaliacaos());
	}

	public List<Falta> getFaltas() {
		return getInstance() == null ? null : new ArrayList<Falta>(
				getInstance().getFaltas());
	}

}
