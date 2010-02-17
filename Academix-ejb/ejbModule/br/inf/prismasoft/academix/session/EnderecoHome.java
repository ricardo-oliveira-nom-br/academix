package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("enderecoHome")
public class EnderecoHome extends EntityHome<Endereco> {

	public void setEnderecoIdtCep(String id) {
		setId(id);
	}

	public String getEnderecoIdtCep() {
		return (String) getId();
	}

	@Override
	protected Endereco createInstance() {
		Endereco endereco = new Endereco();
		return endereco;
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

	public Endereco getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Campus> getCampuses() {
		return getInstance() == null ? null : new ArrayList<Campus>(
				getInstance().getCampuses());
	}

	public List<AlunoEndereco> getAlunoEnderecos() {
		return getInstance() == null ? null : new ArrayList<AlunoEndereco>(
				getInstance().getAlunoEnderecos());
	}

	public List<Professor> getProfessors() {
		return getInstance() == null ? null : new ArrayList<Professor>(
				getInstance().getProfessors());
	}

}
