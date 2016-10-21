angular.module('academix').controller('DisciplinaListController', function($scope, Disciplina) {

	$scope.disciplinas = [];
	
	$scope.$on('MSG', function(msg) {
		$scope.mensagem = msg;
	})
	
	$scope.$on('MSG_ERRO', function(erro) {
		$scope.erro = erro;
	});

	function obterDisciplinas() {
//		$scope.disciplinas = Disciplina.jsonpquery();
		Disciplina.query(
			function(disciplinas) {
				$scope.disciplinas = disciplinas;
			},
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}

	$scope.removeDisciplina = function(disciplina) {
		Disciplina.delete({id: disciplina.id},
			obterDisciplinas,
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}
	
	obterDisciplinas();

})

.controller('DisciplinaController',
		function($scope, $rootScope, $routeParams, $window, Disciplina) {
	
	if($routeParams.disciplinaId) {
		Disciplina.get({id: $routeParams.disciplinaId},
				function(disciplina) {
					$scope.disciplina = disciplina;
				},
				function(erro) {
					$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
					console.log(erro);
				}
			);
	} else {
		$scope.disciplina = new Disciplina();
	}
	
	$scope.salvaDisciplina = function() {
		if($scope.disciplina.id) {
			$scope.disciplina.$update()
			.then(function() {
				console.log("Sucesso!");
				$window.location.href = "#/cadastros/disciplina";
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		} else {
			$scope.disciplina.$save()
			.then(function() {
				console.log("Sucesso!");
				$window.location.href = "#/cadastros/disciplina";
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		}
	}

	
});