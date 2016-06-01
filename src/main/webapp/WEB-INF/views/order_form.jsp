<div class="formcontainer">
	<form ng-submit="ctrl.submit_order()" name="orderForm" class="form-horizontal">
	    <input type="hidden" ng-model="ctrl.order.id" />
	    <div class="row">
	        <div class="form-group col-md-12">
	            <label class="col-md-2 control-lable" for="file">Name</label>
	            <div class="col-md-7">
	                <input type="text" ng-model="ctrl.order.name" name="name" class="name form-control input-sm" placeholder="Enter name" required/>
	                <div class="has-error" ng-show="orderForm.$dirty">
	                    <span ng-show="orderForm.name.$error.required">Name is required</span>
	                    <span ng-show="orderForm.name.$invalid">Invalid input</span>
	                </div>
	            </div>
	        </div>
	    </div>
	      
	    
	    <div class="row">
	        <div class="form-group col-md-12">
	            <label class="col-md-2 control-lable" for="file">Restaurant</label>
	            <div class="col-md-7">
	                <input type="text" ng-model="ctrl.order.restaurant" class="form-control input-sm" placeholder="Enter Restaurant" required/>
	            	<div class="has-error" ng-show="orderForm.$dirty">
	                    <span ng-show="orderForm.restaurant.$error.required">Restaurant is required</span>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <div class="row">
	        <div class="form-group col-md-12">
	            <label class="col-md-2 control-lable" for="file">Status</label>
	            <div class="col-md-7">
	                <select ng-model="ctrl.order.status" name="status" class="form-control" required>
	                	<option>Ordered</option>
	                	<option>Delivered</option>
	                	<option>Finalised</option>
					</select>
					<div class="has-error" ng-show="orderForm.$dirty">
	                    <span ng-show="orderForm.status.$error.required">Status is required</span>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <div class="row">
	        <div class="form-actions floatRight">
	            <input type="submit"  value="{{!ctrl.order.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="orderForm.$invalid">
	            <button type="button" ng-click="ctrl.reset_order_form()" class="btn btn-warning btn-sm">Cancel</button>
	        </div>
	    </div>
	</form>
</div>