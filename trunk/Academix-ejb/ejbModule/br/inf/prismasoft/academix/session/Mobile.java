package br.inf.prismasoft.academix.session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import br.inf.prismasoft.academix.entity.AvaliacaoItem;
import br.inf.prismasoft.academix.entity.FaltaItem;
import br.inf.prismasoft.academix.entity.Turma;

@Name("mobileHome")
public class Mobile extends EntityQuery {
	
	@Override
	public String getEjbql() {
		return "from Turma t";
	}

	private static final long serialVersionUID = 3460307180483898667L;

	private String usuario;
	
	private String senha;
	
	private Integer alunoIdtAluno;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getAlunoIdtAluno() {
		return alunoIdtAluno;
	}

	public void setAlunoIdtAluno(Integer alunoIdtAluno) {
		this.alunoIdtAluno = alunoIdtAluno;
	}

	public boolean getLogin() {
		if("mobile".equals(usuario) && "mobile".equals(senha)) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> getTurmas() {
		Query query = getEntityManager().createQuery("from Turma t join t.alunos a where a.idtAluno = :id");
		query.setParameter("id", alunoIdtAluno);
		
		List<Turma> turmaList = new ArrayList<Turma>();
		for(Iterator it = query.getResultList().iterator(); it.hasNext(); ) {
			Object[] array = (Object[]) it.next();
			turmaList.add((Turma) array[0]);
		}
		
		return turmaList;
	}
	
	@SuppressWarnings("unchecked")
	public List<FaltaItem>getFaltas() {
		Query query = getEntityManager().createQuery("from FaltaItem i where i.aluno.idtAluno = :id");
		query.setParameter("id", alunoIdtAluno);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<AvaliacaoItem> getNotas() {
		Query query = getEntityManager().createQuery("from AvaliacaoItem i where i.aluno.idtAluno = :id");
		query.setParameter("id", alunoIdtAluno);
		
		return query.getResultList();
	}
	
}
