package br.inf.prismasoft.academix.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OrderBy;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * GradeHoraria generated by hbm2java
 */
@Entity
@Table(name = "GRADE_HORARIA", schema = "ACADEMIX")
public class GradeHoraria implements java.io.Serializable {

	private static final long serialVersionUID = 2438908525624884600L;
	private Integer idtGradeHoraria;
	private Turma turma;
	private Set<GradeHorariaItem> gradeHorariaItems = new HashSet<GradeHorariaItem>(
			0);

	public GradeHoraria() {
	}

	public GradeHoraria(Turma turma) {
		this.turma = turma;
	}

	public GradeHoraria(Turma turma, Set<GradeHorariaItem> gradeHorariaItems) {
		this.turma = turma;
		this.gradeHorariaItems = gradeHorariaItems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idt_grade_horaria", unique = true, nullable = false)
	public Integer getIdtGradeHoraria() {
		return this.idtGradeHoraria;
	}

	public void setIdtGradeHoraria(Integer idtGradeHoraria) {
		this.idtGradeHoraria = idtGradeHoraria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ind_turma", nullable = false)
	@NotNull
	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "gradeHoraria")
	@OrderBy(value = "indDiaSemana")
	public Set<GradeHorariaItem> getGradeHorariaItems() {
		return this.gradeHorariaItems;
	}

	public void setGradeHorariaItems(Set<GradeHorariaItem> gradeHorariaItems) {
		this.gradeHorariaItems = gradeHorariaItems;
	}

}