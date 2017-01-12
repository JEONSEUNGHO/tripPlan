$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".timeline"); //Fields wrapper
    var add_button      = $(".add_root_btn"); //Add button ID
    var origin_input="";
    var x = 1; //initlal text box count
    $('.calculate-route').click(function() {
    	var lon = document.getElementById('lon').value;
    	var lat = document.getElementById('lat').value;
    	
    	for (var i = 0; i < lon.length; i++) {
    		if (i == (lon.length - 1)) {
    			return;
    		}
    		
    		document.getElementById('originInput').value = lon[i] + "," + lat[i];
    		document.getElementById('destinationInput').value = lon[i + 1] + "," + lat[i + 1];
    		
    		directionsService.route({
  		      origin: document.getElementById('originInput').value,											//출발지의 정보 파라미터 값 가져옴
  		      destination: document.getElementById('destinationInput').value,								//도착지의 정보 파라미터 값 가져옴
  		      provideRouteAlternatives: true,												//대체경로를 보여 줄 것인지 결정.
  		      travelMode: google.maps.TravelMode.TRANSIT									//어떤 교통 매체 이용할 건지 결정.
  		    }, function(response, status) {
  		      if (status === google.maps.DirectionsStatus.OK) {								//status가 구글 맵의 길찾기 경로가 있다면
  		    	  alert(response.routes);
  		    	  /*for (var i = 0; i < response.routes.length; i++) {						
  						new google.maps.DirectionsRenderer({								//새로운 경로를 가져온다.
  						    map: map,														//map에는 위에 선언된 map변수를 가져와 담는다.
  						    directions: response,											//경로에 response정보를 담는다.
  						    routeIndex: i	//,												//대체 경로들을 담아서 보여준다.
  						    //polylineOptions: { strokeColor: color[i],strokeOpacity:1.0},	//라인 색깔을 white로 잡아줌
  							//markerOptions : {icon:myIcon}									//마커는 내가 지정한 마커로.
  						  });*/
  						directionsDisplay.setDirections(response);							//directionDisplay에 경로들을 붙여준다(이게 없으면 directions panel안 붙음).
  		    	  
  		      } else {
  		        window.alert('Directions request failed due to ' + status);
  		      }
  		    });
    		
    	}
    });
    $(document).on('click',".add_root_btn", function() {
    	
    	if (x < max_fields)  x++;
         
         
         var html = "";
         html = html + '<li class="timeline-milestone is-completed timeline-start">';
         	html = html + '<div class="timeline-action">';
         		html = html + '<table border="1" width="300" height="300">';
         			html = html + '<tr>';
         				html = html + '<td width="50" colspan="1">여행지</td><td width="250" colspan="5"><input type="text" id="pac-input" class="AutoClass" name="sb_destination" required>';
         					html = html + '<input type="text" class="lat" id="lat" name="sb_lat"/>';
         					html = html + '<input type="text" class="lon" id="lon" name="sb_lon"/>';
         					html = html + '</td>';
         					html = html + '</tr>';
         				html = html + '<tr>';
         				html = html + '<td width="50" colspan="1">여행일자</td><td width="250" colspan="5"><input type="date" name="sb_tripdate" required ></td>';
     					html = html + '</tr>';
     					html = html + '<tr>';
     				html = html + '<td width="50" colspan="1">소제목</td><td width="250" colspan="5"><input type="text" name="sb_subtitle" placeholder="제목을 입력하세요." required></td>';
         				html = html + '</tr>';
         					html = html + '<tr>';
         				html = html + '<td width="50" colspan="1">내용</td><td width="250" colspan="5"><textarea rows="10" cols="50" name="sb_subcontents" placeholder="내용을 입력하세요.." required></textarea></td>';
         			html = html + '</tr>';
         			html = html + '<tr>';
         				html = html + '<td width="50" colspan="1">사진 등록</td';
         				html = html + '<td width="50" colspan="1"><input type="file" name="sb_photo1"></td>';
         			html = html + '<td width="50" colspan="1"><input type="file" name="sb_photo1"></td>';
         			html = html + '<td width="50" colspan="1"><input type="file" name="sb_photo1"></td>';
         				html = html + '<td width="50" colspan="1"><input type="file" name="sb_photo1"></td>';
         				html = html + '<td width="50" colspan="1"><input type="file" name="sb_photo1"></td>';
         				html = html + '</tr>';
         				html = html + '<tr>';
         				html = html + '<td width="50" colspan="1">교통비</td><td width="50" colspan="1"><input type="text" name="sb_tcharge"  pattern="[0-9]" required></td>';
         				html = html + '<td width="50" colspan="1">식비</td><td width="50" colspan="1"><input type="text" name="sb_fcharge" pattern="[0-9]" required></td>';
         			html = html + '<td width="50" colspan="1">숙박비</td><td width="50" colspan="1"><input type="text" name="sb_rcharge" pattern="[0-9]" required></td>';
         			html = html + '</tr>';
         				html = html + '</table>';
         			html = html + '<input type="hidden" name="sb_lat">';
         		html = html + '<input type="hidden" name="sb_lng">';
         	html = html + '</div>';
         html = html + '</li>';		
         $(wrapper).append(html);
     });
    
    //출발지 이벤트
    $(document).on('click', '.AutoClass', function() {

    	 var map = new google.maps.Map(document.getElementById('map'), {
    		    center: {lat: -33.8688, lng: 151.2195},
    		    zoom: 13,
    		    mapTypeId: google.maps.MapTypeId.ROADMAP
    		  });
		var input = $(this)[0];
		var searchBox = new google.maps.places.SearchBox(input);

		  // Bias the SearchBox results towards current map's viewport.
		  map.addListener('bounds_changed', function() {
		    searchBox.setBounds(map.getBounds());
		  });

		  var markers = [];
		  // [START region_getplaces]
		  // Listen for the event fired when the user selects a prediction and retrieve
		  // more details for that place.
		  searchBox.addListener('places_changed', function() {
		    var places = searchBox.getPlaces();

		    if (places.length == 0) {
		      return;
		    }

		    // Clear out the old markers.
		    markers.forEach(function(marker) {
		      marker.setMap(null);
		    });
		    markers = [];

		    // For each place, get the icon, name and location.
		    var bounds = new google.maps.LatLngBounds();
		    places.forEach(function(place) {
		      var icon = {
		        url: place.icon,
		        size: new google.maps.Size(71, 71),
		        origin: new google.maps.Point(0, 0),
		        anchor: new google.maps.Point(17, 34),
		        scaledSize: new google.maps.Size(25, 25)
		      };

		      // Create a marker for each place.
		      markers.push(new google.maps.Marker({
		        map: map,
		        icon: icon,
		        title: place.name,
		        position: place.geometry.location
		      }));
		      var lat = place.geometry.location.lat();
		      var lng = place.geometry.location.lng();
		      alert(lat);
		      $(this).siblings().val(lat);
		      if (place.geometry.viewport) {
		        // Only geocodes have viewport.
		        bounds.union(place.geometry.viewport);
		        
		      } else {
		        bounds.extend(place.geometry.location);
		      }
		    });
		    map.fitBounds(bounds);
		  });
		  // [END region_getplaces]
		});
});

