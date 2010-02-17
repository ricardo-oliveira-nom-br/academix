package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.*;

@Name("localizacaoHome")
public class LocalizacaoHome extends EntityHome<Localizacao> {

	public void setLocalizacaoIdtLocalizacao(Integer id) {
		setId(id);
	}

	public Integer getLocalizacaoIdtLocalizacao() {
		return (Integer) getId();
	}

	@Override
	protected Localizacao createInstance() {
		Localizacao localizacao = new Localizacao();
		return localizacao;
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

	public Localizacao getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GradeHorariaItem> getGradeHorariaItems() {
		return getInstance() == null ? null : new ArrayList<GradeHorariaItem>(
				getInstance().getGradeHorariaItems());
	}

}
