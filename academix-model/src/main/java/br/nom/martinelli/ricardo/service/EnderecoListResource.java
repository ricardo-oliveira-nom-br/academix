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
import br.nom.martinelli.ricardo.types.UF;

@Path("/")
@Stateless
public class EnderecoListResource {
	
	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("/alunos")
	@Produces("application/json")
	public List<Endereco> getEnderecos() {
		Query q = em.createQuery("SELECT e FROM Endereco e");
		List<Endereco> enderecos = q.getResultList();
		Endereco end = new Endereco();
		end.setId(1L);
		end.setLogradouro("Avenida Doutor Arnaldo");
		end.setCep("01235090");
		end.setBairro("Lapa");
		end.setCidade("Sao Paulo");
		end.setUf(UF.SP);
		enderecos.add(end);
		return enderecos;
	}

}
