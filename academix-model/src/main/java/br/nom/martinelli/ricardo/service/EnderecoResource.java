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

import br.nom.martinelli.ricardo.model.Endereco;

@Path("endereco")
@Stateless
public class EnderecoResource {

	@PersistenceContext
	private EntityManager em;

	@GET
	@Path("")
	@Produces("application/json")
	public List<Endereco> getEnderecos() {
		Query q = em.createQuery("SELECT e FROM Endereco e");
		List<Endereco> enderecos = q.getResultList();
		return enderecos;
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaEndereco(Endereco endereco) {
		em.persist(endereco);
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraEndereco(Endereco endereco) {
		em.merge(endereco);
	}
	

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Endereco getEndereco(@PathParam("id") Long id) {
		Endereco endereco = em.find(Endereco.class, id);
		return endereco;
	}

	@DELETE
	@Path("{id}")
	public void removeEndereco(@PathParam("id") Long id) {
		Endereco endereco = em.find(Endereco.class, id);
		em.remove(endereco);
	}

}
