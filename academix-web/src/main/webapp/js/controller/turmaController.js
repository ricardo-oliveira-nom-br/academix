angular.module('academix').controller('TurmaListController', 
		function ($scope) {
	
	$scope.turmas = [
	    {
	    	gradeCurricular: {
		    	campus: {
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
			    curso: {
			    	nome: "Ciência da computação",
			    },
			    ano: 2015,
			    semestre: 1
		    },
	    	sigla: "1BPCN",
	    },
	    {
	    	gradeCurricular: {
		    	campus: {
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
			    curso: {
			    	nome: "Ciência da computação",
			    },
			    ano: 2016,
			    semestre: 1
		    },	    	
	    	sigla: "2BCPN",
	    }
	];
});