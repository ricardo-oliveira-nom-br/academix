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

import br.nom.martinelli.ricardo.model.Professor;

@Path("professor")
@Stateless
public class ProfessorResource {

	@PersistenceContext
	private EntityManager em;

	@GET
	@Path("")
	@Produces("application/json")
	public List<Professor> getProfessor() {
		Query q = em.createQuery("SELECT e FROM Professor e");
		List<Professor> professores = q.getResultList();
		return professores;
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaProfessor(Professor professor) {
		em.persist(professor);
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraProfessor(Professor professor) {
		em.merge(professor);
	}
	

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Professor getProfessor(@PathParam("id") Long id) {
		Professor professor = em.find(Professor.class, id);
		return professor;
	}

	@DELETE
	@Path("{id}")
	public void removeProfessor(@PathParam("id") Long id) {
		Professor professor = em.find(Professor.class, id);
		em.remove(professor);
	}

}
