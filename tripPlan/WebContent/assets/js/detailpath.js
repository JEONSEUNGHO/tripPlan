var directionsDisplay = new google.maps.DirectionsRenderer({ draggable: true });
var directionsService = new google.maps.DirectionsService();
var map;

$(window).load(function() {
    var myOptions = {
        zoom: 9,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: new google.maps.LatLng(37.566535037, 126.9779690)
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    directionsDisplay.setMap(map);
    directionsDisplay.setPanel(document.getElementById("directions"));
    
    $("#routeMode").on("change", function() { calcRoute(); });
    $("#routeGo").on("click", function() { calcRoute(); });
    $("#routeClear").on("click", function() { directionsDisplay.setDirections({ routes: [] }); });
   
   var flightPlanCoordinates = [
    {lat: 37.394253037, lng: 126.9568210126},
    {lat: 37.366037037, lng: 127.1080900}
  ];
  var flightPath = new google.maps.Polyline({
    path: flightPlanCoordinates,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 2
  });

  flightPath.setMap(map);
});


function calcRoute() {
    var request = {
        origin: $("#routeTo").val(),
        destination: $("#routeFrom").val(),
         provideRouteAlternatives: true,		
        travelMode: google.maps.TravelMode[$("#routeMode").val()]
    };
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
         
            directionsDisplay.setDirections(response);
        }
    });
}