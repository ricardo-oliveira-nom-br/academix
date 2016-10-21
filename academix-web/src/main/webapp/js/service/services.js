angular.module('academix.services', ['ngResource'])

.factory('Endereco', function($resource) {
	return $resource('http://localhost:8080/academix-model/api/endereco/:id',{},{
	        jsonpquery: { method: 'JSONP', params: {callback: 'JSON_CALLBACK'}, isArray: true},
	        update: {
			     method : 'PUT' // this method issues a PUT request
			}
        });
})

.factory('Campus', function($resource) {
	return $resource('http://localhost:8080/academix-model/api/campus/:id',{},{
	        jsonpquery: { method: 'JSONP', params: {callback: 'JSON_CALLBACK'}, isArray: true},
	        update: {
			     method : 'PUT' // this method issues a PUT request
			}
        });
})

.factory('Curso', function($resource) {
	return $resource('http://localhost:8080/academix-model/api/curso/:id',{},{
	        jsonpquery: { method: 'JSONP', params: {callback: 'JSON_CALLBACK'}, isArray: true},
	        update: {
			     method : 'PUT' // this method issues a PUT request
			},
			doCampus: { method: 'GET', url: 'http://localhost:8080/academix-model/api/curso/campus/:id', isArray: true}
        });
})

.factory('Disciplina', function($resource) {
	return $resource('http://localhost:8080/academix-model/api/disciplina/:id',{},{
	        jsonpquery: { method: 'JSONP', params: {callback: 'JSON_CALLBACK'}, isArray: true},
	        update: {
			     method : 'PUT' // this method issues a PUT request
			}
        });
})

.factory('Professor', function($resource) {
	return $resource('http://localhost:8080/academix-model/api/professor/:id',{},{
	        jsonpquery: { method: 'JSONP', params: {callback: 'JSON_CALLBACK'}, isArray: true},
	        update: {
			     method : 'PUT' // this method issues a PUT request
			}
        });
})

.factory('Localizacao', function($resource) {
	return $resource('http://localhost:8080/academix-model/api/localizacao/:id',{},{
	        jsonpquery: { method: 'JSONP', params: {callback: 'JSON_CALLBACK'}, isArray: true},
	        update: {
			     method : 'PUT' // this method issues a PUT request
			}
        });
})

.factory('GradeCurricular', function($resource) {
	return $resource('http://localhost:8080/academix-model/api/gradeCurricular/:id',{},{
	        jsonpquery: { method: 'JSONP', params: {callback: 'JSON_CALLBACK'}, isArray: true},
	        update: {
			     method : 'PUT' // this method issues a PUT request
			}
        });
}

);