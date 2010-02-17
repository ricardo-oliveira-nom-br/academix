package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("campusHome")
public class CampusHome extends EntityHome<Campus> {

	@In(create = true)
	EnderecoHome enderecoHome;

	public void setCampusIdtCampus(Integer id) {
		setId(id);
	}

	public Integer getCampusIdtCampus() {
		return (Integer) getId();
	}

	@Override
	protected Campus createInstance() {
		Campus campus = new Campus();
		return campus;
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
	}

	public boolean isWired() {
		if (getInstance().getEndereco() == null)
			return false;
		return true;
	}

	public Campus getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Curso> getCursos() {
		return getInstance() == null ? null : new ArrayList<Curso>(
				getInstance().getCursos());
	}

}
