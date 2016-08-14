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

import br.nom.martinelli.ricardo.model.Campus;

@Path("campus")
@Stateless
public class CampusResource {
	
	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Campus> getCampus() {
		Query q = em.createQuery("SELECT e FROM Campus e");
		List<Campus> campus = q.getResultList();
		return campus;
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaCampus(Campus campus) {
		em.persist(campus);
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraCampus(Campus campus) {
		em.merge(campus);
	}
	

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Campus getCampus(@PathParam("id") Long id) {
		Campus campus = em.find(Campus.class, id);
		return campus;
	}

	@DELETE
	@Path("{id}")
	public void removeCampus(@PathParam("id") Long id) {
		Campus campus = em.find(Campus.class, id);
		em.remove(campus);
	}

}
