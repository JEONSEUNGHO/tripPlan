<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/tripPlan/assets/css/after_header.css" rel="stylesheet">
<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

    
      #map-canvas {
          height: 100%;
          width: 100%;
      }
</style>
</head>
<script>
function initMap() {
    var pointA = document.getElementById('lat').value,
        pointB = document.getElementById('lng').value,
        pointC = document.getElementById('lat1').value,
        pointD = document.getElementById('lng1').value,
        myOptions = {
            zoom: 7,
            center: pointA
        },
        map = new google.maps.Map(document.getElementById('map-canvas'), myOptions),
        // Instantiate a directions service.
        directionsService = new google.maps.DirectionsService,
        directionsDisplay = new google.maps.DirectionsRenderer({
            map: map
        }),
        markerA = new google.maps.Marker({
            position: pointA,
            title: "point A",
            label: "A",
            map: map
        }),
        markerB = new google.maps.Marker({
            position: pointB,
            title: "point B",
            label: "B",
            map: map
        });

    // get route from A to B
    calculateAndDisplayRoute(directionsService, directionsDisplay, pointA, pointB);

}



function calculateAndDisplayRoute(directionsService, directionsDisplay, pointA, pointB) {
    directionsService.route({
        origin: pointA,
        destination: pointB,
        avoidTolls: true,
        avoidHighways: false,
        travelMode: google.maps.TravelMode.TRANSIT
    }, function (response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        } else {
            window.alert('Directions request failed due to ' + status);
        }
    });
}

initMap();
</script>
<body>
<div id="body">
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDenhlxS0ffAWJ13dfpLxLoqcz94fUAL3o&libraries=places&callback=initMap"async defer></script>

<div id="map-canvas"></div>
<div id="directions"></div>

	<c:if test  = "${list > 0 }">
		<c:forEach var="list" items="${board}">
			<input type="text" id="lat" name="routeFrom" value="${list.sb_lat }" />
<label for="routeFrom">From</label><br />
<input type="text" id="lng" name="routeTo" value="${list.sb_lon }" />
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


		</c:forEach>
	</c:if>
	 
</div>
</body>
</html>