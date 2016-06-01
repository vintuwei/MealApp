<div class="formcontainer">
	<form ng-submit="ctrl.submit_meal()" name="mealForm" class="form-horizontal">
	    <input type="hidden" ng-model="ctrl.meal.id" />
	    <input type="hidden" ng-model="ctrl.order_id" />
	    
	    <div class="row">
	        <div class="form-group col-md-12">
	            <label class="col-md-2 control-lable" for="file">Name</label>
	            <div class="col-md-7">
	                <input type="text" ng-model="ctrl.meal.name" name="name" class="name form-control input-sm" placeholder="Enter name" required/>
	                <div class="has-error" ng-show="mealForm.$dirty">
	                    <span ng-show="mealForm.name.$error.required">Name is required</span>
	                    <span ng-show="mealForm.name.$invalid">Invalid input</span>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    <div class="row">
	        <div class="form-group col-md-12">
	            <label class="col-md-2 control-lable" for="file">Price</label>
	            <div class="col-md-7">
	                <input type="text" ng-model="ctrl.meal.price" class="form-control input-sm" placeholder="Enter Price" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" required/>
	            	<div class="has-error" ng-show="mealForm.$dirty">
	                    <span ng-show="mealForm.price.$error.required">Price is required</span>
	                    <span ng-show="mealForm.name.$invalid">Invalid input</span>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    <div class="row">
	        <div class="form-group col-md-12">
	            <label class="col-md-2 control-lable" for="file">Ordered By</label>
	            <div class="col-md-7">
	                <input type="text" ng-model="ctrl.meal.createdBy" class="form-control input-sm" placeholder="Enter your name" required/>
	            	<div class="has-error" ng-show="mealForm.$dirty">
	                    <span ng-show="mealForm.createdBy.$error.required">Field is required</span>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    <div class="row">
	        <div class="form-actions floatRight">
	            <input type="submit"  value="{{!ctrl.meal.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="mealForm.$invalid">
	            <button type="button" ng-click="ctrl.reset_meal_form()" class="btn btn-warning btn-sm">Cancel</button>
	        </div>
	    </div>
	</form>
</div>