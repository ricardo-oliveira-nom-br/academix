angular.module('academix').controller('GradeCurricularListController',
		function ($scope) {
	
	$scope.grades = [
	    {
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
	    {
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
		    semestre: 2
	    },
	    {
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
	    {
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
		    semestre: 2
	    }
	];
});