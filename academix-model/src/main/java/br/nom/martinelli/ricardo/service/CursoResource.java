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

import br.nom.martinelli.ricardo.model.Curso;

@Path("curso")
@Stateless
public class CursoResource {
	
	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Curso> getCursos() {
		Query q = em.createQuery("SELECT e FROM Curso e");
		List<Curso> curso = q.getResultList();
		return curso;
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaCurso(Curso curso) {
		em.persist(curso);
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraCurso(Curso curso) {
		em.merge(curso);
	}
	

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Curso getCurso(@PathParam("id") Long id) {
		Curso curso = em.find(Curso.class, id);
		return curso;
	}

	@DELETE
	@Path("{id}")
	public void removeCurso(@PathParam("id") Long id) {
		Curso curso = em.find(Curso.class, id);
		em.remove(curso);
	}

}