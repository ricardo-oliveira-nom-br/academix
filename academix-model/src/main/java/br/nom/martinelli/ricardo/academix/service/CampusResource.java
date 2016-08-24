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

import br.nom.martinelli.ricardo.academix.model.Campus;
import br.nom.martinelli.ricardo.academix.repository.CampusRepository;

@Path("campus")
@Stateless
public class CampusResource {
	
	@Inject
	private CampusRepository repositorio;	
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Campus> getCampus() {
		return repositorio.listarTodos();
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaCampus(Campus campus) {
		if(repositorio.validaDados(campus)) {
			repositorio.adiciona(campus);
		}
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraCampus(Campus campus) {
		if (repositorio.validaDados(campus)) {
			repositorio.altera(campus);
		}
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Campus getCampus(@PathParam("id") Long id) {
		return repositorio.comChave(id);
	}

	@DELETE
	@Path("{id}")
	public void removeCampus(@PathParam("id") Long id) {
		repositorio.remove(repositorio.comChave(id));
	}

}