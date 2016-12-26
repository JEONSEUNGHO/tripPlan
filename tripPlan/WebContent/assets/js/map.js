			function initMap() {
				var origin_place_id = null;//출발 지역
				var destination_place_id = null;//도착 지역
				var travel_mode = google.maps.TravelMode.TRANSIT;//교통형식 : 대중교통
				var map = new google.maps.Map(document.getElementById('map'), {//맵 객체 로딩
					mapTypeControl : false,
					center : {
						lat : 37.566535,
						lng : 126.97796919999996
					},
					zoom : 13
				});
				 directionsService = new google.maps.DirectionsService;//두 개 이상의 장소 사이에서 길 찾기를 계산하는 서비스
				//directionsService() 구글 서보로 방향 쿼리를 전송
				//route(request:DirectionsRequest, callback:function(DirectionsResult, DirectionsStatus))
				//길 찾기 검색 요청을 발행.
				directionsDisplay = new google.maps.DirectionsRenderer;
				//화면에 directionsService class로 부터 얻은 방향을 렌더링 한다.
				directionsDisplay.setMap(map);

				var origin_input = document.getElementById('origin-input');//input에 있는 텍스트 가져옴
				var destination_input = document
						.getElementById('destination-input');//input에 있는 텍스트 가져옴.
				var modes = document.getElementById('mode-selector');//대중교통인지 차량인지 가져오기.

				var origin_autocomplete = new google.maps.places.Autocomplete(origin_input);
				origin_autocomplete.bindTo('bounds', map);//출발지에 자동완성어 가져온다.
				//bindTo(key:string, target:MVCObject, targetKey?:string, noNotify?:boolean)뷰를 모델에 바인드.
				var destination_autocomplete = new google.maps.places.Autocomplete(destination_input);
				destination_autocomplete.bindTo('bounds', map);

				// Sets a listener on a radio button to change the filter type on Places
				// Autocomplete.
				function setupClickListener(id, mode) {//클릭 이벤트 발생.
					var radioButton = document.getElementById(id);
					radioButton.addEventListener('click', function() {
						travel_mode = mode;
					});
				}
				setupClickListener('changemode-transit',google.maps.TravelMode.TRANSIT);

				function expandViewportToFitPlace(map, place) {
					if (place.geometry.viewport) {
						map.fitBounds(place.geometry.viewport);
						//fitBounds(bounds:LatLngBounds|LatLngBoundsLiteral)지정된 경계를 포함하도록 뷰 포트 설정
					} else {
						map.setCenter(place.geometry.location);//장소일 시에 장소를 맵 중심으로 설정하고
						map.setZoom(17);//줌을 17로 설정.
					}
				}

				origin_autocomplete.addListener('place_changed', function() {//출발지 자동완성어에 이벤트 처리.
					var place = origin_autocomplete.getPlace();//자동완성어의 장소를 가져 온다.
					if (!place.geometry) {//장소가 검색이 안될 시
						window.alert("출발지를 올바르게 입력해 주세요.");//alert창 띄움.
						return;
					}
					expandViewportToFitPlace(map, place);

					// If the place has a geometry, store its place ID and route if we have
					// the other place ID
					origin_place_id = place.place_id;
				});

				destination_autocomplete.addListener('place_changed',function() {//도착지 자동완성어에 이벤트 처리
							var place = destination_autocomplete.getPlace();
							if (!place.geometry) {
								window.alert("도착지를 올바르게 입력해 주세요.");
								return;
							}
							expandViewportToFitPlace(map, place);

							// If the place has a geometry, store its place ID and route if we have
							// the other place ID
							destination_place_id = place.place_id;
							route(origin_place_id, destination_place_id, travel_mode,
							          directionsService, directionsDisplay);
							});
				/*function route(origin_place_id, destination_place_id, travel_mode, directionsService, directionsDisplay) {
					if (!origin_place_id || !destination_place_id) {
						return;
						}
		    directionsService.route({
		      origin: {'placeId': origin_place_id},
		      destination: {'placeId': destination_place_id},
		      travelMode: travel_mode
		    }, function(response, status) {
		      if (status === google.maps.DirectionsStatus.OK) {
		        directionsDisplay.setDirections(response);
		      } else {
		        window.alert('Directions request failed due to ' + status);
		      }
		    });*/
		  
			}
			
			function route() {
				var start = document.getElementById('origin-input').value;
				var end = document.getElementById('destination-input').value;
				 request = {
		  				origin:start,
		  				destination:end,
						provideRouteAlternatives: true,
						travelMode : eval("google.maps.DirectionsTravelMode.TRANSIT")
				}
				directionsService.route(request, function(response, status) {
					alert('zzz');
					if (status === google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(response);
					} else {
						window.alert('Directions request failed due to '+ status);
					}
				});
			}
