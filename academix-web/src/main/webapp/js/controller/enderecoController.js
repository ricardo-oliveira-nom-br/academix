angular.module('academix')

.controller('EnderecoListController',
	function ($scope) {
	
	$scope.enderecos = [
	    {
	    	id: 1,
	    	logradouro: "Rua Vergueiro",
	    	cep: "04273100",
	    	bairro: "Vila Firmiano Pinto",
	    	cidade: "São Paulo",
	    	uf: "SP"
	    },
	    {
	    	id: 2,
	    	logradouro: "Rua Marquês de Lages",
	    	cep: "04162001",
	    	bairro: "Vila das Mercês",
	    	cidade: "São Paulo",
	    	uf: "SP"
	    }
	];
	
	function obterEnderecos() {
		$.ajax({
			url: "http://localhost:8080/academix-model/rest/alunos",
			dataType: "json"
		}).done(function(list){
			$scope.enderecos = list;
			alert("Success! " + msg);
		}).fail(function(jqHXR, textStatus){
			alert("Oh, no! " + textStatus);
		});
	}
	//obterEnderecos();
	
})

.controller('EnderecoController',
	function ($scope, $routeParams) {
	
	if($routeParams.id) {
		switch($routeParams.id) {
		case "1":
			$scope.endereco = {
		    	id: 1,
		    	logradouro: "Rua Vergueiro",
		    	cep: "04273100",
		    	bairro: "Vila Firmiano Pinto",
		    	cidade: "São Paulo",
		    	uf: "SP"
		    };
			break;
		case "2":
			$scope.endereco = {
		    	id: 2,
		    	logradouro: "Rua Marquês de Lages",
		    	cep: "04162001",
		    	bairro: "Vila das Mercês",
		    	cidade: "São Paulo",
		    	uf: "SP"
		    };
			break;
		}
	}
	
	$scope.salvaEndereco = function() {
		
	}
});