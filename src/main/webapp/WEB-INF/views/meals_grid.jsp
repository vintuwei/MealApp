<div class="tablecontainer">
	<table class="table table-hover">
	    <thead>
	        <tr>
	        	<th>ID</th>
	            <th>Name</th>
	            <th>Price</th>
	            <th>Ordered By</th>
	            <th>Date</th>
	            <th width="20%"></th>
	        </tr>
	    </thead>
	    <tbody>
	        <tr ng-repeat="m in ctrl.meals">
	        	<td><span ng-bind="m.id"></span></td>
	        	<td><span ng-bind="m.name"></span></td>
	        	<td><span ng-bind="m.price"></span></td>
	        	<td><span ng-bind="m.createdBy"></span></td>
	        	<td><span ng-bind="m.createdAt | date:'MM/dd/yyyy hh:mm:ss'"></span></td>
	        	<td>
	            	<a href="#" class="inline" ng-click="ctrl.edit_meal(m.id)">Edit</a>
	            </td>
	        </tr>
		</tbody>
	</table>
</div>