package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("solicitacaoHome")
public class SolicitacaoHome extends EntityHome<Solicitacao> {

	@In(create = true)
	AlunoHome alunoHome;

	public void setSolicitacaoIdtSolicitacao(Integer id) {
		setId(id);
	}

	public Integer getSolicitacaoIdtSolicitacao() {
		return (Integer) getId();
	}

	@Override
	protected Solicitacao createInstance() {
		Solicitacao solicitacao = new Solicitacao();
		return solicitacao;
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
	}

	public boolean isWired() {
		return true;
	}

	public Solicitacao getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
