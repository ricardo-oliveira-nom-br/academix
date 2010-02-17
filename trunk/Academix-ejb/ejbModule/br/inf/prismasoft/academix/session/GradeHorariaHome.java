package br.inf.prismasoft.academix.session;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelectionIndex;
import org.jboss.seam.framework.EntityHome;
import org.richfaces.event.DropEvent;

import br.inf.prismasoft.academix.entity.Campus;
import br.inf.prismasoft.academix.entity.Curso;
import br.inf.prismasoft.academix.entity.Disciplina;
import br.inf.prismasoft.academix.entity.GradeHoraria;
import br.inf.prismasoft.academix.entity.GradeHorariaItem;
import br.inf.prismasoft.academix.entity.Localizacao;
import br.inf.prismasoft.academix.entity.Professor;
import br.inf.prismasoft.academix.entity.Turma;
import br.inf.prismasoft.academix.entity.types.DiaSemanaType;
import br.inf.prismasoft.academix.helper.GradeHorariaHelper;
import br.inf.prismasoft.academix.helper.GradeHorariaItemHelper;

@Name("gradeHorariaHome")
public class GradeHorariaHome extends EntityHome<GradeHoraria> {

	private static final long serialVersionUID = 2426453449330371253L;
	@In(create = true) TurmaHome turmaHome;
	@DataModel private List<GradeHorariaItemHelper> gradeList;
	@DataModelSelectionIndex private Integer rowIndex;
	GradeHorariaHelper gradeHorariaHelper;
	
	Campus campus;
	List<Curso> listCurso = new ArrayList<Curso>();
	Curso curso;
	List<Turma> listTurma = new ArrayList<Turma>();
	Turma turma;
	List<Disciplina> listDisciplina = new ArrayList<Disciplina>();
	
	public void setGradeHorariaIdtGradeHoraria(Integer id) {
		setId(id);
	}

	public Integer getGradeHorariaIdtGradeHoraria() {
		return (Integer) getId();
	}

	public List<Disciplina> getListDisciplina() {
		return listDisciplina;
	}

	public void setListDisciplina(List<Disciplina> listDisciplina) {
		this.listDisciplina = listDisciplina;
	}

	public List<Curso> getListCurso() {
		return listCurso;
	}

	public void setListCurso(List<Curso> listCurso) {
		this.listCurso = listCurso;
	}

	public List<Turma> getListTurma() {
		return listTurma;
	}

	public void setListTurma(List<Turma> listTurma) {
		this.listTurma = listTurma;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	protected GradeHoraria createInstance() {
		GradeHoraria gradeHoraria = new GradeHoraria();
		return gradeHoraria;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Turma turma = turmaHome.getDefinedInstance();
		if (turma != null) {
			getInstance().setTurma(turma);
		}
	}

	public boolean isWired() {
		if (getInstance().getTurma() == null)
			return false;
		return true;
	}

	public GradeHoraria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GradeHorariaItem> getGradeHorariaItems() {
		return getInstance() == null ? null : new ArrayList<GradeHorariaItem>(
				getInstance().getGradeHorariaItems());
	}
	
	public GradeHorariaHelper getGradeHorariaHelper()  {
		return this.gradeHorariaHelper;
	}
	
	public void adicionaDisciplina(DropEvent event) {
		GradeHorariaItemHelper item = gradeHorariaHelper.getGradeList().get(rowIndex);
		String dropValue = event.getDropValue().toString();
		if("domingo".equalsIgnoreCase(dropValue)) {
			item.getGradeDomingo().setDisciplina((Disciplina)event.getDragValue());
		} else if("segunda".equalsIgnoreCase(dropValue)) {
			item.getGradeSegunda().setDisciplina((Disciplina)event.getDragValue());
		} else if("terca".equalsIgnoreCase(dropValue)) {
			item.getGradeTerca().setDisciplina((Disciplina)event.getDragValue());
		} else if("quarta".equalsIgnoreCase(dropValue)) {
			item.getGradeQuarta().setDisciplina((Disciplina)event.getDragValue());
		} else if("quinta".equalsIgnoreCase(dropValue)) {
			item.getGradeQuinta().setDisciplina((Disciplina)event.getDragValue());
		} else if("sexta".equalsIgnoreCase(dropValue)) {
			item.getGradeSexta().setDisciplina((Disciplina)event.getDragValue());
		} else if("sabado".equalsIgnoreCase(dropValue)) {
			item.getGradeDomingo().setDisciplina((Disciplina)event.getDragValue());
		}
	}
	
	public void adicionaProfessor(DropEvent event) {
		GradeHorariaItemHelper item = gradeHorariaHelper.getGradeList().get(rowIndex);
		String dropValue = event.getDropValue().toString();
		if("domingo".equalsIgnoreCase(dropValue)) {
			item.getGradeDomingo().setProfessor((Professor)event.getDragValue());
		} else if("segunda".equalsIgnoreCase(dropValue)) {
			item.getGradeSegunda().setProfessor((Professor)event.getDragValue());
		} else if("terca".equalsIgnoreCase(dropValue)) {
			item.getGradeTerca().setProfessor((Professor)event.getDragValue());
		} else if("quarta".equalsIgnoreCase(dropValue)) {
			item.getGradeQuarta().setProfessor((Professor)event.getDragValue());
		} else if("quinta".equalsIgnoreCase(dropValue)) {
			item.getGradeQuinta().setProfessor((Professor)event.getDragValue());
		} else if("sexta".equalsIgnoreCase(dropValue)) {
			item.getGradeSexta().setProfessor((Professor)event.getDragValue());
		} else if("sabado".equalsIgnoreCase(dropValue)) {
			item.getGradeDomingo().setProfessor((Professor)event.getDragValue());
		}
	}
	
	public void adicionaLocalizacao(DropEvent event) {
		GradeHorariaItemHelper item = gradeHorariaHelper.getGradeList().get(rowIndex);
		String dropValue = event.getDropValue().toString();
		if("domingo".equalsIgnoreCase(dropValue)) {
			item.getGradeDomingo().setLocalizacao((Localizacao)event.getDragValue());
		} else if("segunda".equalsIgnoreCase(dropValue)) {
			item.getGradeSegunda().setLocalizacao((Localizacao)event.getDragValue());
		} else if("terca".equalsIgnoreCase(dropValue)) {
			item.getGradeTerca().setLocalizacao((Localizacao)event.getDragValue());
		} else if("quarta".equalsIgnoreCase(dropValue)) {
			item.getGradeQuarta().setLocalizacao((Localizacao)event.getDragValue());
		} else if("quinta".equalsIgnoreCase(dropValue)) {
			item.getGradeQuinta().setLocalizacao((Localizacao)event.getDragValue());
		} else if("sexta".equalsIgnoreCase(dropValue)) {
			item.getGradeSexta().setLocalizacao((Localizacao)event.getDragValue());
		} else if("sabado".equalsIgnoreCase(dropValue)) {
			item.getGradeDomingo().setLocalizacao((Localizacao)event.getDragValue());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadCursoSelect() {
		try {
			Query query = getEntityManager().createQuery("from Curso c where c.campus = :campus");
			query.setParameter("campus", campus);
			
			listCurso = query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadTurmaSelect() {
		try {
			Query query = getEntityManager().createQuery("from Turma t where t.gradeCurricular.curso = :curso");
			query.setParameter("curso", curso);
			
			listTurma = query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadGradeHoraria() {
		try {
			Query query = getEntityManager().createQuery("from Disciplina d join d.discGradeCurriculars g where g.gradeCurricular.curso = :curso and g.gradeCurricular.numAno = :numAno and g.gradeCurricular.numSemestre = :numSemestre and g.gradeCurricular.numPeriodoVigente = :numPeriodoVigente");
			query.setParameter("curso", curso);
			query.setParameter("numAno", turma.getGradeCurricular().getNumAno());
			query.setParameter("numSemestre", turma.getGradeCurricular().getNumSemestre());
			query.setParameter("numPeriodoVigente", turma.getGradeCurricular().getNumPeriodoVigente());
			
			listDisciplina = query.getResultList();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
	
	@Factory(value="gradeList")
	public void prepareGradeHoraria() {
		if(this.gradeList == null) {
			this.gradeList = new ArrayList<GradeHorariaItemHelper>(5);
			Calendar horario = Calendar.getInstance();
			horario.set(1970, 0, 1, 18, 40, 0);
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
			for(int i = 0; i < 5; i++) {
				Date hrInicio = horario.getTime();
				String horaInicio = timeFormat.format(hrInicio);
				GradeHorariaItemHelper item = new GradeHorariaItemHelper();
				GradeHorariaItem gradeSegunda = new GradeHorariaItem();
				gradeSegunda.setNumHoraInicio(hrInicio);
				GradeHorariaItem gradeTerca = new GradeHorariaItem();
				gradeTerca.setNumHoraInicio(hrInicio);
				GradeHorariaItem gradeQuarta = new GradeHorariaItem();
				gradeQuarta.setNumHoraInicio(hrInicio);
				GradeHorariaItem gradeQuinta = new GradeHorariaItem();
				gradeQuinta.setNumHoraInicio(hrInicio);
				GradeHorariaItem gradeSexta = new GradeHorariaItem();
				gradeSexta.setNumHoraInicio(hrInicio);
				if(i == 3) {
					horario.add(Calendar.MINUTE, 10);
				}
				item.setHoraInicio(horaInicio);
				horario.add(Calendar.MINUTE, 50);
				
				Date hrFim = horario.getTime();
				String horaFim = timeFormat.format(hrFim);
				item.setHoraFim(horaFim);
				gradeSegunda.setNumHoraFim(hrFim);
				gradeTerca.setNumHoraFim(hrFim);
				gradeQuarta.setNumHoraFim(hrFim);
				gradeQuinta.setNumHoraFim(hrFim);
				gradeSexta.setNumHoraFim(hrFim);
				
				item.setGradeSegunda(gradeSegunda);
				item.setGradeTerca(gradeTerca);
				item.setGradeQuarta(gradeQuarta);
				item.setGradeQuinta(gradeQuinta);
				item.setGradeSexta(gradeSexta);
				this.gradeList.add(item);
			}
			this.gradeHorariaHelper = new GradeHorariaHelper(gradeList);
		}
	}

	public void preparePersist() {
		GradeHoraria entity = getInstance();
		entity.setTurma(getTurma());
		for(GradeHorariaItemHelper helper : gradeList) {
			GradeHorariaItem itemSegunda = new GradeHorariaItem();
			itemSegunda.setIndDiaSemana(DiaSemanaType.SEGUNDA);
			itemSegunda.setGradeHoraria(entity);
			itemSegunda.setNumHoraInicio(helper.getGradeSegunda().getNumHoraInicio());
			itemSegunda.setNumHoraFim(helper.getGradeSegunda().getNumHoraFim());
			itemSegunda.setDisciplina(helper.getGradeSegunda().getDisciplina());
			itemSegunda.setLocalizacao(helper.getGradeSegunda().getLocalizacao());
			itemSegunda.setProfessor(helper.getGradeSegunda().getProfessor());
			if(itemSegunda.getDisciplina() != null || itemSegunda.getLocalizacao() != null || itemSegunda.getProfessor() != null) {
				entity.getGradeHorariaItems().add(itemSegunda);	
			}
			
			
			GradeHorariaItem itemTerca = new GradeHorariaItem();
			itemTerca.setIndDiaSemana(DiaSemanaType.TERCA);
			itemTerca.setGradeHoraria(entity);
			itemTerca.setNumHoraInicio(helper.getGradeTerca().getNumHoraInicio());
			itemTerca.setNumHoraFim(helper.getGradeTerca().getNumHoraFim());
			itemTerca.setDisciplina(helper.getGradeTerca().getDisciplina());
			itemTerca.setLocalizacao(helper.getGradeTerca().getLocalizacao());
			itemTerca.setProfessor(helper.getGradeTerca().getProfessor());
			if(itemTerca.getDisciplina() != null || itemTerca.getLocalizacao() != null || itemTerca.getProfessor() != null) {
				entity.getGradeHorariaItems().add(itemTerca);
			}
			
			GradeHorariaItem itemQuarta = new GradeHorariaItem();
			itemQuarta.setIndDiaSemana(DiaSemanaType.QUARTA);
			itemQuarta.setGradeHoraria(entity);
			itemQuarta.setNumHoraInicio(helper.getGradeQuarta().getNumHoraInicio());
			itemQuarta.setNumHoraFim(helper.getGradeQuarta().getNumHoraFim());
			itemQuarta.setDisciplina(helper.getGradeQuarta().getDisciplina());
			itemQuarta.setLocalizacao(helper.getGradeQuarta().getLocalizacao());
			itemQuarta.setProfessor(helper.getGradeQuarta().getProfessor());
			if(itemQuarta.getDisciplina() != null || itemQuarta.getLocalizacao() != null || itemQuarta.getProfessor() != null) {
				entity.getGradeHorariaItems().add(itemQuarta);
			}
			
			GradeHorariaItem itemQuinta = new GradeHorariaItem();
			itemQuinta.setIndDiaSemana(DiaSemanaType.QUINTA);
			itemQuinta.setGradeHoraria(entity);
			itemQuinta.setNumHoraInicio(helper.getGradeQuinta().getNumHoraInicio());
			itemQuinta.setNumHoraFim(helper.getGradeQuinta().getNumHoraFim());
			itemQuinta.setDisciplina(helper.getGradeQuinta().getDisciplina());
			itemQuinta.setLocalizacao(helper.getGradeQuinta().getLocalizacao());
			itemQuinta.setProfessor(helper.getGradeQuinta().getProfessor());
			if(itemQuinta.getDisciplina() != null || itemQuinta.getLocalizacao() != null || itemQuinta.getProfessor() != null) {
				entity.getGradeHorariaItems().add(itemQuinta);
			}
			
			GradeHorariaItem itemSexta = new GradeHorariaItem();
			itemSexta.setIndDiaSemana(DiaSemanaType.SEXTA);
			itemSexta.setGradeHoraria(entity);
			itemSexta.setNumHoraInicio(helper.getGradeSexta().getNumHoraInicio());
			itemSexta.setNumHoraFim(helper.getGradeSexta().getNumHoraFim());
			itemSexta.setDisciplina(helper.getGradeSexta().getDisciplina());
			itemSexta.setLocalizacao(helper.getGradeSexta().getLocalizacao());
			itemSexta.setProfessor(helper.getGradeSexta().getProfessor());
			if(itemSexta.getDisciplina() != null || itemSexta.getLocalizacao() != null || itemSexta.getProfessor() != null) {
				entity.getGradeHorariaItems().add(itemSexta);
			}
		}
		this.instance = entity;
		super.persist();
	}
	
	@SuppressWarnings("deprecation")
	public void prepareView() {
		if(this.getGradeHorariaIdtGradeHoraria() != null) {
			prepareGradeHoraria();
			for (GradeHorariaItem item : getInstance().getGradeHorariaItems()) {
				if(item.getNumHoraInicio().getHours() == 18) {
					teste(gradeList.get(0), item);
				} else if(item.getNumHoraInicio().getHours() == 19) {
					teste(gradeList.get(1), item);
				} else if(item.getNumHoraInicio().getHours() == 20) {
					teste(gradeList.get(2), item);
				} else if(item.getNumHoraInicio().getHours() == 21) {
					teste(gradeList.get(3), item);
				} else if(item.getNumHoraInicio().getHours() == 22) {
					teste(gradeList.get(4), item);
				}
			}
			System.out.println("Teste");
		}
	}
	
	public void prepareEdit() {
		setInstance(find());
		setCampus(instance.getTurma().getGradeCurricular().getCurso().getCampus());
		setCurso(instance.getTurma().getGradeCurricular().getCurso());
		setTurma(instance.getTurma());
		loadCursoSelect();
		loadTurmaSelect();
		loadGradeHoraria();
		prepareView();
		System.out.println("PrepareEdit is being executed...");
	}
	
	private void teste(GradeHorariaItemHelper itemHelper, GradeHorariaItem item) {
		if(item.getIndDiaSemana().equals(DiaSemanaType.SEGUNDA)) {
			teste1(itemHelper.getGradeSegunda(), item);
		} else if(item.getIndDiaSemana().equals(DiaSemanaType.TERCA)) {
			teste1(itemHelper.getGradeTerca(), item);
		} else if(item.getIndDiaSemana().equals(DiaSemanaType.QUARTA)) {
			teste1(itemHelper.getGradeQuarta(), item);
		} else if(item.getIndDiaSemana().equals(DiaSemanaType.QUINTA)) {
			teste1(itemHelper.getGradeQuinta(), item);
		} else if(item.getIndDiaSemana().equals(DiaSemanaType.SEXTA)) {
			teste1(itemHelper.getGradeSexta(), item);
		}
	}
	
	private void teste1(GradeHorariaItem item, GradeHorariaItem value) {
		item.setDisciplina(value.getDisciplina());
		item.setLocalizacao(value.getLocalizacao());
		item.setProfessor(value.getProfessor());
	}
	
}
