package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;

import br.inf.prismasoft.academix.entity.types.TipoDuracaoType;

@Name("academixUtil")
public class AcademixUtil {

	public List<TipoDuracaoType> getTipoDuracaoSelectItens() {
		List<TipoDuracaoType> list = new ArrayList<TipoDuracaoType>();
		for(TipoDuracaoType tipoDuracao : TipoDuracaoType.values()) {
			list.add(tipoDuracao);
		}
		return list;
	}
	
}
