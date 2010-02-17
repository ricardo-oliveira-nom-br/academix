package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("gradeCurricularHome")
public class GradeCurricularHome extends EntityHome<GradeCurricular> {

	@In(create = true)
	CursoHome cursoHome;

	public void setGradeCurricularIdtGradeCurricular(Integer id) {
		setId(id);
	}

	public Integer getGradeCurricularIdtGradeCurricular() {
		return (Integer) getId();
	}

	@Override
	protected GradeCurricular createInstance() {
		GradeCurricular gradeCurricular = new GradeCurricular();
		return gradeCurricular;
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
	}

	public boolean isWired() {
		if (getInstance().getCurso() == null)
			return false;
		return true;
	}

	public GradeCurricular getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<DiscGradeCurricular> getDiscGradeCurriculars() {
		return getInstance() == null ? null
				: new ArrayList<DiscGradeCurricular>(getInstance()
						.getDiscGradeCurriculars());
	}

	public List<Turma> getTurmas() {
		return getInstance() == null ? null : new ArrayList<Turma>(
				getInstance().getTurmas());
	}

}
