package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("avaliacaoItemHome")
public class AvaliacaoItemHome extends EntityHome<AvaliacaoItem> {

	private static final long serialVersionUID = 6932313646236097936L;
	@In(create = true)
	AvaliacaoHome avaliacaoHome;
	@In(create = true)
	AlunoHome alunoHome;

	public void setAvaliacaoItemIdtAvaliacaoItem(Integer id) {
		setId(id);
	}

	public Integer getAvaliacaoItemIdtAvaliacaoItem() {
		return (Integer) getId();
	}

	@Override
	protected AvaliacaoItem createInstance() {
		AvaliacaoItem avaliacaoItem = new AvaliacaoItem();
		return avaliacaoItem;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Avaliacao avaliacao = avaliacaoHome.getDefinedInstance();
		if (avaliacao != null) {
			getInstance().setAvaliacao(avaliacao);
		}
		Aluno aluno = alunoHome.getDefinedInstance();
		if (aluno != null) {
			getInstance().setAluno(aluno);
		}
	}

	public boolean isWired() {
		if (getInstance().getAvaliacao() == null)
			return false;
		if (getInstance().getAluno() == null)
			return false;
		return true;
	}

	public AvaliacaoItem getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
