package br.nom.martinelli.ricardo.academix.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.nom.martinelli.ricardo.academix.types.UF;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8394643303041865105L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String logradouro;

	@Column(length = 8, nullable = false)
	@NotNull
	@Size(min = 8, max = 8)
	private String cep;

	@Column(length = 40)
	@Size(max = 40)
	private String bairro;

	@Column(length = 40)
	@Size(max = 40)
	private String cidade;

	@Enumerated(EnumType.STRING)
	private UF uf;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (logradouro != null && !logradouro.trim().isEmpty())
			result += ", logradouro: " + logradouro;
		if (cep != null && !cep.trim().isEmpty())
			result += ", cep: " + cep;
		if (bairro != null && !bairro.trim().isEmpty())
			result += ", bairro: " + bairro;
		if (cidade != null && !cidade.trim().isEmpty())
			result += ", estado: " + cidade;
		if (uf != null)
			result += ", uf: " + uf;
		return result;
	}
}