package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("professorHome")
public class ProfessorHome extends EntityHome<Professor> {

	@In(create = true)
	EnderecoHome enderecoHome;

	public void setProfessorIdtProfessor(Integer id) {
		setId(id);
	}

	public Integer getProfessorIdtProfessor() {
		return (Integer) getId();
	}

	@Override
	protected Professor createInstance() {
		Professor professor = new Professor();
		return professor;
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

	public Professor getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GradeHorariaItem> getGradeHorariaItems() {
		return getInstance() == null ? null : new ArrayList<GradeHorariaItem>(
				getInstance().getGradeHorariaItems());
	}

}
