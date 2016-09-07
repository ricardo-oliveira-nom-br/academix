angular.module('academix').controller('ProfessorListController', 
		function ($scope, Professor) {
	
	$scope.professores = [];

	$scope.$on('MSG', function(msg) {
		$scope.mensagem = msg;
	})
	
	$scope.$on('MSG_ERRO', function(erro) {
		$scope.erro = erro;
	});

	function obterProfessores() {
// $scope.professores = Professor.jsonpquery();
		Professor.query(
			function(professores) {
				$scope.professores = professores;
			},
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}

	$scope.removeProfessor = function(professor) {
		Professor.delete({id: professor.id},
			obterProfessores,
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}
	
	obterProfessores();

})

.controller('ProfessorController',
		function($scope, $rootScope, $routeParams, $window, Professor) {
	
	if($routeParams.professorId) {
		Localizacao.get({id: $routeParams.professorId},
				function(professor) {
					$scope.professor = professor;
				},
				function(erro) {
					$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
					console.log(erro);
				}
			);
	} else {
		$scope.professor = new Professor();
	}
	
	$scope.salvaProfessor = function() {
		if($scope.professor.id) {
			$scope.professor.$update()
			.then(function() {
				$rootScope.$broadcast('MSG',
					{texto: "Professor adicionado com sucesso!"});
				console.log("Sucesso!");
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		} else {
			$scope.professor.$save()
			.then(function() {
				console.log("Sucesso!");
			}, function(error) {
				$rootScope.$broadcast('MSG_ERRO',
					{texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + error});
				console.log(error);
			});
		}
		$window.location.href = "#/cadastros/professor"
	}
	
});