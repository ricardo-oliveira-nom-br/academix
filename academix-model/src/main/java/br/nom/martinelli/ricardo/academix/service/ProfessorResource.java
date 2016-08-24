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

import br.nom.martinelli.ricardo.academix.model.Professor;
import br.nom.martinelli.ricardo.academix.repository.ProfessorRepository;

@Path("professor")
@Stateless
public class ProfessorResource {

	@Inject
	private ProfessorRepository repositorio; 

	@GET
	@Path("")
	@Produces("application/json")
	public List<Professor> getProfessor() {
		return repositorio.listarTodos();
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaProfessor(Professor professor) {
		if(repositorio.validaDados(professor)) {
			repositorio.adiciona(professor);
		}
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraProfessor(Professor professor) {
		if(repositorio.validaDados(professor)) {
			repositorio.altera(professor);
		}
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Professor getProfessor(@PathParam("id") Long id) {
		return repositorio.comChave(id);
	}

	@DELETE
	@Path("{id}")
	public void removeProfessor(@PathParam("id") Long id) {
		repositorio.remove(repositorio.comChave(id));
	}

}