package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("cursoHome")
public class CursoHome extends EntityHome<Curso> {

	@In(create = true)
	CampusHome campusHome;

	public void setCursoIdtCurso(Integer id) {
		setId(id);
	}

	public Integer getCursoIdtCurso() {
		return (Integer) getId();
	}

	@Override
	protected Curso createInstance() {
		Curso curso = new Curso();
		return curso;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Campus campus = campusHome.getDefinedInstance();
		if (campus != null) {
			getInstance().setCampus(campus);
		}
	}

	public boolean isWired() {
		if (getInstance().getCampus() == null)
			return false;
		return true;
	}

	public Curso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GradeCurricular> getGradeCurriculars() {
		return getInstance() == null ? null : new ArrayList<GradeCurricular>(
				getInstance().getGradeCurriculars());
	}

	public List<Historico> getHistoricos() {
		return getInstance() == null ? null : new ArrayList<Historico>(
				getInstance().getHistoricos());
	}

}
