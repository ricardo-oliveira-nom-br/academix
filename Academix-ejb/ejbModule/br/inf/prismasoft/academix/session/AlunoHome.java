package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("alunoHome")
public class AlunoHome extends EntityHome<Aluno> {

	public void setAlunoIdtAluno(Integer id) {
		setId(id);
	}

	public Integer getAlunoIdtAluno() {
		return (Integer) getId();
	}

	@Override
	protected Aluno createInstance() {
		Aluno aluno = new Aluno();
		return aluno;
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

	public Aluno getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<AvaliacaoItem> getAvaliacaoItems() {
		return getInstance() == null ? null : new ArrayList<AvaliacaoItem>(
				getInstance().getAvaliacaoItems());
	}

	public List<Solicitacao> getSolicitacaos() {
		return getInstance() == null ? null : new ArrayList<Solicitacao>(
				getInstance().getSolicitacaos());
	}

	public List<AlunoEndereco> getAlunoEnderecos() {
		return getInstance() == null ? null : new ArrayList<AlunoEndereco>(
				getInstance().getAlunoEnderecos());
	}

	public List<FaltaItem> getFaltaItems() {
		return getInstance() == null ? null : new ArrayList<FaltaItem>(
				getInstance().getFaltaItems());
	}

	public List<Historico> getHistoricos() {
		return getInstance() == null ? null : new ArrayList<Historico>(
				getInstance().getHistoricos());
	}

}
