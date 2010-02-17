package br.inf.prismasoft.academix.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.NotNull;

import br.inf.prismasoft.academix.entity.types.DiaSemanaType;

/**
 * GradeHorariaItem generated by hbm2java
 */
@Entity
@Table(name = "GRADE_HORARIA_ITEM", schema = "ACADEMIX")
public class GradeHorariaItem implements java.io.Serializable {

	private static final long serialVersionUID = -1513112584904623490L;
	private Integer idtGradeHorariaItem;
	private Localizacao localizacao;
	private GradeHoraria gradeHoraria;
	private Disciplina disciplina;
	private Professor professor;
	private DiaSemanaType indDiaSemana;
	private Date numHoraInicio;
	private Date numHoraFim;

	public GradeHorariaItem() {
	}

	public GradeHorariaItem(Disciplina disciplina, DiaSemanaType indDiaSemana) {
		this.disciplina = disciplina;
		this.indDiaSemana = indDiaSemana;
	}

	public GradeHorariaItem(Localizacao localizacao, GradeHoraria gradeHoraria,
			Disciplina disciplina, Professor professor, DiaSemanaType indDiaSemana,
			Date numHoraInicio, Date numHoraFim) {
		this.localizacao = localizacao;
		this.gradeHoraria = gradeHoraria;
		this.disciplina = disciplina;
		this.professor = professor;
		this.indDiaSemana = indDiaSemana;
		this.numHoraInicio = numHoraInicio;
		this.numHoraFim = numHoraFim;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idt_grade_horaria_item", unique = true, nullable = false)
	public Integer getIdtGradeHorariaItem() {
		return this.idtGradeHorariaItem;
	}

	public void setIdtGradeHorariaItem(Integer idtGradeHorariaItem) {
		this.idtGradeHorariaItem = idtGradeHorariaItem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ind_localizacao")
	public Localizacao getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ind_grade_horaria")
	public GradeHoraria getGradeHoraria() {
		return this.gradeHoraria;
	}

	public void setGradeHoraria(GradeHoraria gradeHoraria) {
		this.gradeHoraria = gradeHoraria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ind_disciplina", nullable = false)
	@NotNull
	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ind_professor")
	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Column(name = "ind_dia_semana", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	public DiaSemanaType getIndDiaSemana() {
		return this.indDiaSemana;
	}

	public void setIndDiaSemana(DiaSemanaType indDiaSemana) {
		this.indDiaSemana = indDiaSemana;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "num_hora_inicio", length = 8)
	public Date getNumHoraInicio() {
		return this.numHoraInicio;
	}

	public void setNumHoraInicio(Date numHoraInicio) {
		this.numHoraInicio = numHoraInicio;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "num_hora_fim", length = 8)
	public Date getNumHoraFim() {
		return this.numHoraFim;
	}

	public void setNumHoraFim(Date numHoraFim) {
		this.numHoraFim = numHoraFim;
	}

}
