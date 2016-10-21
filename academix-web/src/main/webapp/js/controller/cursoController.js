angular.module('academix').controller('CursoListController', function ($scope, Curso) {
	
	$scope.cursos = [];
	
	$scope.$on('MSG', function(msg) {
		$scope.mensagem = msg;
	})
	
	$scope.$on('MSG_ERRO', function(erro) {
		$scope.erro = erro;
	});
	
	function obterCursos() {
//		$scope.enderecos = Endereco.jsonpquery();
		Curso.query(
			function(cursos) {
				$scope.cursos = cursos;
			},
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}

	$scope.removeCurso = function(curso) {
		Curso.delete({id: curso.id},
			obterCursos,
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}
	
	obterCursos();
	
})

.controller('CursoController',
		function($scope, $rootScope, $routeParams, $window, Curso, Campus) {
	
	$scope.campus = [];
	
	if($routeParams.cursoId) {
		Curso.get({id: $routeParams.cursoId},
				function(curso) {
					$scope.curso = curso;
				},
				function(erro) {
					$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
					console.log(erro);
				}
			);
	} else {
		$scope.curso = new Curso();
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
			}
		);
	}
	
	$scope.salvaCurso = function() {
		if($scope.curso.id) {
			$scope.curso.$update()
			.then(function() {
				console.log("Sucesso!");
				$window.location.href = "#/cadastros/curso"
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		} else {
			$scope.curso.$save()
			.then(function() {
				console.log("Sucesso!");
				$window.location.href = "#/cadastros/curso"
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		}
	}

	listarCampus();
});