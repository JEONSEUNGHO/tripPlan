
var app = angular.module('planner', ['ui.bootstrap','ngAnimate']);

app.factory('utils',function(){  //팩토리 만들어줌. 객체 리터럴을 팩토리안에서 생성.
  return {
    remove:function(array,value){
  		var index = array.indexOf(value);
  		array.splice(index, 1);
      return array;
    }
  };
});

 
//controller
app.controller('ctrl', function ($scope,utils,$http) {//모듈 생성 , 의존성 주입을 통해서 angular에게 필요한 서비스 utils가 있다고 알려줌.
  
  $scope.sortType = 'asc';
	$scope.sortingOrder = false;
  $scope.selectedSort = $scope.sortType;
  $scope.search = "";
  $scope.showMap = true;
 
 
  $http.get("http://localhost:8088/tripPlan/tiles/path")//db의 내용을 json형식으로 받아옴.
  .success(function (response) {$scope.names = response.board;});//json의 내용을 names에 담았다.

  
  $scope.orderProperty = "b_title"; // 정렬 기본 값을 b_title로 잡음.
  
  



$scope.loadPlan = function(x){
    $location.path('/tripPlan/tiles/pathContents.do?b_id={{x.b_id}}');
  };
  
  
  
  
});
