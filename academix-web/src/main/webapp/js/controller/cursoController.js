angular.module('academix', []).controller('CursoListController', function CursoListController($scope) {
	$scope.cursos = [
	    {
	    	nome: "Ciência da computação",
	    },
	    {
	    	nome: "Sistemas de Informação",
	    }
	];
});