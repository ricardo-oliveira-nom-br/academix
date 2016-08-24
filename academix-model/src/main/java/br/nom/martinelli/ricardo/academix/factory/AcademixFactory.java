package br.nom.martinelli.ricardo.academix.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import br.nom.martinelli.ricardo.academix.repository.CampusRepository;
import br.nom.martinelli.ricardo.academix.repository.CursoRepository;
import br.nom.martinelli.ricardo.academix.repository.DisciplinaRepository;
import br.nom.martinelli.ricardo.academix.repository.EnderecoRepository;
import br.nom.martinelli.ricardo.academix.repository.GradeCurricularRepository;
import br.nom.martinelli.ricardo.academix.repository.LocalizacaoRepository;
import br.nom.martinelli.ricardo.academix.repository.ProfessorRepository;
import javax.inject.Named;

@RequestScoped
public class AcademixFactory {
	
	@Named
	@Produces
	public EnderecoRepository getEnderecoRepository(@New EnderecoRepository enderecoRepository) {
		return enderecoRepository;
	}
	
	@Named
	@Produces
	public CampusRepository getCampusRepository(@New CampusRepository campusRepository) {
		return campusRepository;
	}

	@Named
	@Produces
	public CursoRepository getCursoRepository(@New CursoRepository cursoRepository) {
		return cursoRepository;
	}

	@Named
	@Produces
	public DisciplinaRepository getDisciplinaRepository(@New DisciplinaRepository disciplinaRepository) {
		return disciplinaRepository;
	}

	@Named
	@Produces
	public ProfessorRepository getProfessorRepository(@New ProfessorRepository professorRepository) {
		return professorRepository;
	}
	
	@Named
	@Produces
	public LocalizacaoRepository getLocalizacaoRepository(@New LocalizacaoRepository localizacaoRepository) {
		return localizacaoRepository;
	}
	
	@Named
	@Produces
	public GradeCurricularRepository getGradeCurricularRepository(@New GradeCurricularRepository gradeCurricularRepository) {
		return gradeCurricularRepository;
	}

}