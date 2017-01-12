<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="ko" ng-app="angularStart">
<script>
var module = angular.module("angularStart", []);
 
module.controller("MainController", function($scope, $http) {
  
  $scope.getUsers = function(){
    $http({
      method  : 'get',
      url     : 'data.json',
      headers : {'Content-Type': 'application/json; charset=utf-8'} 
    }).success(function(data){
      $scope.user = data;
    });
  };
});
</script>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 
    <title>angularStart</title>
    <meta name="description" content="">
    <meta name="author" content="team.codekin@gmail.com">
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
 
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
    <script src="/index.js"></script>
  </head>
 
  <body>
    <div ng-controller="MainController">
      id : <input type="text" ng-model="user.id" /><br/>
      email : <input type="text" ng-model="user.email" /><br/>
      <button type="button" ng-click="getUsers()">load users</button>
      <div>
        {{user.id}}
      </div>
      <div>
        {{user.email}}
      </div>
    </div>
  </body>
</html>