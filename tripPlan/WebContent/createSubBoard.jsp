<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<link href="/tripPlan/assets/css/path.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
<script src="/tripPlan/assets/js/subBoard.js"></script>
<script src="/tripPlan/assets/js/map.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDenhlxS0ffAWJ13dfpLxLoqcz94fUAL3o&libraries=places&callback=initMap"async defer></script>

<title>Insert title here</title>
<!-- <script type="text/javascript">  
$("document").ready(function() {  
  
    var currentPosition = parseInt($("#map").css("top"));  
  
    $(window).scroll(function() {  
            var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.  
            $("#map").stop().animate({"top":position+currentPosition+"px"},500);  
    });  
      
});  
</script> -->
</head>
<body>
<div id="body">
<div id="map"></div>
<button class="btn btn-primary add_root_btn" style="margin-left:800px; margin-top:120px; position:fixed;"><i class="fa fa-plus">경로생성</i></button>
<input class="btn btn-primary" id="routeClear"style="margin-left:900px;  margin-top:120px;position:fixed;" type="button" value="초기화">

<div id="directions"></div>	
<div id="wrap">
	<div style="float:left; width:40%; margin-left:500px;">
	<form action="createSubBoard.do" method="post"onkeydown="return captureReturnKey(event)">
	
		<article class="page">
	 		 <ul class="timeline">
	   			 <li class="timeline-milestone is-completed timeline-start">
	     		 <div class="timeline-action">
	     	 <table border="1" width="400" height="400">
				<tr height="50">
					<td width="50" colspan="1">여행지</td>
					<td width="150" colspan="2"><input id="originInput" name="input" class="control" required="required" type="text" placeholder="출발지를 입력해 주세요.">
					<input id="lat" type="hidden">
					<input id="lng" type="hidden">
					<br/>
					<a id="originInput-link" href="#">Get my position</a>
					</td>
					<td width="150" colspan="2"><input id="destinationInput" class="controls" type="text" name="sb_lon" placeholder="도착지를 입력해 주세요."><br/>
					<a id="destinationInput-link" href="#">Get my position</a>
					</td>
					<td colspan="1" width="50"><input id="calculate-route" type="button" value="길찾기!"></td>
				</tr>  
				<tr height="250">
					<td width="50"colspan="1">내용</td>
					<td width="250" colspan="5"><textarea rows="10" cols="100" name="sb_subcontent"></textarea></td>
				</tr>
				<tr height="50">
					<td width="50" colspan="1">교통비</td><td width="50" colspan="1"><input type="text" name="sb_tcharge"></td>
					<td width="50" colspan="1">식비</td><td width="50" colspan="1"><input type="text" name="sb_fcharge"></td>
					<td width="50" colspan="1">숙박비</td><td width="50" colspan="1"><input type="text" name="sb_rcharge"></td>
				</tr>
				<tr height="50" ><td colspan="6" width="400"></td></tr>
		      </table>
		      </div>
		    </li>
		  </ul>
		</article>
		<input type="submit" class="btn btn-success controls" style="margin:auto;"value="생성"/>
		<input type="button" class="btn btn-danger controls" style="margin:auto;"value="취소"/>
	</form>
	</div>
	</div>
	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
	<script src="/tripPlan/assets/js/ddsort.js"></script>
	<script>
		$( '#wrap' ).DDSort({
			target: 'li',	
			floatStyle: {
				'border': '1px solid #ccc',
				'background-color': '#fff'
			}
		});
	</script>
</div>
</body>
</html>