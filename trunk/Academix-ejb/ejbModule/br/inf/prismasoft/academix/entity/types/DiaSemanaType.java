package br.inf.prismasoft.academix.entity.types;

public enum DiaSemanaType {
	DOMINGO(1, "Domingo"),
	SEGUNDA(2, "Segunda-feira"),
	TERCA(3, "Terça-feira"),
	QUARTA(4, "Quarta-feira"),
	QUINTA(5, "Quinta-feira"),
	SEXTA(6, "Sexta-feira"),
	SABADO(7, "Sábado");
	
	private Integer id;
	
	private String label;

	private DiaSemanaType(Integer id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getLabel() {
		return this.label;
	}

}
