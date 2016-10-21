package br.nom.martinelli.ricardo.academix.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Professor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7037693550595289112L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(name = "nome", length = 40)
	private String nome;
	
	@Column(name = "rg", length = 9)
	private String rg;
	
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	@OneToOne
	private Endereco enderecoResidencial;
	
	@Column(name = "numeroResidencial", length = 8)
	private Integer enderecoResidencialNumero;
	
	@Column(name = "complementoResidencial", length = 30)
	private String enderecoResidencialComplemento;
	
	@Column(name = "empresa", length = 40)
	private String empresa;
	
	@OneToOne
	private Endereco enderecoComercial;
	
	@Column(name = "numeroComercial", length = 8)
	private Integer enderecoComercialNumero;
	
	@Column(name = "complementoComercial", length = 30)
	private String enderecoComercialComplemento;
	
	@Column(name = "profissao", length = 40)
	private String profissao;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEnderecoResidencial() {
		return enderecoResidencial;
	}

	public void setEnderecoResidencial(Endereco enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}

	public Integer getEnderecoResidencialNumero() {
		return enderecoResidencialNumero;
	}

	public void setEnderecoResidencialNumero(Integer enderecoResidencialNumero) {
		this.enderecoResidencialNumero = enderecoResidencialNumero;
	}

	public String getEnderecoResidencialComplemento() {
		return enderecoResidencialComplemento;
	}

	public void setEnderecoResidencialComplemento(String enderecoResidencialComplemento) {
		this.enderecoResidencialComplemento = enderecoResidencialComplemento;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}

	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}

	public Integer getEnderecoComercialNumero() {
		return enderecoComercialNumero;
	}

	public void setEnderecoComercialNumero(Integer enderecoComercialNumero) {
		this.enderecoComercialNumero = enderecoComercialNumero;
	}

	public String getEnderecoComercialComplemento() {
		return enderecoComercialComplemento;
	}

	public void setEnderecoComercialComplemento(String enderecoComercialComplemento) {
		this.enderecoComercialComplemento = enderecoComercialComplemento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Professor)) {
			return false;
		}
		Professor other = (Professor) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}