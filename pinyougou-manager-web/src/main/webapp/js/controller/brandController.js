//在分离服务层后，控制层中需要将服务名以参数的形式传入才能被调用
    app.controller("brandController",function($scope,$http,$controller,brandService){

        //继承
        //通过$scope:$scope 来传递
        $controller("baseController",{$scope:$scope});

    	$scope.findAll = function(){
    		//封装ajax来调用查询所用的品牌的方法
    		brandService.findAll().success(
    				function(data){
    					$scope.list = data;
    				}
    			);
    	}
    	
    	//获取当前页的数据记录和总的条数
    	$scope.findPage = function(pageNum,pageSize) {
    		brandService.findPage(pageNum,pageSize).success(
    				function(data) {
    					$scope.list = data.rows;  //当前页的数据记录
    					$scope.paginationConf.totalItems = data.total;	//总的数据条数
    				}
    			);
    	}

    	//添加品牌
    	$scope.save = function() {
    		var object = null;
    		if($scope.entity.id != null) {
    			object = brandService.update($scope.entity);
    		}else {
                object = brandService.add($scope.entity);
            }

    		object.success(
    				function(data) {
    					if(data.success) {
    						$scope.reloadList();
    					}else {
    						alter(data.msg);
    					}
    				}

    			);
    	}

    	//查询
    	$scope.findOne = function(id) {
    		brandService.findOne(id).success(
    				function(data) {
    					$scope.entity = data;
    				}
    			);
    	}

    	

		$scope.dete = function() {
			brandService.dete($scope.selectIds).success(
					function(data) {
    					if(data.success) {
    						$scope.reloadList();
    					}else {
    						alter(data.msg);
    					}
    				}
				);
		}
		
		$scope.searchEntity = {};
		$scope.search = function(pageNum,pageSize) {
			brandService.search(pageNum,pageSize,$scope.searchEntity).success(
				function(data) {
					$scope.list = data.rows;  //当前页的数据记录
					$scope.paginationConf.totalItems = data.total;	//总的数据条数
				}
			);
		}


    });