dessribe('EnderecoListController', function() {
	
	beforeEach(module('academix'));
	
	it('should create a `enderecos` model with 2 enderecos', inject(function($controller) {
		var scope = {};
		var ctrl = new PhoneListController(scope);
		
		expect(scope.enderecos.length).toBe(2);
	}));
	
});