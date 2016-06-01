<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>  
		<title>Ampath MealApp</title>  
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		
	</head>
	<body ng-app="MealApp" class="ng-cloak">
		<div class="generic-container" ng-controller="MealAppController as ctrl">
			<div class="panel panel-default">
				<div class="panel-heading"><span class="lead">Meal App</span></div>
			</div>
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading" ng-class="{'hide' : panel != 'orders_grid'}">
					<button type="button" ng-click="ctrl.switch_view('order_edit')" class="btn btn-success">New Order</button>
				</div>
				
				<div ng-class="{'hide' : order.status == 'Finalised'}">
					<div class="panel-heading" ng-class="{'hide' : panel != 'meals_grid'}">
						<button type="button" ng-click="ctrl.switch_view('meal_edit')" class="btn btn-success" >New Meal</button>
						<button type="button" ng-click="ctrl.switch_view('orders_grid')" class="btn btn-success">Show Orders</button>
					</div>
				</div>
				
				<div ng-class="{'hide' : order.status != 'Finalised'}">
					<div class="panel-heading" ng-class="{'hide' : panel != 'meals_grid'}">
						<button type="button" ng-click="ctrl.switch_view('orders_grid')" class="btn btn-success">Show Orders</button>
					</div>
				</div>
				
				<div ng-switch on="panels">
					<div ng-class="{'hide' : panel != 'orders_grid'}">
						<jsp:include page="orders_grid.jsp"/>
					</div>
					<div ng-class="{'hide' : panel != 'order_edit'}">
						<jsp:include page="order_form.jsp"/>
					</div>
					<div ng-class="{'hide' : panel != 'meal_edit'}"> <!-- Meal Edit -->
						<jsp:include page="meal_form.jsp"/>
					</div>
					<div ng-class="{'hide' : panel != 'meals_grid'}"> <!-- Meal Grid -->
						<jsp:include page="meals_grid.jsp"/>
					</div>
				</div>
				
			</div>
		</div>
    	
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
		<script src="<c:url value='/static/js/app.js' />"></script>
	</body>
</html>