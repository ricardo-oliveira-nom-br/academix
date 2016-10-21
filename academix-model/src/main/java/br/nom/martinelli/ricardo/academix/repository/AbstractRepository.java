package br.nom.martinelli.ricardo.academix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.nom.martinelli.ricardo.academix.model.Endereco;

public abstract class AbstractRepository<T,I> {

	@PersistenceContext
	protected EntityManager em;
	
	private final Class<T> tipo;
	
	protected AbstractRepository(Class<T> clazz) {
		this.tipo = clazz;
	}
	
	public List<T> listarTodos() {
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(tipo);
		Root<T> root = cq.from(tipo);
		CriteriaQuery<T> all = cq.select(root); 
		TypedQuery<T> allQuery = em.createQuery(all);
		
		return allQuery.getResultList();
	}
	
	public T comChave(I id) {
		return em.find(tipo, id);
	}
	
	public void adiciona(T entidade) {
		em.persist(entidade);
	}
	
	public void altera(T entidade) {
		em.merge(entidade);
	}
	
	public void remove(T entidade) {
		em.remove(entidade);
	}
	
}
