package br.inf.prismasoft.academix.entity.types;

public enum TipoDuracaoType {
	ANUAL(0, "Anual"),
	SEMESTRAL(1, "Semestral");

	private Integer id;
	
	private String label;
	
	private TipoDuracaoType(Integer id, String label) {
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
