package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("faltaItemHome")
public class FaltaItemHome extends EntityHome<FaltaItem> {

	@In(create = true)
	AlunoHome alunoHome;
	@In(create = true)
	FaltaHome faltaHome;

	public void setFaltaItemIdtFaltaItem(Integer id) {
		setId(id);
	}

	public Integer getFaltaItemIdtFaltaItem() {
		return (Integer) getId();
	}

	@Override
	protected FaltaItem createInstance() {
		FaltaItem faltaItem = new FaltaItem();
		return faltaItem;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Aluno aluno = alunoHome.getDefinedInstance();
		if (aluno != null) {
			getInstance().setAluno(aluno);
		}
		Falta falta = faltaHome.getDefinedInstance();
		if (falta != null) {
			getInstance().setFalta(falta);
		}
	}

	public boolean isWired() {
		if (getInstance().getAluno() == null)
			return false;
		if (getInstance().getFalta() == null)
			return false;
		return true;
	}

	public FaltaItem getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
