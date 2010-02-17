package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.jboss.seam.annotations.Name;

import br.inf.prismasoft.academix.entity.types.TipoDuracaoType;

@Name("academixUtil")
public class AcademixUtil {

	public List<SelectItem> getTipoDuracaoSelectItens() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		for(TipoDuracaoType tipoDuracao : TipoDuracaoType.values()) {
			list.add(new SelectItem(tipoDuracao, tipoDuracao.getLabel()));
		}
		return list;
	}
	
}
