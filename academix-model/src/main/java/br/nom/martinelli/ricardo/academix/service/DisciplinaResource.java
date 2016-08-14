package br.nom.martinelli.ricardo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.nom.martinelli.ricardo.model.Disciplina;

@Path("disciplina")
@Stateless
public class DisciplinaResource {

	@PersistenceContext
	private EntityManager em;

	@GET
	@Path("")
	@Produces("application/json")
	public List<Disciplina> getisciplinas() {
		Query q = em.createQuery("SELECT d FROM Disciplina d");
		List<Disciplina> disciplinas = q.getResultList();
		return disciplinas;
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaDisciplina(Disciplina disciplina) {
		em.persist(disciplina);
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraDisciplina(Disciplina disciplina) {
		em.merge(disciplina);
	}
	

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Disciplina getDisciplina(@PathParam("id") Long id) {
		Disciplina disciplina = em.find(Disciplina.class, id);
		return disciplina;
	}

	@DELETE
	@Path("{id}")
	public void removeDisciplina(@PathParam("id") Long id) {
		Disciplina disciplina = em.find(Disciplina.class, id);
		em.remove(disciplina);
	}

}
