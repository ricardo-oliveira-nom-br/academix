angular.module('academix').controller('EnderecoListController',
		function ($scope) {
	
	$scope.enderecos = [
	    {
	    	logradouro: "Rua Vergueiro",
	    	cep: "04273100",
	    	bairro: "Vila Firmiano Pinto",
	    	cidade: "São Paulo",
	    	uf: "SP"
	    },
	    {
	    	logradouro: "Rua Marquês de Lages",
	    	cep: "04162001",
	    	bairro: "Vila das Mercês",
	    	cidade: "São Paulo",
	    	uf: "SP"
	    }
	];
});