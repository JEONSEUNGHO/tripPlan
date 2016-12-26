<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Place Autocomplete</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
<link rel='stylesheet prefetch'
	href='http://netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css'>
<link href="/tripPlan/assets/css/path.css" rel="stylesheet">
<script	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="/tripPlan/assets/css/style.css">
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css'>
<script src='https://code.jquery.com/jquery-3.1.0.min.js'></script>
<script src="/tripPlan/assets/js/map.js"></script>
<script src="/tripPlan/assets/js/createBoard.js"></script>
</head>
<body>
	<div id="body">
	<h3>Let's Plan</h3>
	 <table width="200">
	  	<tr>
	  		<td width="20">제목 :</td>
	  		<td width="100"><input type="text" name="board-maintitle"></td>
	  		<td width="80">
	  		<select id="board-identified" name="board-identified">
	  			<option value="후기">후기</option>
	  			<option value="계획">계획</option>
	  			<option value="그룹">그룹</option>
	  		</select></td>
	  		<td rowspan="2"><div class="file-upload" data-provide="fileupload"><input type="file"><button type="button" class="btn btn-primary">이미지 첨부</button></div></td>
	  	</tr>
	  	<tr>
	  		<td colspan="3" width="200"><textarea rows="10" cols="50" name="board-maincontents"></textarea></td>
	  		
	  	</tr>
	  </table>
		<div id="map"></div>
		
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDenhlxS0ffAWJ13dfpLxLoqcz94fUAL3o&libraries=places&callback=initMap"async defer></script>
		
		<div style="margin-left: 700px; margin-top: -680px;">
			<article class="page">
				<h2>여행 계획</h2>
				 <ul class="timeline">
	    <li class="timeline-milestone is-completed timeline-start">
	      <div class="timeline-action">
	      <table border="1" width="600" height="400">
			<tr height="50">
				<td width="50" colspan="1">여행지</td>
				<td width="200" colspan="2"><input id="origin-input" class="controls" type="text" placeholder="출발지를 입력해 주세요."></td>
				<td width="200" colspan="2"><input id="destination-input" class="controls" type="text" placeholder="도착지를 입력해 주세요."></td>
				<td colspan="1" width="150"><input type="radio" name="type" id="changemode-transit" checked="checked">대중교통<input type="button" value="길 찾기" onclick="Javascript:route"></td>
			</tr>  
			<tr height="50">
				<td width="50" colspan="1">사진</td>
				<td width="550" colspan="5"><div class="file-upload" data-provide="fileupload">
								<input type="file" name="imagefiles[]" accept="image/*" multiple>
								<button type="button" class="btn btn-primary">이미지 첨부</button>
							</div>
				</td>
			</tr>
			<tr height="250">
				<td width="50"colspan="1">내용</td>
				<td width="550" colspan="5"><textarea rows="10" cols="100"></textarea></td>
			</tr>
			<tr height="50">
				<td width="50" colspan="1">교통비</td><td width="150" colspan="1"><input type="text"></td>
				<td width="50" colspan="1">식비</td><td width="150" colspan="1"><input type="text"></td>
				<td width="50" colspan="1">숙박비</td><td width="150" colspan="1"><input type="text"></td>
			</tr>
			<tr height="50" ><td colspan="6" width="600"><button class="btn btn-primary add_root_btn"><i class="fa fa-plus">경로생성</i></button></td></tr>
	      </table>
							<script src="/tripPlan/assets/js/index.js"></script>


						</div>
					</li>
				</ul>
			</article>
		</div>
	</div>
</body>
</html>