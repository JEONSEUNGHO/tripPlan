<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>List display/sort/filter using AngularJS & Bootstrap </title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="/tripPlan/assets/css/abc.css">

  
</head>

<body>
<div id="body">
  <html ng-app="planner">  <!-- 앱을 정의하는데 planner란 이름을 사용 -->
  <head>  
    
    <!--angular-->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
    
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.1.js"></script>  
    
    <script src="//code.angularjs.org/1.2.14/angular-animate.min.js"></script>
    
    

    <script src="//rawgit.com/allenhwkim/angularjs-google-maps/master/build/scripts/ng-map.min.js"></script>
    
    <!--bootstrap-->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
 
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  </head>
   
  
  <body>  
  	<!-- 컨트롤러 이름 ctrl -->
    <div class='wrap' ng-controller="ctrl" style="margin-top:120px;margin-left:250px"> 
      
      <div class="splash" ng-cloak="">
        <p>Loading...</p>
      </div>

      <div ng-cloak="">
      

      <div class='option'>
       
      <div class="sub-info">
        <div class='row'>
         <div class="col-md-6">
         
          <button class='btn btn-success'>
            <i class="fa fa-plus-circle" ></i>
            경로생성
          </button>  
           
          <div class="btn-group">
            <label class="btn btn-default" ng-model="sortType" btn-radio="'asc'" popover-placement="bottom" popover="Ascending" popover-trigger="mouseenter">
              <i class="fa fa-chevron-up"></i>
            </label>
        
            <label class="btn btn-default" ng-model="sortType" btn-radio="'desc'" popover-placement="bottom" popover="Descending" popover-trigger="mouseenter">
              <i class="fa fa-chevron-down"></i>
            </label>
            
            <button class='btn btn-default' ng-click="sort(selectedSort)">
              <i class="fa fa-sort-amount-desc" ></i>
              Sort
            </button>  
            
          </div> 
      
 
           
        <select ng-model="orderProperty">
		<option value="b_id" selected>번호</option>
		<option value="b_title">설명</option>
		<option value="b_registertime">날짜</option>
	</select> <!-- 
	<select ng-model="selectedName" ng-options="x for x in sortOptions">
	</select> -->
  
        </div>
          <div class="col-md-3"></div>
           <div class="col-md-3">
     

             <input type="text" ng-model="search" class="form-control" placeholder="Search"/>
             </div>
      
        </div>
          
      </div> 
      </div> 
      
      
    
        <div class='option results' ng-repeat="x in names | orderBy:orderProperty | filter:search">
        <!-- <div class='option results' ng-repeat="plan in filter = (plans | orderBy: orderList: sortingOrder | filter :search)" ng-bind-html="plan | searchfilter:search">
       -->  
           <input type="hidden" ng-model="plans.title"value="zzz" id="gkgk">
          <h2>{{x.b_title}}</h2>
          
          <div class="sub-info">
            
            <div class='cell'>
            <div>
              <i class="fa fa-money"></i>
              £ {{x.b_id}}
            </div>
            <div>
              <i class="fa fa-map-marker"></i>
              {{x.b_title }} 
            </div>
          
            <div>  
              <i class="fa fa-calendar"></i>  {{x.b_registertime}}
            </div> 
            
            <div>
              <i class="fa fa-clock-o"></i>
              {{x.b_maincontents}}
            </div>
          
             
          </div> 
            
          <div class='cell'>
            
            <img src="{{x.b_mainphoto}}" width="600" height="300">
         </div>

            
            <hr>
          <span>
            <button class='btn btn-primary' popover="Load this plan"  ng-click="loadPlan(x)">

              <i class="fa fa-circle-o-notch"></i>
              Load
            </button>
   
          </span>
            
          <span>
            <button class='btn btn-info' popover="Analyse your plan">
              <i class="fa fa-bar-chart"></i>
              Results
            </button> 
          </span>
         
          <span>
            <div class="btn-group" dropdown is-open="status.isopen">
              <button type="button" class="btn btn-default dropdown-toggle" dropdown-toggle ng-disabled="disabled">
                <i class="fa fa-share-alt"></i> Share <span class="caret"></span>
              </button>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#"><i class="fa fa-facebook"></i>Facebook</a></li>
                <li><a href="#"><i class="fa fa-twitter"></i>Twitter</a></li>
                <li><a href="#"><i class="fa fa-envelope"></i>e-mail</a></li>
              </ul>
            </div>

          </span>
         </div>
          
    </div>

   </div>
    
  </body>
</html>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="/tripPlan/assets/js/abc.js"></script>
</div>
</body>
</html>
