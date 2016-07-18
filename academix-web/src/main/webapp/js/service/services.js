angular.module('academix.services', ['ngResource'])
.factory('Endereco', function($resource) {
	return $resource('http://localhost:8080/academix-model/api/enderecos/:id',{},{
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
			}
        });
});