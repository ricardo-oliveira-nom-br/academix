package br.nom.martinelli.ricardo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.nom.martinelli.ricardo.model.Endereco;

@Path("/")
@Stateless
public class EnderecoListService {
	
	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("/alunos")
	@Produces("application/json")
	public List<Endereco> getEnderecos() {
		Query q = em.createQuery("SELECT e FROM Endereco e");
		List<Endereco> enderecos = q.getResultList();
		return enderecos;
	}

}
