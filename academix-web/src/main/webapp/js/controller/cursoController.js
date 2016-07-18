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
		function($scope, $rootScope, $routeParams, $window, Curso) {
	
	if($routeParams.campusId) {
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
	
	$scope.salvaCurso = function() {
		if($scope.curso.id) {
			$scope.curso.$update()
			.then(function() {
				$rootScope.$broadcast('MSG',
					{texto: "Curso adicionado com sucesso!"});
				console.log("Sucesso!");
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		} else {
			$scope.curso.$save()
			.then(function() {
				console.log("Sucesso!");
			}, function(error) {
				$rootScope.$broadcast('MSG_ERRO',
					{texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + error});
				console.log(error);
			});
		}
		$window.location.href = "#/cadastros/curso"
	}

	
});