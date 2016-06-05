angular.module('academix', []).controller('CampusListController', function CampusListController($scope) {
	$scope.campus = [
	    {
	    	nome: "Ipiranga",
	    	endereco: {
	    		logradouro: "Rua Vergueiro",
		    	cep: "04273100",
		    	bairro: "Vila Firmiano Pinto",
		    	cidade: "São Paulo",
		    	uf: "SP"
	    	},
	    	numero: "7133",
	    	complemento: ""
	    },
	    {
	    	nome: "Vila das Merces",
	    	endereco: {
		    	logradouro: "Rua Marquês de Lages",
		    	cep: "04162001",
		    	bairro: "Vila das Mercês",
		    	cidade: "São Paulo",
		    	uf: "SP"
		    },
		    numero: 1532,
		    complemento: ""
	    }
	];
});