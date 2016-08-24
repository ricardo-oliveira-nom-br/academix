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

import br.nom.martinelli.ricardo.academix.model.Disciplina;
import br.nom.martinelli.ricardo.academix.repository.DisciplinaRepository;

@Path("disciplina")
@Stateless
public class DisciplinaResource {

	@Inject
	private DisciplinaRepository repositorio; 
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Disciplina> getisciplinas() {
		return repositorio.listarTodos();
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaDisciplina(Disciplina disciplina) {
		if(repositorio.validaDados(disciplina)) {
			repositorio.adiciona(disciplina);
		}
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraDisciplina(Disciplina disciplina) {
		if(repositorio.validaDados(disciplina)) {
			repositorio.altera(disciplina);
		}
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Disciplina getDisciplina(@PathParam("id") Long id) {
		return repositorio.comChave(id);
	}

	@DELETE
	@Path("{id}")
	public void removeDisciplina(@PathParam("id") Long id) {
		repositorio.remove(repositorio.comChave(id));
	}

}