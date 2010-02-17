package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("historicoItemHome")
public class HistoricoItemHome extends EntityHome<HistoricoItem> {

	@In(create = true)
	HistoricoHome historicoHome;
	@In(create = true)
	DisciplinaHome disciplinaHome;

	public void setHistoricoItemId(HistoricoItemId id) {
		setId(id);
	}

	public HistoricoItemId getHistoricoItemId() {
		return (HistoricoItemId) getId();
	}

	public HistoricoItemHome() {
		setHistoricoItemId(new HistoricoItemId());
	}

	@Override
	public boolean isIdDefined() {
		if (getHistoricoItemId().getIndDisciplina() == 0)
			return false;
		if (getHistoricoItemId().getIndGradeCurricular() == 0)
			return false;
		if (getHistoricoItemId().getIndHistorico() == 0)
			return false;
		return true;
	}

	@Override
	protected HistoricoItem createInstance() {
		HistoricoItem historicoItem = new HistoricoItem();
		historicoItem.setId(new HistoricoItemId());
		return historicoItem;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Historico historico = historicoHome.getDefinedInstance();
		if (historico != null) {
			getInstance().setHistorico(historico);
		}
		Disciplina disciplina = disciplinaHome.getDefinedInstance();
		if (disciplina != null) {
			getInstance().setDisciplina(disciplina);
		}
	}

	public boolean isWired() {
		if (getInstance().getHistorico() == null)
			return false;
		if (getInstance().getDisciplina() == null)
			return false;
		return true;
	}

	public HistoricoItem getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
