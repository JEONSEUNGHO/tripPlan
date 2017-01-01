<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>폼 추가/삭제 예제</title>
<script type="text/javascript">
var directionDisplay;
var directionsService = new google.maps.DirectionsService();
var map;

function initialize() {
    
    directionsDisplay = new google.maps.DirectionsRenderer();
    var center = new google.maps.LatLng(0, 0);
    var myOptions = {
        zoom: 7,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: center
    }

    map = new google.maps.Map(document.getElementById("map-canvas"), myOptions);
    directionsDisplay.setMap(map);

    var start = "Yamuna Nagar, Haryana, India";
    var end = "New Delhi, India";
    var method = 'DRIVING';
    var request = {
        origin: start,
        destination: end,
        travelMode: google.maps.DirectionsTravelMode[method],
        provideRouteAlternatives: true
    };

    directionsService.route(request, function (response, status) {

        if (status == google.maps.DirectionsStatus.OK) {

            var routesSteps = [];
            var routes = response.routes;
            var colors = ['red', 'green', 'blue', 'orange', 'yellow', 'black'];

            for (var i = 0; i < routes.length; i++) {

                new google.maps.DirectionsRenderer({
                    map: map,
                    directions: response,
                    routeIndex: i,
                    polylineOptions: {

                        strokeColor: colors[i],
                        strokeWeight: 4,
                        strokeOpacity: .3
                    }
                });

                var steps = routes[i].legs[0].steps;
                var stepsCoords = [];

                for (var j = 0; j < steps.length; j++) {

                    stepsCoords[j] = new google.maps.LatLng(steps[j].start_location.lat(), steps[j].start_location.lng());

                    new google.maps.Marker({
                        position: stepsCoords[j],
                        map: map,
                        icon: {
                            path: 'M-20,0a20,20 0 1,0 40,0a20,20 0 1,0 -40,0',
                            scale: .5,
                            fillColor: colors[i],
                            fillOpacity: .3,
                            strokeWeight: 0
                        },
                        title: steps[j].maneuver
                    });
                }

                routesSteps[i] = stepsCoords;
            }

            // Here is your array of routes steps coordinates
            console.log('routesSteps', routesSteps);
        }
    });
}

initialize();
</script>
</head>
<body>
<div id="map-canvas"></div>
</body>
</html>
