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

import br.nom.martinelli.ricardo.model.Localizacao;

@Path("localizacao")
@Stateless
public class LocalizacaoResource {

	@PersistenceContext
	private EntityManager em;

	@GET
	@Path("")
	@Produces("application/json")
	public List<Localizacao> getLocalizacoes() {
		Query q = em.createQuery("SELECT e FROM Localizacao e");
		List<Localizacao> enderecos = q.getResultList();
		return enderecos;
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaLocalizacao(Localizacao localizacao) {
		em.persist(localizacao);
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraLocalizacao(Localizacao localizacao) {
		em.merge(localizacao);
	}
	

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Localizacao getLocalizacao(@PathParam("id") Long id) {
		Localizacao localizacao = em.find(Localizacao.class, id);
		return localizacao;
	}

	@DELETE
	@Path("{id}")
	public void removeLocalizacao(@PathParam("id") Long id) {
		Localizacao localizacao = em.find(Localizacao.class, id);
		em.remove(localizacao);
	}

}
