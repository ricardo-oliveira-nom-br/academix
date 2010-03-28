package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.Aluno;
import br.inf.prismasoft.academix.entity.Campus;
import br.inf.prismasoft.academix.entity.Curso;
import br.inf.prismasoft.academix.entity.Turma;

@Name("matriculaHome")
public class MatriculaHome extends EntityHome<Aluno> {
	
	private static final long serialVersionUID = 9127862215563911518L;
	
	Integer turmaEstorno;
	Campus campus;
	List<Curso> listCurso = new ArrayList<Curso>();
	Curso curso;
	List<Turma> listTurma = new ArrayList<Turma>();
	Turma turma;

	public Integer getTurmaEstorno() {
		return turmaEstorno;
	}

	public void setTurmaEstorno(Integer turmaEstorno) {
		this.turmaEstorno = turmaEstorno;
	}

	public void setAlunoIdtAluno(Integer id) {
		setId(id);
	}

	public Integer getAlunoIdtAluno() {
		return (Integer) getId();
	}
	
	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public List<Curso> getListCurso() {
		return listCurso;
	}

	public void setListCurso(List<Curso> listCurso) {
		this.listCurso = listCurso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Turma> getListTurma() {
		return listTurma;
	}

	public void setListTurma(List<Turma> listTurma) {
		this.listTurma = listTurma;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	protected Aluno createInstance() {
		Aluno aluno = new Aluno();
		return aluno;
	}

	public void wire() {
	}

	public boolean isWired() {
		return true;
	}

	public Aluno getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Campus> getListCampus() {
		return getEntityManager().createQuery("from Campus").getResultList();
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
	
	public List<Turma> getListTurmas() {
		return new ArrayList<Turma>(getInstance().getTurmas());
	}

	@Override
	public String persist() {
		getInstance().getTurmas().add(turma);
		super.update();
		
		return getCreatedMessage().getExpressionString();
	}
	
	public void estornoMatricula() {
		for(Turma turma: getInstance().getTurmas()) {
			if(turmaEstorno.equals(turma.getIdtTurma())) {
				getInstance().getTurmas().remove(turma);
				break;
			}
		}
		getInstance().getTurmas().remove(turmaEstorno);
	}
		
	
}
