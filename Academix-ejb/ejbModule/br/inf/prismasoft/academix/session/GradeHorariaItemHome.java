package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("gradeHorariaItemHome")
public class GradeHorariaItemHome extends EntityHome<GradeHorariaItem> {

	@In(create = true)
	LocalizacaoHome localizacaoHome;
	@In(create = true)
	GradeHorariaHome gradeHorariaHome;
	@In(create = true)
	DisciplinaHome disciplinaHome;
	@In(create = true)
	ProfessorHome professorHome;

	public void setGradeHorariaItemIdtGradeHorariaItem(Integer id) {
		setId(id);
	}

	public Integer getGradeHorariaItemIdtGradeHorariaItem() {
		return (Integer) getId();
	}

	@Override
	protected GradeHorariaItem createInstance() {
		GradeHorariaItem gradeHorariaItem = new GradeHorariaItem();
		return gradeHorariaItem;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Localizacao localizacao = localizacaoHome.getDefinedInstance();
		if (localizacao != null) {
			getInstance().setLocalizacao(localizacao);
		}
		GradeHoraria gradeHoraria = gradeHorariaHome.getDefinedInstance();
		if (gradeHoraria != null) {
			getInstance().setGradeHoraria(gradeHoraria);
		}
		Disciplina disciplina = disciplinaHome.getDefinedInstance();
		if (disciplina != null) {
			getInstance().setDisciplina(disciplina);
		}
		Professor professor = professorHome.getDefinedInstance();
		if (professor != null) {
			getInstance().setProfessor(professor);
		}
	}

	public boolean isWired() {
		if (getInstance().getDisciplina() == null)
			return false;
		return true;
	}

	public GradeHorariaItem getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
