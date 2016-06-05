angular.module('academix', ['ngRoute'])
	.config(function($routeProvider) {
		
		// Secretaria
		
		// Aluno
		
		// Professor
		
		// Relatorios
		
		// Cadastros
		$routeProvider.when('/cadastros/endereco', {
			templateUrl: 'partials/cadastros/endereco.html',
			controller: 'EnderecoListController',
		});
		$routeProvider.when('/cadastros/campus', {
			templateUrl: 'partials/cadastros/campus.html',
			controller: 'CampusListController',
		});
		$routeProvider.when('/cadastros/curso', {
			templateUrl: 'partials/cadastros/curso.html',
			controller: 'CursoListController',
		});
		$routeProvider.when('/cadastros/campus', {
			templateUrl: 'partials/cadastros/campus.html',
			controller: 'CampusListController',
		});
		$routeProvider.when('/cadastros/gradeCurricular', {
			templateUrl: 'partials/cadastros/gradeCurricular.html',
			controller: 'GradeCurricularListController',
		});
		$routeProvider.when('/cadastros/disciplina', {
			templateUrl: 'partials/cadastros/disciplina.html',
			controller: 'DisciplinaListController',
		});
		$routeProvider.when('/cadastros/turma', {
			templateUrl: 'partials/cadastros/turma.html',
			controller: 'TurmaListController',
		});
		$routeProvider.when('/cadastros/aluno', {
			templateUrl: 'partials/cadastros/aluno.html',
			controller: 'AlunoListController',
		});
		$routeProvider.when('/cadastros/professor', {
			templateUrl: 'partials/cadastros/professor.html',
			controller: 'ProfessorListController',
		});
		$routeProvider.when('/cadastros/localizacao', {
			templateUrl: 'partials/cadastros/localizacao.html',
			controller: 'LocalizacaoListController',
		});
		
});
