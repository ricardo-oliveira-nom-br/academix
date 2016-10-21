angular.module('academix').controller('LocalizacaoListController', 
		function ($scope, Localizacao) {
	
	$scope.localizacoes = [];

	$scope.$on('MSG', function(msg) {
		$scope.mensagem = msg;
	})
	
	$scope.$on('MSG_ERRO', function(erro) {
		$scope.erro = erro;
	});

	function obterLocalizacoes() {
// $scope.enderecos = Endereco.jsonpquery();
		Localizacao.query(
			function(localizacoes) {
				$scope.localizacoes = localizacoes;
			},
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}

	$scope.removeLocalizacao = function(localizacao) {
		Localizacao.delete({id: localizacao.id},
			obterLocalizacoes,
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}
	
	obterLocalizacoes();

})

.controller('LocalizacaoController',
		function($scope, $rootScope, $routeParams, $window, Localizacao, Campus) {
	
	$scope.campus = [];
	
	if($routeParams.localizacaoId) {
		Localizacao.get({id: $routeParams.localizacaoId},
				function(localizacao) {
					$scope.localizacao = localizacao;
				},
				function(erro) {
					$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
					console.log(erro);
				}
			);
	} else {
		$scope.localizacao = new Localizacao();
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
	
	$scope.salvaLocalizacao = function() {
		if($scope.localizacao.id) {
			$scope.localizacao.$update()
			.then(function() {
				console.log("Sucesso!");
				$window.location.href = "#/cadastros/localizacao"
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		} else {
			$scope.localizacao.$save()
			.then(function() {
				console.log("Sucesso!");
				$window.location.href = "#/cadastros/localizacao"
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		}
	}
	
	listarCampus();
	
});