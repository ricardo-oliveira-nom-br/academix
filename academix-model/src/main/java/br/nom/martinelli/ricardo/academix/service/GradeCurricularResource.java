package br.nom.martinelli.ricardo.academix.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.nom.martinelli.ricardo.academix.model.Curso;
import br.nom.martinelli.ricardo.academix.model.GradeCurricular;
import br.nom.martinelli.ricardo.academix.repository.CursoRepository;
import br.nom.martinelli.ricardo.academix.repository.GradeCurricularRepository;

@Path("gradeCurricular")
@Stateless
public class GradeCurricularResource {
	
	@Inject
	GradeCurricularRepository repositorio;
	
	@Inject
	CursoRepository curso;
	
	@GET
	@Path("")
	@Produces("application/json")
	public List<GradeCurricular> getGradesCurriculares() {
		return repositorio.listarTodos();
	}
	
	@POST
	@Path("")
	public void criaGradeCurricular(Long cursoId) {
		Curso c = curso.comChave(cursoId);
		GradeCurricular grade = new GradeCurricular();
		grade.setCurso(c);
		
		repositorio.adiciona(grade);
	}

}