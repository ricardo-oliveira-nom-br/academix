angular.module('academix').controller('GradeCurricularListController', function ($scope) {
	
	$scope.grades = [
	    {
    		id: 1,
    		version: 0,
    		curso: {
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
		    	nome: "Ciência da computação",
		    	periodicidade: 5,
		    	periodo: 4
		    },
	    	itens: [
	    	    {
	    	    	id: 1,
	    	    	version: 0,
	    	    	periodoLetivo: 1,
	    	    	ano: 2015,
	    		    semestre: 1
	    	    },
	    	    {
	    	    	id: 2,
	    	    	version: 0,
	    	    	periodoLetivo: 2,
	    	    	ano: 2016,
	    		    semestre: 1
	    	    },
	    	    {
	    	    	id: 3,
	    	    	version: 0,
	    	    	periodoLetivo: 3,
	    	    	ano: 2017,
	    		    semestre: 1
	    	    },
	    	    {
	    	    	id: 4,
	    	    	version: 0,
	    	    	periodoLetivo: 4,
	    	    	ano: 2018,
	    		    semestre: 1
	    	    }
	    	]
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
	
	$scope.number = 4;
	
	$scope.getNumber = function(num) {
	    return new Array(num);   
	}
	
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