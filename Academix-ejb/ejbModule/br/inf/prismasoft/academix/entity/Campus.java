package br.inf.prismasoft.academix.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Campus generated by hbm2java
 */
@Entity
@Table(name = "CAMPUS", schema = "ACADEMIX")
public class Campus implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5612301637857049933L;
	private Integer idtCampus;
	private Endereco endereco;
	private String desCampus;
	private Integer numEndereco;
	private Set<Curso> cursos = new HashSet<Curso>(0);

	public Campus() {
	}

	public Campus(Endereco endereco, String desCampus) {
		this.endereco = endereco;
		this.desCampus = desCampus;
	}

	public Campus(Endereco endereco, String desCampus, Integer numEndereco,
			Set<Curso> cursos) {
		this.endereco = endereco;
		this.desCampus = desCampus;
		this.numEndereco = numEndereco;
		this.cursos = cursos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idt_campus", unique = true, nullable = false)
	public Integer getIdtCampus() {
		return this.idtCampus;
	}

	public void setIdtCampus(Integer idtCampus) {
		this.idtCampus = idtCampus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ind_endereco", nullable = false)
	@NotNull
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Column(name = "des_campus", nullable = false, length = 40)
	@NotNull
	@Length(max = 40)
	public String getDesCampus() {
		return this.desCampus;
	}

	public void setDesCampus(String desCampus) {
		this.desCampus = desCampus;
	}

	@Column(name = "num_endereco")
	public Integer getNumEndereco() {
		return this.numEndereco;
	}

	public void setNumEndereco(Integer numEndereco) {
		this.numEndereco = numEndereco;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "campus")
	public Set<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

}
