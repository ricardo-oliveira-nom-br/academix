package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("disciplinaHome")
public class DisciplinaHome extends EntityHome<Disciplina> {

	public void setDisciplinaIdtDisciplina(Integer id) {
		setId(id);
	}

	public Integer getDisciplinaIdtDisciplina() {
		return (Integer) getId();
	}

	@Override
	protected Disciplina createInstance() {
		Disciplina disciplina = new Disciplina();
		return disciplina;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Disciplina getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Falta> getFaltas() {
		return getInstance() == null ? null : new ArrayList<Falta>(
				getInstance().getFaltas());
	}

	public List<Avaliacao> getAvaliacaos() {
		return getInstance() == null ? null : new ArrayList<Avaliacao>(
				getInstance().getAvaliacaos());
	}

	public List<HistoricoItem> getHistoricoItems() {
		return getInstance() == null ? null : new ArrayList<HistoricoItem>(
				getInstance().getHistoricoItems());
	}

	public List<GradeHorariaItem> getGradeHorariaItems() {
		return getInstance() == null ? null : new ArrayList<GradeHorariaItem>(
				getInstance().getGradeHorariaItems());
	}

	public List<DiscGradeCurricular> getDiscGradeCurriculars() {
		return getInstance() == null ? null
				: new ArrayList<DiscGradeCurricular>(getInstance()
						.getDiscGradeCurriculars());
	}

}
