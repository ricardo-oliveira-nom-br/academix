package br.inf.prismasoft.academix.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("alunoEnderecoHome")
public class AlunoEnderecoHome extends EntityHome<AlunoEndereco> {

	private static final long serialVersionUID = -8416801633010366822L;
	@In(create = true)
	EnderecoHome enderecoHome;
	@In(create = true)
	AlunoHome alunoHome;

	public void setAlunoEnderecoId(AlunoEnderecoId id) {
		setId(id);
	}

	public AlunoEnderecoId getAlunoEnderecoId() {
		return (AlunoEnderecoId) getId();
	}

	public AlunoEnderecoHome() {
		setAlunoEnderecoId(new AlunoEnderecoId());
	}

	@Override
	public boolean isIdDefined() {
		if (getAlunoEnderecoId().getIndAluno() == 0)
			return false;
		if (getAlunoEnderecoId().getIndEndereco() == null
				|| "".equals(getAlunoEnderecoId().getIndEndereco()))
			return false;
		return true;
	}

	@Override
	protected AlunoEndereco createInstance() {
		AlunoEndereco alunoEndereco = new AlunoEndereco();
		alunoEndereco.setId(new AlunoEnderecoId());
		return alunoEndereco;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Endereco endereco = enderecoHome.getDefinedInstance();
		if (endereco != null) {
			getInstance().setEndereco(endereco);
		}
		Aluno aluno = alunoHome.getDefinedInstance();
		if (aluno != null) {
			getInstance().setAluno(aluno);
		}
	}

	public boolean isWired() {
		if (getInstance().getEndereco() == null)
			return false;
		if (getInstance().getAluno() == null)
			return false;
		return true;
	}

	public AlunoEndereco getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
