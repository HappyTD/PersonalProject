

//抽取出控制层公共的部分
app.controller("baseController",function($scope){

	//分页组件配置
	$scope.paginationConf = {
		 currentPage: 1, 		//当前页数
		 	 totalItems: 10, 		//总的条数纪录
		 	 itemsPerPage: 10, 		//每页显示多少条记录数
		 	 perPageOptions: [10, 20, 30, 40, 50], 
		 	 onChange: function(){ 
		 	        $scope.reloadList();//重新加载 
		 	 } 
	}

	//刷新品牌列表
	$scope.reloadList = function(){
		//angularjs中使用$scope去调用方法
		$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	}

	//获取选中的ID
	$scope.selectIds = [];

	$scope.selectOption = function($event,id) {
		if($event.target.checked) {
			$scope.selectIds.push(id);
		}else {
			var index = $scope.selectIds.indexOf(id);
			$scope.selectIds.splice(index,1);
		}
	}

	$scope.jsonToString = function(jsonStr,key){
		var json  = JSON.parse(jsonStr);
		var value = "";
		for(var i=0;i<json.length;i++) {
			if(i>0){
				value +=","
			}
			value += json[i][key];
		}

		return value;
	}
	
});
