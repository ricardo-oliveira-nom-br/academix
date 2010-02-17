package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("discGradeCurricularHome")
public class DiscGradeCurricularHome extends EntityHome<DiscGradeCurricular> {

	@In(create = true)
	GradeCurricularHome gradeCurricularHome;
	@In(create = true)
	DisciplinaHome disciplinaHome;

	public void setDiscGradeCurricularIdtDiscGradeCurricular(Integer id) {
		setId(id);
	}

	public Integer getDiscGradeCurricularIdtDiscGradeCurricular() {
		return (Integer) getId();
	}

	@Override
	protected DiscGradeCurricular createInstance() {
		DiscGradeCurricular discGradeCurricular = new DiscGradeCurricular();
		return discGradeCurricular;
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
		Disciplina disciplina = disciplinaHome.getDefinedInstance();
		if (disciplina != null) {
			getInstance().setDisciplina(disciplina);
		}
	}

	public boolean isWired() {
		if (getInstance().getGradeCurricular() == null)
			return false;
		if (getInstance().getDisciplina() == null)
			return false;
		return true;
	}

	public DiscGradeCurricular getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
