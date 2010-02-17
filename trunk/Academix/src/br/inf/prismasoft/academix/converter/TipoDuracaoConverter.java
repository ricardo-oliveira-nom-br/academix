package br.inf.prismasoft.academix.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.inf.prismasoft.academix.entity.types.TipoDuracaoType;

public class TipoDuracaoConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoDuracaoType tipoDuracao = TipoDuracaoType.valueOf(value);

		return tipoDuracao;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value.toString();
	}

}
