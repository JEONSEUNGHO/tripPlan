
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta name="robots" content="noindex, nofollow">
  <meta name="googlebot" content="noindex, nofollow">

  
  

  
  
  

  

  <script type="text/javascript" src="//code.jquery.com/jquery-1.7.1.js"></script>

  

  
    <link rel="stylesheet" type="text/css" href="/css/normalize.css">
  

  

  
    <link rel="stylesheet" type="text/css" href="/css/result-light.css">
  

  
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDenhlxS0ffAWJ13dfpLxLoqcz94fUAL3o&libraries=places&callback=initMap"async defer></script>
  

  <style type="text/css">
    #map_canvas{
    width: 60%;
    height: 400px;
    border: 1px solid black;
    float: left;
}
#directions {
    width: 38%;
    float: right; 
}
body {
    font-size: 12px;
}
  </style>

  <title>Google Maps Routing Options</title>

  
    




<script type='text/javascript'>//<![CDATA[
$(function(){
var directionsDisplay = new google.maps.DirectionsRenderer({ draggable: true });
var directionsService = new google.maps.DirectionsService();
var map;

$(window).load(function() {
    var myOptions = {
        zoom: 10,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: new google.maps.LatLng(35.270, -80.837)
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    directionsDisplay.setMap(map);
    directionsDisplay.setPanel(document.getElementById("directions"));
    
    $("#routeMode").on("change", function() { calcRoute(); });
    $("#routeGo").on("click", function() { calcRoute(); });
    $("#routeClear").on("click", function() { directionsDisplay.setDirections({ routes: [] }); });
    
});


function calcRoute() {
    var request = {
        origin: $("#routeFrom").val(),
        destination: $("#routeTo").val(),
        provideRouteAlternatives: true,
        travelMode: google.maps.TravelMode[$("#routeMode").val()]
    };
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
        	 for (var i = 0; i < response.routes.length; i++) {						
					new google.maps.DirectionsRenderer({								//새로운 경로를 가져온다.
					    map: map,														//map에는 위에 선언된 map변수를 가져와 담는다.
					    directions: response,											//경로에 response정보를 담는다.
					    routeIndex: i													//대체 경로들을 담아서 보여준다.
					  });
	    	  }
            directionsDisplay.setDirections(response);
        }
    });
}
});//]]> 

</script>

  
</head>

<body>
  <input type="text" id="routeFrom" name="routeFrom" value="700 n tryon st, charlotte nc" />
<label for="routeFrom">From</label><br />
<input type="text" id="routeTo" name="routeTo" value="Huntersville, NC" />
<label for="routeTo">To</label><br />
<select id="routeMode" name="routeMode">
    <option value="DRIVING">Driving</option>
    <option value="WALKING">Walking</option>
    <option value="BICYCLING">Bicycling</option>
    <option value="TRANSIT">Transit</option>
</select>
<label for="routeMode">Mode</label><br />
<div class="textcenter">
    <button id="routeGo">Route</button>
    <button id="routeClear">Clear Route</button>
</div>
<div id="map_canvas"></div>
<div id="directions"></div>


  
 <!--  <script>
  // tell the embed parent frame the height of the content
  if (window.parent && window.parent.parent){
    window.parent.parent.postMessage(["resultsFrame", {
      height: document.body.getBoundingClientRect().height,
      slug: "gHK7s"
    }], "*")
  }
</script> -->

</body>

</html>

