			function initMap() {
				var origin_place_id = null;														//출발 지역
				var destination_place_id = null;												//도착 지역
				var travel_mode = google.maps.TravelMode.TRANSIT;								//교통형식 : 대중교통
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
				directionsDisplay = new google.maps.DirectionsRenderer({ draggable: true },{ polylineOptions: { strokeColor: "#FA58AC" } });							//화면에 directionsService class로 부터 얻은 방향을 렌더링 한다.
				directionsDisplay.setMap(map);													//directionrenderer에다가 map정보 부착.
				directionsDisplay.setPanel(document.getElementById("directions"));
				directionsDisplay.setOptions({ suppressMarkers: true });
				polylineOptions:{strokeColor:'someValidCSSColorValue'};
				var origin_input = document.getElementById('originInput');						//input에 있는 텍스트 가져옴
				var destination_input = document.getElementById('destinationInput');										//input에 있는 텍스트 가져옴.
				var modes = document.getElementById('mode-selector');							//대중교통인지 차량인지 가져오기.

				var origin_autocomplete = new google.maps.places.Autocomplete(origin_input);
				origin_autocomplete.bindTo('bounds', map);										//출발지에 자동완성어 가져온다.
																								//bindTo(key:string, target:MVCObject, targetKey?:string, noNotify?:boolean)뷰를 모델에 바인드.
				var destination_autocomplete = new google.maps.places.Autocomplete(destination_input);
				destination_autocomplete.bindTo('bounds', map);

				
				function expandViewportToFitPlace(map, place) {
					if (place.geometry.viewport) {
						map.fitBounds(place.geometry.viewport);									//fitBounds(bounds:LatLngBounds|LatLngBoundsLiteral)지정된 경계를 포함하도록 뷰 포트 설정
						myIcon = new google.maps.MarkerImage("/tripPlan/assets/images/marker.png", null, null, null, new google.maps.Size(45,30));
						marker = new google.maps.Marker({ 										//검색 된 곳에 마커 설정
							   position: place.geometry.location, 	
							   map: map,
							   icon:myIcon
						});
					} else {
						alert(place.geometry.location);
						map.setCenter(place.geometry.location);									//장소일 시에 장소를 맵 중심으로 설정하고
						map.setZoom(17);														//줌을 17로 설정.
						myIcon = new google.maps.MarkerImage("/tripPlan/assets/images/marker.png", null, null, null, new google.maps.Size(30,30));
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
		    	  for (var i = 0; i < response.routes.length; i++) {						
						new google.maps.DirectionsRenderer({								//새로운 경로를 가져온다.
						    map: map,														//map에는 위에 선언된 map변수를 가져와 담는다.
						    directions: response,											//경로에 response정보를 담는다.
						    routeIndex: i													//대체 경로들을 담아서 보여준다.
						  });
						
						directionsDisplay.setDirections(response);							//directionDisplay에 경로들을 붙여준다(이게 없으면 directions panel안 붙음).
		    	  }
		      } else {
		        window.alert('Directions request failed due to ' + status);
		      }
		    });
		  
			}
			
		/*	function route() {
				var start = document.getElementById('originInput').value;
				var end = document.getElementById('destinationInput').value;
				 request = {
		  				origin:start,
		  				destination:end,
						provideRouteAlternatives: true,//경로를 여러개 보일 것인지에 대한 boolean값.
						travelMode : eval("google.maps.DirectionsTravelMode.TRANSIT")
				}
				directionsService.route(request, function(response, status) {
					!confirm('경로를 계산하시겠습니까?')
					if (status === google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(response);
						
					} else {
						window.alert('Directions request failed due to '+ status);
					}
				});
			}*/
			$(document).ready(function() {
			    // If the browser supports the Geolocation API
			    if (typeof navigator.geolocation == "undefined") {  //결과 타입이 undefined면 
			      $("#error").text("Your browser doesn't support the Geolocation API");//해당 에러가 출력.
			      return;
			    }

			    $("#originInput-link, #destinationInput-link").click(function(event) {//id가 " " 안에 있는 두개가 클릭되면 function실행
			      event.preventDefault();											//이벤트를 취소할 수 있는 경우, 이벤트의 전파를 막지않고 그 이벤트를 취소
			      var addressId = this.id.substring(0, this.id.indexOf("-")); //addressId는 클릭한 id의 첫번째부터 '-'자리까지 자른 문자.

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
			    $("#calculate-route").click(function(event) {
			      event.preventDefault();
			     route(origin_place_id, destination_place_id, travel_mode, directionsService, directionsDisplay);
			    });
			    $("#routeClear").on("click", function() { directionsDisplay.setDirections({ routes: [] }); });
			    
			  });
}
			
			
			//ENTER 안먹게 하는것 
			function captureReturnKey(e) { 
			    if(e.keyCode==13 && e.srcElement.type != 'textarea') 
			    return false; 
			} 


