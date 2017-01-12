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
         		html = html + '<table border="1" width="400" height="400">';
         			html = html + '<tr height="50">';
         				html = html + '<td width="50" colspan="1">여행지</td>';
         				html = html + '<td width="150" colspan="2">';
         					html = html + '<input id="originInput" class="originInputClass controls" required="required" type="text" name="sb_lat" placeholder="출발지를 입력해 주세요."><br/>';
         					html = html + '<a id="originInput-link" href="#">Get my position</a>';
         					html = html + '<input type="hidden" name="lon[]"/><input type="hidden" name="lat[]"/>';
         				html = html + '</td>';
         				html = html + '<td width="150" colspan="2">';
     					html = html + '<input id="destinationInput" class="destinationInputClass controls" required="required" type="text" name="sb_lat" placeholder="도착지를 입력해 주세요."><br/>';
     					html = html + '<a id="originInput-link" href="#">Get my position</a>';
     				html = html + '</td>';
         				html = html + '<td colspan="1" width="50">';
         					html = html + '<input id="calculate-route" type="button" value="길찾기!"><input id="routeClear" type="button" value="초기화">';
         				html = html + '</td>';
         			html = html + '</tr>';
         			html = html + '<tr height="250">';
         				html = html + '<td width="50"colspan="1">내용</td>';
         				html = html + '<td width="250" colspan="5"><textarea rows="10" cols="100" name="sb_subcontent"></textarea></td>';
         			html = html + '</tr>';
         			html = html + '<tr height="50">';
         				html = html + '<td width="50" colspan="1">교통비</td>';
         				html = html + '<td width="50" colspan="1"><input type="text" name="sb_tcharge"></td>';
         				html = html + '<td width="50" colspan="1">식비</td>';
         				html = html + '<td width="50" colspan="1"><input type="text" name="sb_fcharge"></td>';
         				html = html + '<td width="50" colspan="1">숙박비</td>';
         				html = html + '<td width="50" colspan="1"><input type="text" name="sb_rcharge"></td>';
         			html = html + '</tr>';
         			html = html + '<tr height="50" >';
         				html = html + '<td colspan="6" width="400"><button class="btn btn-danger remove-btn">경로 삭제</button></td>';
         			html = html + '</tr>';
         		html = html + '</table>';
         	html = html + '</div>';
         html = html + '</li>';		
         $(wrapper).append(html);
     });
    
    //출발지 이벤트
    $(document).on('click', '.originInputClass', function() {
		var myIcon = new google.maps.MarkerImage("/tripPlan/assets/images/marker.png", null, null, null, new google.maps.Size(45,30)); //마커 이미지.
    	var map = new google.maps.Map(document.getElementById('map'), {					//맵 객체 로딩
			mapTypeControl : false,
			center : {
				lat : 37.566535,
				lng : 126.97796919999996
			},
			zoom : 13
		});
		var origin_input = $(this)[0];
		var origin_autocomplete = new google.maps.places.Autocomplete(origin_input);
		origin_autocomplete.bindTo('bounds', map);										//출발지에 자동완성어 가져온다.
			
		function expandViewportToFitPlace(map, place) {
			if (place.geometry.viewport) {
				map.fitBounds(place.geometry.viewport);									//fitBounds(bounds:LatLngBounds|LatLngBoundsLiteral)지정된 경계를 포함하도록 뷰 포트 설정
				marker = new google.maps.Marker({ 										//검색 된 곳에 마커 설정
					   position: place.geometry.location, 	
					   map: map,
					   icon:myIcon
				});
			} else {
				
				var lat = place.geometry.location.lat();
				var lng = place.geometry.location.lng();
				document.getElementById('lat').value = lat;
				document.getElementById('lng').value = lng;
				alert(place.geometry.location.lat());
				alert(place.geometry.location.lng());
				map.setCenter(place.geometry.location);									//장소일 시에 장소를 맵 중심으로 설정하고
				map.setZoom(17);														//줌을 17로 설정.
				marker = new google.maps.Marker({ 										//검색 된 곳에 마커 설정
					   position: place.geometry.location, 	
					   map: map,
					   icon:myIcon
				});
			}
		}

		origin_autocomplete.addListener('place_changed', function() {					//출발지 자동완성어에 이벤트 처리.
			var place = origin_autocomplete.getPlace();									//자동완성어의 장소를 가져 온다.
			if (!place.geometry) {														//장소가 검색이 안될 시
				window.alert("출발지를 올바르게 입력해 주세요.");									//alert창 띄움.
				return;
			}
			expandViewportToFitPlace(map, place);

			// If the place has a geometry, store its place ID and route if we have
			// the other place ID
			origin_place_id = place.place_id;
		});
    });
    
    
    
    
    
    
    //도착지 이벤트
    $(document).on('click', '.destinationInputClass', function() {
    	var myIcon = new google.maps.MarkerImage("/tripPlan/assets/images/marker.png", null, null, null, new google.maps.Size(45,30)); //마커 이미지.
    	var map = new google.maps.Map(document.getElementById('map'), {					//맵 객체 로딩
			mapTypeControl : false,
			center : {
				lat : 37.566535,
				lng : 126.97796919999996
			},
			zoom : 13
		});
		var destination_input = $(this)[0];
		var destination_autocomplete = new google.maps.places.Autocomplete(destination_input);
		destination_autocomplete.bindTo('bounds', map);										//출발지에 자동완성어 가져온다.
			
		function expandViewportToFitPlace(map, place) {
			if (place.geometry.viewport) {
				map.fitBounds(place.geometry.viewport);									//fitBounds(bounds:LatLngBounds|LatLngBoundsLiteral)지정된 경계를 포함하도록 뷰 포트 설정
				marker = new google.maps.Marker({ 										//검색 된 곳에 마커 설정
					   position: place.geometry.location, 	
					   map: map,
					   icon:myIcon
				});
			} else {
				
				var lat = place.geometry.location.lat();
				var lng = place.geometry.location.lng();
				document.getElementById('lat').value = lat;
				document.getElementById('lng').value = lng;
				alert(place.geometry.location.lat());
				alert(place.geometry.location.lng());
				map.setCenter(place.geometry.location);									//장소일 시에 장소를 맵 중심으로 설정하고
				map.setZoom(17);														//줌을 17로 설정.
				marker = new google.maps.Marker({ 										//검색 된 곳에 마커 설정
					   position: place.geometry.location, 	
					   map: map,
					   icon:myIcon
				});
			}
		}

		destination_autocomplete.addListener('place_changed', function() {					//출발지 자동완성어에 이벤트 처리.
			var place = destination_autocomplete.getPlace();									//자동완성어의 장소를 가져 온다.
			if (!place.geometry) {														//장소가 검색이 안될 시
				window.alert("출발지를 올바르게 입력해 주세요.");									//alert창 띄움.
				return;
			}
			expandViewportToFitPlace(map, place);

			// If the place has a geometry, store its place ID and route if we have
			// the other place ID
			destination_place_id = place.place_id;
		});
    });

      
    
         /*
         
         $(".timeline-milestone").on("click",	"li",		
 				function initMap() {
				var origin_place_id = null;														//출발 지역
				var destination_place_id = null;												//도착 지역
				var travel_mode = google.maps.TravelMode.TRANSIT;								//교통형식 : 대중교통
				var myIcon = new google.maps.MarkerImage("/tripPlan/assets/images/marker.png", null, null, null, new google.maps.Size(45,30)); //마커 이미지.
				var map = new google.maps.Map(document.getElementById('map'), {					//맵 객체 로딩
					mapTypeControl : false,
					center : {
						lat : 37.566535,
						lng : 126.97796919999996
					},
					zoom : 13
				});
				 directionsService = new google.maps.DirectionsService;							//두 개 이상의 장소 사이에서 길 찾기를 계산하는 서비스
				 																				//directionsService() 구글 서보로 방향 쿼리를 전송
				 																				//route(request:DirectionsRequest, callback:function(DirectionsResult, DirectionsStatus))
				 																				//길 찾기 검색 요청을 발행.
				directionsDisplay = new google.maps.DirectionsRenderer({ draggable: true });	//화면에 directionsService class로 부터 얻은 방향을 렌더링 한다.
				directionsDisplay.setMap(map);													//directionrenderer에다가 map정보 부착.
				directionsDisplay.setPanel(document.getElementById("directions"));
				directionsDisplay.setOptions({ suppressMarkers: true });
				
				var origin_input = document.getElementById('originInput');						//input에 있는 텍스트 가져옴
				var destination_input = document.getElementById('destinationInput');			//input에 있는 텍스트 가져옴.
				var modes = document.getElementById('mode-selector');							//대중교통인지 차량인지 가져오기.

				var origin_autocomplete = new google.maps.places.Autocomplete(origin_input);
				origin_autocomplete.bindTo('bounds', map);										//출발지에 자동완성어 가져온다.
																								//bindTo(key:string, target:MVCObject, targetKey?:string, noNotify?:boolean)뷰를 모델에 바인드.
				var destination_autocomplete = new google.maps.places.Autocomplete(destination_input);
				destination_autocomplete.bindTo('bounds', map);

				
				function expandViewportToFitPlace(map, place) {
					if (place.geometry.viewport) {
						map.fitBounds(place.geometry.viewport);									//fitBounds(bounds:LatLngBounds|LatLngBoundsLiteral)지정된 경계를 포함하도록 뷰 포트 설정
						marker = new google.maps.Marker({ 										//검색 된 곳에 마커 설정
							   position: place.geometry.location, 	
							   map: map,
							   icon:myIcon
						});
					} else {
						
						var lat = place.geometry.location.lat();
						var lng = place.geometry.location.lng();
						document.getElementById('lat').value = lat;
						document.getElementById('lng').value = lng;
						alert(place.geometry.location.lat());
						alert(place.geometry.location.lng());
						map.setCenter(place.geometry.location);									//장소일 시에 장소를 맵 중심으로 설정하고
						map.setZoom(17);														//줌을 17로 설정.
						marker = new google.maps.Marker({ 										//검색 된 곳에 마커 설정
							   position: place.geometry.location, 	
							   map: map,
							   icon:myIcon
						});
					}
				}

				origin_autocomplete.addListener('place_changed', function() {					//출발지 자동완성어에 이벤트 처리.
					var place = origin_autocomplete.getPlace();									//자동완성어의 장소를 가져 온다.
					if (!place.geometry) {														//장소가 검색이 안될 시
						window.alert("출발지를 올바르게 입력해 주세요.");									//alert창 띄움.
						return;
					}
					expandViewportToFitPlace(map, place);

					// If the place has a geometry, store its place ID and route if we have
					// the other place ID
					origin_place_id = place.place_id;
				});

				destination_autocomplete.addListener('place_changed',function() {				//도착지 자동완성어에 이벤트 처리
							var place = destination_autocomplete.getPlace();
							if (!place.geometry) {
								window.alert("도착지를 올바르게 입력해 주세요.");
								return;
							}
							expandViewportToFitPlace(map, place);

							// If the place has a geometry, store its place ID and route if we have
							// the other place ID
							destination_place_id = place.place_id;
				});
				function route(origin_place_id, destination_place_id, travel_mode, directionsService, directionsDisplay) {
					if (!origin_place_id || !destination_place_id) {
						return;
						}
		    directionsService.route({
		      origin: {'placeId': origin_place_id},											//출발지의 정보 파라미터 값 가져옴
		      destination: {'placeId': destination_place_id},								//도착지의 정보 파라미터 값 가져옴
		      provideRouteAlternatives: true,												//대체경로를 보여 줄 것인지 결정.
		      travelMode: google.maps.TravelMode.TRANSIT									//어떤 교통 매체 이용할 건지 결정.
		    }, function(response, status) {
		      if (status === google.maps.DirectionsStatus.OK) {								//status가 구글 맵의 길찾기 경로가 있다면
		    	  alert(response.routes);
		    	  for (var i = 0; i < response.routes.length; i++) {						
						new google.maps.DirectionsRenderer({								//새로운 경로를 가져온다.
						    map: map,														//map에는 위에 선언된 map변수를 가져와 담는다.
						    directions: response,											//경로에 response정보를 담는다.
						    routeIndex: i	,												//대체 경로들을 담아서 보여준다.
						    polylineOptions: { strokeColor: color[i],strokeOpacity:1.0},	//라인 색깔을 white로 잡아줌
							markerOptions : {icon:myIcon}									//마커는 내가 지정한 마커로.
						  });
						directionsDisplay.setDirections(response);							//directionDisplay에 경로들을 붙여준다(이게 없으면 directions panel안 붙음).
		    	  }
		      } else {
		        window.alert('Directions request failed due to ' + status);
		      }
		    });
		    
		    
		    
		    function geocode() {
		    	  var address = "";
		    	  address = document.getElementById("originInput").value;
		    	  var geocoder = new google.maps.Geocoder();
		    	  geocoder.geocode({'address': address,'partialmatch': true}, geocodeResult);
		    	 }

		    	 function geocodeResult(results, status) {
		    	  //if( status == google.maps.GeocoderStatus.OK ) {
		    	  if (status == 'OK' && results.length > 0) {
		    	   //map.fitBounds(results[0].geometry.viewport);
		    	   alert(results[0].geometry.location.lat());
		    	   alert(results[0].geometry.location.lng());
		    	  } else {
		    	   alert("Geocode was not successful for the following reason: " + status);
		    	  }
		    	 }
			}
				
				
				
				
				
				
			
			$(document).ready(function() {
			    // If the browser supports the Geolocation API
			    if (typeof navigator.geolocation == "undefined") {  						//결과 타입이 undefined면 
			      $("#error").text("Your browser doesn't support the Geolocation API");		//해당 에러가 출력.
			      return;
			    }

			    $("#originInput-link, #destinationInput-link").click(function(event) {		//id가 " " 안에 있는 두개가 클릭되면 function실행
			      event.preventDefault();													//이벤트를 취소할 수 있는 경우, 이벤트의 전파를 막지않고 그 이벤트를 취소
			      var addressId = this.id.substring(0, this.id.indexOf("-")); 				//addressId는 클릭한 id의 첫번째부터 '-'자리까지 자른 문자.

			      navigator.geolocation.getCurrentPosition(function(position) {
			        var geocoder = new google.maps.Geocoder();
			        geocoder.geocode({
			          "location": new google.maps.LatLng(position.coords.latitude, position.coords.longitude)
			        },
			        function(results, status) {
			          if (status == google.maps.GeocoderStatus.OK)
			            $("#" + addressId).val(results[0].formatted_address);
			          else
			            $("#error").append("Unable to retrieve your address<br />");
			        });
			      },
			      function(positionError){
			        $("#error").append("Error: " + positionError.message + "<br />");
			      },
			      {
			        enableHighAccuracy: true,
			        timeout: 10 * 1000 // 10 seconds
			      });
			    });
			    $("#calculate-route").click(function(event) {														//class가 calculate-route를  클릭하면 route실행
			      event.preventDefault();
			     route(origin_place_id, destination_place_id, travel_mode, directionsService, directionsDisplay);
			    });
			    $("#routeClear").on("click", function() { directionsDisplay.setDirections({ routes: [] }); });		//panel삭제해 줌
			    
			  });
}
			
			
			

);
    });
    $(wrapper).on("click",".remove-btn", function(e){ //user click on remove text
        e.preventDefault(); $(this).closest('li.timeline-start').remove(); x--;
    });
    */
});

