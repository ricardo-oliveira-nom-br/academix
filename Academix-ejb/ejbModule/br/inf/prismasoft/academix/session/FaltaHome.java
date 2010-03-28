package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.core.Expressions;
import org.jboss.seam.core.Expressions.ValueExpression;
import org.jboss.seam.framework.EntityHome;

import br.inf.prismasoft.academix.entity.Aluno;
import br.inf.prismasoft.academix.entity.Disciplina;
import br.inf.prismasoft.academix.entity.Falta;
import br.inf.prismasoft.academix.entity.FaltaItem;
import br.inf.prismasoft.academix.entity.Turma;

@Name("faltaHome")
public class FaltaHome extends EntityHome<Falta> {

	private static final long serialVersionUID = 5804079119103077735L;
	@In(create = true)
	DisciplinaHome disciplinaHome;
	@In(create = true)
	TurmaHome turmaHome;
	
	List<Turma> listTurma;
	Set<Disciplina> listDisciplina = new HashSet<Disciplina>();
	List<FaltaItem> listFaltaItem = new ArrayList<FaltaItem>();

	public void setFaltaIdtFalta(Integer id) {
		setId(id);
	}

	public Integer getFaltaIdtFalta() {
		return (Integer) getId();
	}

	public List<Turma> getListTurma() {
		if(listTurma == null || listTurma.isEmpty()) {
			createListTurma();
		}
		return listTurma;
	}

	public void setListTurma(List<Turma> listTurma) {
		this.listTurma = listTurma;
	}

	public Set<Disciplina> getListDisciplina() {
		return listDisciplina;
	}

	public void setListDisciplina(Set<Disciplina> listDisciplina) {
		this.listDisciplina = listDisciplina;
	}

	public List<FaltaItem> getListFaltaItem() {
		return listFaltaItem;
	}

	public void setListFaltaItem(List<FaltaItem> listFaltaItem) {
		this.listFaltaItem = listFaltaItem;
	}
	
	@Override
	protected Falta createInstance() {
		Falta falta = new Falta();
		return falta;
	}

	public void wire() {
		Disciplina disciplina = disciplinaHome.getDefinedInstance();
		if (disciplina != null) {
			getInstance().setDisciplina(disciplina);
		}
		Turma turma = turmaHome.getDefinedInstance();
		if (turma != null) {
			getInstance().setTurma(turma);
		}
	}

	public boolean isWired() {
		if (getInstance().getDisciplina() == null)
			return false;
		if (getInstance().getTurma() == null)
			return false;
		return true;
	}

	public Falta getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<FaltaItem> getFaltaItems() {
		return getInstance() == null ? null : new ArrayList<FaltaItem>(getInstance().getFaltaItems());
	}

	@SuppressWarnings("unchecked")
	private void createListTurma() {
		setListTurma(getEntityManager().createQuery("from Turma").getResultList());
	}
	
	@SuppressWarnings("unchecked")
	public void loadDisciplinaSelect() {
		Query query = getEntityManager().createQuery("from Disciplina d join d.gradeHorariaItems g where g.gradeHoraria.turma = :turma");
		query.setParameter("turma", getInstance().getTurma());
		
		List<Object[]> list = query.getResultList();
		for(Object[] array : list) {
			listDisciplina.add((Disciplina) array[0]);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadFaltaItemList() {
		Query query = getEntityManager().createQuery("from Aluno a join a.turmas t where t = :turma");
		query.setParameter("turma", instance.getTurma());
		
		List<Object[]> list = query.getResultList();
		for(Object[] array : list) {
			FaltaItem item = new FaltaItem();
			item.setAluno((Aluno) array[0]);
			item.setFalta(getInstance());
			listFaltaItem.add(item);
		}
	}

	public void preparePersist() {
		getInstance().getFaltaItems().addAll(listFaltaItem);
		super.persist();
	}
	
	public void prepareSelect() {
		getListFaltaItem().addAll(getInstance().getFaltaItems());
	}
	
	public void prepareEdit() {
		loadDisciplinaSelect();
		prepareSelect();
	}
	
	public void prepareUpdate() {
		getInstance().getFaltaItems().addAll(listFaltaItem);
		super.update();
	}

	@Override
	@SuppressWarnings("unchecked")
	public ValueExpression getCreatedMessage() {
		ValueExpression value = Expressions.instance().createValueExpression("Apontamento de Faltas criado com sucesso!");
		return value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ValueExpression getDeletedMessage() {
		ValueExpression value = Expressions.instance().createValueExpression("Apontamento de Faltas removido com sucesso!");
		return value;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ValueExpression getUpdatedMessage() {
		ValueExpression value = Expressions.instance().createValueExpression("Apontamento de Faltas atualizado com sucesso!");
		return value;
	}

}
