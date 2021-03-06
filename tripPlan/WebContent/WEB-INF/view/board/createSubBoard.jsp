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
<title>Insert title here</title>

</head>
<body>
<div id="body">
<div id="map"></div>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDenhlxS0ffAWJ13dfpLxLoqcz94fUAL3o&libraries=places&callback=initMap"async defer></script>
	<form action="createSubBoard.do" method="post" style="margin-left:650px; margin-top:-480px">
	
		<article class="page">
	 		 <ul class="timeline">
	   			 <li class="timeline-milestone is-completed timeline-start">
	     		 <div class="timeline-action">
	     	 <table border="1" width="600" height="400">
				<tr height="50">
					<td width="50" colspan="1">여행지</td>
					<td width="200" colspan="2"><input id="originInput" class="controls" required="required" type="text" name="sb_lat" placeholder="출발지를 입력해 주세요.">
					<br/>
					<a id="originInput-link" href="#">Get my position</a>
					</td>
					<td width="200" colspan="2"><input id="destinationInput" class="controls" type="text" name="sb_lon" placeholder="도착지를 입력해 주세요."><br/>
					<a id="destinationInput-link" href="#">Get my position</a>
					</td>
					<td colspan="1" width="150"><input type="radio" name="type" id="changemode-transit" checked="checked">대중교통</td>
				</tr>  
				<tr height="250">
					<td width="50"colspan="1">내용</td>
					<td width="550" colspan="5"><textarea rows="10" cols="100" name="sb_subcontent"></textarea></td>
				</tr>
				<tr height="50">
					<td width="50" colspan="1">교통비</td><td width="150" colspan="1"><input type="text" name="sb_tcharge"></td>
					<td width="50" colspan="1">식비</td><td width="150" colspan="1"><input type="text" name="sb_fcharge"></td>
					<td width="50" colspan="1">숙박비</td><td width="150" colspan="1"><input type="text" name="sb_rcharge"></td>
				</tr>
				<tr height="50" ><td colspan="6" width="600"><button class="btn btn-primary add_root_btn"><i class="fa fa-plus">경로생성</i></button></td></tr>
		      </table>
		      </div>
		    </li>
		  </ul>
		</article>
		<input type="submit" class="btn btn-success controls" style="margin:auto;"value="생성"/>
		<input type="button" class="btn btn-danger controls" style="margin:auto;"value="취소"/>
	</form>
</div>
</body>
</html>