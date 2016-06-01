<div class="tablecontainer">
	<table class="table table-hover">
	    <thead>
	        <tr>
	        	<th>ID</th>
	            <th>Name</th>
	            <th>Restaurant</th>
	            <th>Status</th>
	            <th>Date</th>
	            <th width="20%"></th>
	        </tr>
	    </thead>
	    <tbody>
	        <tr ng-repeat="o in ctrl.orders">
	        	<td><span ng-bind="o.id"></span></td>
	        	<td><span ng-bind="o.name"></span></td>
	        	<td><span ng-bind="o.restaurant"></span></td>
	        	<td><span ng-bind="o.status"></span></td>
	        	<td><span ng-bind="o.createdAt | date:'yyyy-MM-dd hh:mm:ss'"></span></td>
	            <td>
	            	<a href="#" class="inline" style="margin-left: 10px;" ng-click="ctrl.edit_order(o.id)">Edit</a>
	            	<a href="#" class="inline" style="margin-left: 10px;" ng-click="ctrl.view_meals(o.id)">View Meals</a>
	            	<a href="#" class="inline" style="margin-left: 10px;" ng-click="ctrl.add_meal(o.id)" ng-class="{'hide' : o.status == 'Finalised'}">Add Meal</a>
	            </td>
	        </tr>
		</tbody>
	</table>
</div>