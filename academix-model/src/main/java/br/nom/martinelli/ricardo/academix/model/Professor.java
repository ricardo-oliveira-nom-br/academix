package br.nom.martinelli.ricardo.academix.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
	@Embedded
	private Endereco enderecoResidencial;
	@Column(name = "numeroResidencial", length = 8)
	private Integer enderecoResidencialNumero;
	@Column(name = "complementoResidencial", length = 30)
	private String enderecoResidencialComplemento;
	@Embedded
	private Endereco enderecoComercial;
	@Column(name = "numeroComercial", length = 8)
	private Integer enderecoComercialNumero;
	@Column(name = "complementoComercial", length = 30)
	private String enderecoComercialComplemento;

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