angular.module('academix')

.controller('EnderecoListController', function($scope, Endereco) {

	$scope.enderecos = [];

	function obterEnderecos() {
//		$scope.enderecos = Endereco.jsonpquery();
		Endereco.query(
			function(enderecos) {
				$scope.enderecos = enderecos;
			},
			function(erro) {
				console.log(erro);
			}
		);
	}

	$scope.removeEndereco = function(endereco) {
		Endereco.delete({id: endereco.id},
			obterEnderecos,
			function(erro) {
				console.log(erro);
			}
		);
	}
	
	obterEnderecos();

})

.controller('EnderecoController',
		function($scope, $routeParams, $window, Endereco) {
	
	if($routeParams.enderecoId) {
		Endereco.get({id: $routeParams.enderecoId},
				function(endereco) {
					$scope.endereco = endereco;
				},
				function(erro) {
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
				console.log("Sucesso!");
			}, function(error) {
				console.log(error);
			});
		} else {
			$scope.endereco.$save()
			.then(function() {
				console.log("Sucesso!");
			}, function(error) {
				console.log(error);
			});
		}
		$window.location.href = "#/cadastros/endereco"
	}

	
});