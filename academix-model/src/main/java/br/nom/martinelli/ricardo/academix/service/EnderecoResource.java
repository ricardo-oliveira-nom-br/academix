package br.nom.martinelli.ricardo.academix.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.nom.martinelli.ricardo.academix.model.Endereco;
import br.nom.martinelli.ricardo.academix.repository.EnderecoRepository;

@Path("endereco")
@Stateless
public class EnderecoResource {

	@Inject
	private EnderecoRepository repositorio;

	@GET
	@Path("")
	@Produces("application/json")
	public List<Endereco> getEnderecos() {
		return repositorio.listarTodos();
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaEndereco(Endereco endereco) {
		if(repositorio.validaDados(endereco)) {
			repositorio.adiciona(endereco);	
		}
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraEndereco(Endereco endereco) {
		if(repositorio.validaDados(endereco)) {
			repositorio.altera(endereco);
		}
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Endereco getEndereco(@PathParam("id") Long id) {
		return repositorio.comChave(id);
	}

	@DELETE
	@Path("{id}")
	public void removeEndereco(@PathParam("id") Long id) {
		repositorio.remove(repositorio.comChave(id));
	}

}