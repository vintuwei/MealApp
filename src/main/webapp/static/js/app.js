'use strict';

//var App = angular.module('"mealApp"',[]);


angular.module('MealApp', [])
.controller('MealAppController', ['$scope', 'MealAppService', function($scope, MealAppService) {
	
	var _ = this;
    $scope.panel = 'orders_grid';
    $scope.order = { id:null, name: '', restaurant: '',status: '', createdAt: '' };
    
    _.order = { id:null, name: '', restaurant: '',status: '', createdAt: '' };
    _.orders = [];
    _.order_id = null;
    
    _.meal = { id: null, name:'', price: '', createdBy: '', createdAt: '', createdBy: '' };
    _.meals = [];

    _.load_orders = function() {
    	
    	MealAppService.load_orders()
            .then(
				function(d) {
					_.orders = d;
					
					if(_.order.id != null) {
						
						for(var i = 0; i < _.orders.length; i++) {
							
							if(_.orders[i].id == _.order.id) {
								_.meals = _.orders[i].meals;
							}
						} 
					}
				},
				function(errResponse) {
					console.error('Error while fetching Currencies');
				}
            );
    };
    
    _.submit_order = function() {
    	
    	if(_.order.id==null) {
            _.create_order(_.order);
        } else {
            _.update_order(_.order, _.order.id);
        }
        _.reset_order_form();
    };
    
    _.create_order = function(order) {
    	
    	MealAppService.create_order(order)
    	.then(
        _.load_orders,
        	function(errResponse){
        		console.error('Error while creating User.');
        	}
        );
    };
    
    _.edit_order = function(id) {
    	
    	for(var i = 0; i < _.orders.length; i++) {
            if(_.orders[i].id == id) {
               _.order = angular.copy(_.orders[i]);
               break;
            }
        }
    	
    	$scope.panel = 'order_edit';
    }
    
    _.update_order = function(order) {
    	
    	MealAppService.update_order(order)
    	.then(
        _.load_orders,
        	function(errResponse){
        		console.error('Error while creating User.');
        	}
        );
    };
    
    _.view_meals = function(id) {
    	
    	for(var i = 0; i < _.orders.length; i++) {
            if(_.orders[i].id == id) {
            	
               _.meals = _.orders[i].meals;
               _.order_id = id;
               _.order = _.orders[i];
               $scope.order = _.order;
               break;
            }
        }
    	
    	$scope.panel = 'meals_grid';
    };
    
    _.add_meal = function(order_id) {
    	
    	for(var i = 0; i < _.orders.length; i++) {
    		
    		if(_.orders[i].id == order_id) {
            	
                _.order_id = order_id;
                _.order = _.orders[i];
                $scope.order = _.order;
             }
    	}
    	
    	$scope.panel = 'meal_edit';
    }
    
    _.edit_meal = function(id) {
    	
    	for(var i = 0; i < _.orders.length; i++) {
            
    		var meals = _.orders[i].meals;
    		
    		if(meals.length > 0) {
    			
    			for(var x = 0; x < meals.length; x++) {
    				
    				var meal = meals[x];
    				
    				if(meal.id == id)
    					_.meal = meal;
    			}
    		}
        }
    	
    	$scope.panel = 'meal_edit';
    }
    
    _.submit_meal = function() {
    	
    	if(_.meal.id== null) {
            _.create_meal(_.order.id, _.meal);
        } else {
            _.update_meal(_.meal);
        }
        _.reset_meal_form();
    };
    
    _.create_meal = function(order_id, meal) {
    	
    	MealAppService.create_meal(order_id, meal)
    	.then(
        _.load_orders,
        	function(errResponse) {
        		console.error('Error while creating User.');
        	}
        );
    };
    
    _.update_meal = function(meal) {
    	
    	MealAppService.update_meal(meal)
    	.then(
        _.load_orders,
        	function(errResponse){
        		console.error('Error while creating User.');
        	}
        );
    };
    
    _.reset_order_form = function() {
    	
    	_.order = { id: null, name: '', restaurant: '', status: '', createdAt: '' };
    	$scope.orderForm.$setPristine(); //reset Form
    	$scope.panel = 'orders_grid';
    };
    
    _.switch_view = function(view) {
    	
    	$scope.panel = view;
    };

    _.reset_meal_form = function() {
    	
    	_.meal = { id: null, name:'', price: '', createdBy: '', createdAt: '', createdBy: '' };
    	$scope.mealForm.$setPristine(); //reset Form
    	$scope.panel = 'meals_grid';
    }
    
    _.load_orders();
    
}]).factory('MealAppService', ['$http', '$q', function($http, $q){
	
	return {
		
		load_orders: function() {
			return $http.get('/AmpathMealApp/orders')
					.then(
							function(response){
								console.log(response.data);
								return response.data;
							},
							function(errResponse) {
								console.error('Error while fetching orders');
								return $q.reject(errResponse);
							}
					);
		},
		
		create_order: function(order) {
			return $http.post('/AmpathMealApp/order', order)
					.then(
							function(response){
								return response.data;
							}, 
							function(errResponse){
								console.error('Error while creating order');
								return $q.reject(errResponse);
							}
					);
		},
		
		update_order: function(order) {
			
			var id = order.id;
			
			return $http.put('/AmpathMealApp/order/' + id, order)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while updating order');
						return $q.reject(errResponse);
					}
			);
		},
		
		create_meal: function(order_id, meal) {
			
			return $http.post('/AmpathMealApp/meal/create/' + order_id, meal)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while creating meal');
						return $q.reject(errResponse);
					}
			);
		},
		
		update_meal: function(meal) {
			
			var id = meal.id;
			
			return $http.put('/AmpathMealApp/meal/update/' + id, meal)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while updating meal');
						return $q.reject(errResponse);
					}
			);
		}
	}
}]);