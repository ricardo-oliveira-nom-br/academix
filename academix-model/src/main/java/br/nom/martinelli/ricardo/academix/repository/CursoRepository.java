package br.nom.martinelli.ricardo.academix.repository;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.nom.martinelli.ricardo.academix.model.Curso;

public class CursoRepository extends AbstractRepository<Curso, Long> {

	public CursoRepository() {
		super(Curso.class);
	}

	public boolean validaDados(Curso entidade) {
		boolean valido = true;
		
		// TODO Implementar validação
		return valido;
	}
	
	public List<Curso> comCampus(Long campusId) {
		CriteriaQuery<Curso> cq = em.getCriteriaBuilder().createQuery(Curso.class);
		Root<Curso> curso = cq.from(Curso.class);
		cq.where(em.getCriteriaBuilder().equal(curso.get("campus"), campusId));
		CriteriaQuery<Curso> all = cq.select(curso); 
		TypedQuery<Curso> allQuery = em.createQuery(all);
		
		return allQuery.getResultList();
	}

}
