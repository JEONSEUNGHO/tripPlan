
var app = angular.module('planner', ['ui.bootstrap','ngAnimate','ngMap']);

app.factory('utils',function(){
  return {
    remove:function(array,value){
  		var index = array.indexOf(value);
  		array.splice(index, 1);
      return array;
    }
  };
});

 
//controller
app.controller('ctrl', function ($scope,utils) {
  $scope.orderList = 'title';
  $scope.sortType = 'asc';
	$scope.sortingOrder = false;
  $scope.selectedSort = $scope.sortType;
  $scope.search = "";
  $scope.showMap = true;

  
  $scope.plans = [
        {id:1,cost:300,title:'London weekend break',created:"2014-05-01",days:2,people:2,
         location:{country:'England',city:'London'}},
        {id:2,cost:1664,title:'Summer holiday',created:"2014-12-01",days:14,people:6,
         location:{country:'Spain',city:'Madrid'}},
        {id:3,cost:144,title:'Business trip',created:"2015-03-01",days:4,people:1,
         location:{country:'Scotland',city:'Glasgow'}},
        {id:4,cost:225,title:'City break',created:"2015-01-13",days:3,people:2,
         location:{country:'Czech Republic',city:'Prague'}}
			];  

  $scope.sortOptions = Object.keys($scope.plans[0]);
  
  
  utils.remove($scope.sortOptions,'location');
  utils.remove($scope.sortOptions,'id');
  
  
  
  
  
  $scope.sort = function(value){
		
    if($scope.sortType == 'desc'){
      $scope.sortingOrder = true;
    }else{
       $scope.sortingOrder = false;
    }
    
    $scope.orderList = value;
    
  };
  
  $scope.loadPlan = function(plan){
    alert("Loading plan : "+plan.id);
  };
  
  $scope.deletePlan = function(plan){
    var id = plan.id;
    angular.forEach($scope.plans, function(value, key) {
    if($scope.plans[key].id === id) {
        $scope.plans.splice(key,1);
        return false;
    }
});
      
  };


  
});