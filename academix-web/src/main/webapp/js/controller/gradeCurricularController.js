angular.module('academix').controller('GradeCurricularListController', function ($scope) {
	
	$scope.grades = [
	    {
	    	campus: {
		    	nome: "Ipiranga",
		    	endereco: {
		    		logradouro: "Rua Vergueiro",
			    	cep: "04273100",
			    	bairro: "Vila Firmiano Pinto",
			    	cidade: "São Paulo",
			    	uf: "SP"
		    	},
		    	numero: "7133",
		    	complemento: ""
		    },
		    curso: {
		    	nome: "Ciência da computação",
		    },
		    ano: 2015,
		    semestre: 1
	    },
	    {
	    	campus: {
		    	nome: "Ipiranga",
		    	endereco: {
		    		logradouro: "Rua Vergueiro",
			    	cep: "04273100",
			    	bairro: "Vila Firmiano Pinto",
			    	cidade: "São Paulo",
			    	uf: "SP"
		    	},
		    	numero: "7133",
		    	complemento: ""
		    },
		    curso: {
		    	nome: "Ciência da computação",
		    },
		    ano: 2015,
		    semestre: 2
	    },
	    {
	    	campus: {
		    	nome: "Ipiranga",
		    	endereco: {
		    		logradouro: "Rua Vergueiro",
			    	cep: "04273100",
			    	bairro: "Vila Firmiano Pinto",
			    	cidade: "São Paulo",
			    	uf: "SP"
		    	},
		    	numero: "7133",
		    	complemento: ""
		    },
		    curso: {
		    	nome: "Ciência da computação",
		    },
		    ano: 2016,
		    semestre: 1
	    },
	    {
	    	campus: {
		    	nome: "Ipiranga",
		    	endereco: {
		    		logradouro: "Rua Vergueiro",
			    	cep: "04273100",
			    	bairro: "Vila Firmiano Pinto",
			    	cidade: "São Paulo",
			    	uf: "SP"
		    	},
		    	numero: "7133",
		    	complemento: ""
		    },
		    curso: {
		    	nome: "Ciência da computação",
		    },
		    ano: 2016,
		    semestre: 2
	    }
	];
	
	function obterGradesCurriculares() {
//		$scope.enderecos = Endereco.jsonpquery();
		GradeCurricular.query(
			function(grades) {
//				$scope.grades = grades;
			},
			function(msg) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + msg.statusText};
				console.log(msg);
			}
		);
	}
	
})

.controller('GradeCurricularController', function($scope, $routeParams, Campus, Curso, GradeCurricular) {

	$scope.campus = [];
	
	$scope.cursos = [];
	
	if($routeParams.gradeCurricularId) {
		GradeCurricular.get({id: $routeParams.gradeCurricularId},
				function(gradeCurricular) {
					$scope.gradeCurricular = gradeCurricular;
				},
				function(erro) {
					$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
					console.log(erro);
				}
			);
	} else {
		$scope.gradeCurricular = new GradeCurricular();
	}
	
	function listarCampus() {
		// $scope.enderecos = Endereco.jsonpquery();
		Campus.query(
			function(campus) {
				$scope.campus = campus;
			},
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			});
	}
	
	function listarCursos() {
		// $scope.enderecos = Endereco.jsonpquery();
		Curso.query(
			function(cursos) {
				$scope.cursos = cursos;
			},
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			});
	}
			
	listarCampus();
	listarCursos();
});