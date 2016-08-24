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

import br.nom.martinelli.ricardo.academix.model.Curso;
import br.nom.martinelli.ricardo.academix.repository.CampusRepository;
import br.nom.martinelli.ricardo.academix.repository.CursoRepository;

@Path("curso")
@Stateless
public class CursoResource {

	@Inject
	CursoRepository repositorio;
	
	@Inject
	CampusRepository campus;
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<Curso> getCursos() {
		return repositorio.listarTodos();
	}
	
	@POST
	@Path("")
	@Consumes("application/json")
	public void adicionaCurso(Curso curso) {
		if(repositorio.validaDados(curso)) {
			curso.setCampus(campus.comChave(curso.getCampus().getId()));
			repositorio.adiciona(curso);	
		}
	}
	
	@PUT
	@Path("")
	@Consumes("application/json")
	public void alteraCurso(Curso curso) {
		if(repositorio.validaDados(curso)) {
			curso.setCampus(campus.comChave(curso.getCampus().getId()));
			repositorio.altera(curso);
		}
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Curso getCurso(@PathParam("id") Long id) {
		return repositorio.comChave(id);
	}

	@DELETE
	@Path("{id}")
	public void removeCurso(@PathParam("id") Long id) {
		repositorio.remove(repositorio.comChave(id));
	}

}