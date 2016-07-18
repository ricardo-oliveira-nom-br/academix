angular.module('academix').controller('EnderecoListController', function($scope, Endereco) {

	$scope.enderecos = [];
	
	$scope.$on('MSG', function(msg) {
		$scope.mensagem = msg;
	})
	
	$scope.$on('MSG_ERRO', function(erro) {
		$scope.erro = erro;
	});

	function obterEnderecos() {
//		$scope.enderecos = Endereco.jsonpquery();
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

	$scope.removeEndereco = function(endereco) {
		Endereco.delete({id: endereco.id},
			obterEnderecos,
			function(erro) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(erro);
			}
		);
	}
	
	obterEnderecos();

})

.controller('EnderecoController',
		function($scope, $rootScope, $routeParams, $window, Endereco) {
	
	if($routeParams.enderecoId) {
		Endereco.get({id: $routeParams.enderecoId},
				function(endereco) {
					$scope.endereco = endereco;
				},
				function(erro) {
					$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
					console.log(erro);
				}
			);
	} else {
		$scope.endereco = new Endereco();
	}
	
	$scope.salvaEndereco = function() {
		if($scope.endereco.id) {
			$scope.endereco.$update()
			.then(function() {
				$rootScope.$broadcast('MSG',
					{texto: "Endereço adicionado com sucesso!"});
				console.log("Sucesso!");
			}, function(error) {
				$scope.erro = {texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + erro};
				console.log(error);
			});
		} else {
			$scope.endereco.$save()
			.then(function() {
				console.log("Sucesso!");
			}, function(error) {
				$rootScope.$broadcast('MSG_ERRO',
					{texto: "Ocorreu um erro. Informe ao Administrator a seguinte mensagem: " + error});
				console.log(error);
			});
		}
		$window.location.href = "#/cadastros/endereco"
	}

	
});