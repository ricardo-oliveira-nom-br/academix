angular.module('academix').controller('CampusListController', function ($scope, Campus) {
	
	$scope.campus = [];
	
	$scope.$on('MSG', function(msg) {
		$scope.mensagem = msg;
	})
	
	$scope.$on('MSG_ERRO', function(erro) {
		$scope.erro = erro;
	});
	
	function obterCampus() {
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

	$scope.removeCampus = function(campus) {
		Campus.delete({id: campus.id},
			obterCampus,
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}
	
	obterCampus();
	
})

.controller('CampusController',
		function($scope, $rootScope, $routeParams, $window, Campus, Endereco) {
	
	if($routeParams.campusId) {
		Campus.get({id: $routeParams.campusId},
				function(campus) {
					$scope.campus = campus;
				},
				function(erro) {
					$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
					console.log(erro);
				}
			);
	} else {
		$scope.campus = new Campus();
	}
	
	$scope.enderecos = [];
	
	function popupEnderecos(){
		Endereco.query(
				function(enderecos) {
					$scope.enderecos = enderecos;
				},
				function(erro) {
					$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
					console.log(erro);
				}
			);
	}
	
	$scope.selecionaEndereco = function(endereco) {
		$scope.campus.endereco = endereco;
	}
	
	$scope.salvaCampus = function() {
		if($scope.campus.id) {
			$scope.campus.$update()
			.then(function() {
				$rootScope.$broadcast('MSG',
					{texto: "Campus adicionado com sucesso!"});
				console.log("Sucesso!");
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		} else {
			$scope.campus.$save()
			.then(function() {
				console.log("Sucesso!");
			}, function(error) {
				$rootScope.$broadcast('MSG_ERRO',
					{texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + error});
				console.log(error);
			});
		}
		$window.location.href = "#/cadastros/campus"
	}
	
	popupEnderecos();

	
});