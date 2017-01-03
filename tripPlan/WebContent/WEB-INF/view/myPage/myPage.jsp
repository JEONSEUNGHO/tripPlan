<%@ page contentType="text/html; charset=UTF-8"%>
<head>
</head>

<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<script>
	history.pushState(null, null, location.href);
	window.onpopstate = function(event) {
		history.go(1);
	}
	function list() {
		$('#searchBar')
				.focus(
						function() {
							$
									.ajax({
										type : "post",
										url : "/tripPlan/tiles/finduser.do",
										data : {
											"searchUser" : $('#searchBar')
													.val()
										},
										dataType : "json",
										success : function(data) {

											var _len = data.length;
											var post, i;

											for (i = 0; i < _len; i++) {
												// post배열에 JSON 배열을 하나씩 저장
												post = data[i];

											}
											$(".container_ui__item").remove();
											for (i = 0; i < _len; i++) {
												post = data[i];
												var jbString = post.data;
												var jbSplit = jbString
														.split(',');
												if (!jbSplit[2]) {
													jbSplit[2] = "/tripPlan/assets/images/default-user-image.png"
												}
												var html = '';
												html += '<div class="container_ui__item">';
												html += '<div class="face">';
												html += '<a href=""><img src="'+jbSplit[2]+'"></a>';
												html += '<div>';
												html += '<h2>' + jbSplit[0]
														+ '</h2>';
												html += '&nbsp;&nbsp;<a href="/tripPlan/letter/sendwrite.do?sm_receiver='
														+ jbSplit[1]
														+ '" target="_blank"><i style="color: #fb5948;" class="fa fa-paper-plane-o"></i></a>';
												html += '<h3 class="h3">'
														+ jbSplit[1] + '</h3>';
												html += '</div>';
												if (jbSplit[4] == -1) {
													html += '<button class="btn btn-primary btn-sm" onclick="addfollow(\''
															+ jbSplit[1]
															+ '\')" style="border-style:none;">Follow</button>';
												} else {
													html += '<button class="btn btn-primary btn-sm" onclick="delfollow(\''
															+ jbSplit[1]
															+ '\')" style="background-color:#70c1b3; border-style:none;" >Unfollow</button>';
												}
												html += '</div>';
												html += '</div>';

												$(".inner").after(html);

											}
										},
										error : function(e) { // 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
											alert(e.responseText);
										}
									});
						});
	}
	// mypage 로딩 시 follow list 출력
	$(document)
			.ready(
					function() {
						$
								.ajax({
									type : "post",
									url : "/tripPlan/tiles/finduser.do",
									data : {
										"searchUser" : $('#searchBar').val()
									},
									dataType : "json",
									success : function(data) {

										var _len = data.length;
										var post, i;

										for (i = 0; i < _len; i++) {
											// post배열에 JSON 배열을 하나씩 저장
											post = data[i];

										}
										$(".container_ui__item").remove();
										for (i = 0; i < _len; i++) {
											post = data[i];
											var jbString = post.data;
											var jbSplit = jbString.split(',');
											if (!jbSplit[2]) {
												jbSplit[2] = "/tripPlan/assets/images/default-user-image.png"
											}
											var html = '';
											html += '<div class="container_ui__item">';
											html += '<div class="face">';
											html += '<a href=""><img src="'+jbSplit[2]+'"></a>';
											html += '<div>';
											html += '<h2>' + jbSplit[0]
													+ '</h2>';
											html += '&nbsp;&nbsp;<a href="/tripPlan/letter/sendwrite.do?sm_receiver='
													+ jbSplit[1]
													+ '" target="_blank"><i style="color: #fb5948;" class="fa fa-paper-plane-o"></i></a>';
											html += '<h3 class="h3">'
													+ jbSplit[1] + '</h3>';
											html += '</div>';
											if (jbSplit[4] == -1) {
												html += '<button class="btn btn-primary btn-sm" onclick="addfollow(\''
														+ jbSplit[1]
														+ '\')" style="border-style:none;">Follow</button>';
											} else {
												html += '<button class="btn btn-primary btn-sm" onclick="delfollow(\''
														+ jbSplit[1]
														+ '\')" style="background-color:#70c1b3; border-style:none;" >Unfollow</button>';
											}
											html += '</div>';
											html += '</div>';

											$(".inner").after(html);

										}
									},
									error : function(e) { // 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
										alert(e.responseText);
									}
								});
					});
	// 검색창에 입력 시 해당 lsit 출력
	$(function() {
		$('#searchBar')
				.keyup(
						function() {
							$
									.ajax({
										type : "post",
										url : "/tripPlan/tiles/finduser.do",
										data : {
											"searchUser" : $('#searchBar')
													.val()
										},
										dataType : "json",
										success : function(data) {

											var _len = data.length;
											var post, i;

											for (i = 0; i < _len; i++) {
												// post배열에 JSON 배열을 하나씩 저장
												post = data[i];

											}
											$(".container_ui__item").remove();
											for (i = 0; i < _len; i++) {
												post = data[i];
												var jbString = post.data;
												var jbSplit = jbString
														.split(',');
												if (!jbSplit[2]) {
													jbSplit[2] = "/tripPlan/assets/images/default-user-image.png"
												}
												var html = '';
												html += '<div class="container_ui__item">';
												html += '<div class="face">';
												html += '<a href=""><img src="'+jbSplit[2]+'"></a>';
												html += '<div>';
												html += '<h2>' + jbSplit[0]
														+ '</h2>';
												html += '&nbsp;&nbsp;<a href="/tripPlan/letter/sendwrite.do?sm_receiver='
														+ jbSplit[1]
														+ '" target="_blank"><i style="color: #fb5948;" class="fa fa-paper-plane-o"></i></a>';
												html += '<h3>' + jbSplit[1]
														+ '</h3>';
												html += '</div>';
												if (jbSplit[4] == -1) {
													html += '<button class="btn btn-primary btn-sm" onclick="addfollow(\''
															+ jbSplit[1]
															+ '\')" style="border-style:none;">Follow</button>';
												} else {
													html += '<button class="btn btn-primary btn-sm" onclick="delfollow(\''
															+ jbSplit[1]
															+ '\')" style="background-color:#70c1b3; border-style:none;" >Unfollow</button>';
												}
												html += '</div>';
												html += '</div>';

												$(".inner").after(html);

											}
										},
										error : function(e) { // 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
											alert(e.responseText);
										}
									});
						});
	});
	function addfollow(f_email) {
		$.ajax({
			type : "post",
			url : "/tripPlan/tiles/addfollow.do",
			data : {
				"f_email" : f_email
			},
			success : function() {

			}
		});
		$('#searchBar').focus();
		list();
	}
	function delfollow(f_email) {
		$.ajax({
			type : "post",
			url : "/tripPlan/tiles/delfollow.do",
			data : {
				"f_email" : f_email
			},
			success : function() {

			}
		});
		$('#searchBar').focus();
		list();
	}
</script>
<style>
body {
	color: #5D5F63;
	background: #f3f2f2;
	padding: 0;
	margin: 0;
	text-rendering: optimizeLegibility;
	-webkit-font-smoothing: antialiased;
}

/* 오른쪽 사이드바 */
.left_container {
	width: 22%;
	text-align: center;
	height: 100%;
	position: absolute;
	right: 0;
	maring: auto;
}

.container_ui {
	width: 95%;
	overflow-x: scroll;
	background: white;
	height: 100%;
	box-shadow: 5px 5px 0px rgba(0, 0, 0, 0.16);
	-webkit-transition-property: opacity, top;
	transition-property: opacity, top;
	-webkit-transition-duration: 0.4s;
	transition-duration: 0.4s;
	-webkit-animation: pop .5s forwards;
	animation: pop .5s forwards;
}

.container_ui__heading {
	text-align: center;
	height: 60px;
	width: 100%;
	background: #fb5948;
}

.container_ui__heading h1 {
	color: #fff;
	text-transform: uppercase;
	font-weight: 700;
	height: 10px;
	margin: 0;
	font-size: 15px;
	float: left;
	width: 100%;
	letter-spacing: 1px;
	line-height: 64px;
}

.container_ui__item {
	width: 97%;
	float: left;
	height: 82px;
	text-align: left;
	color: black;
	margin: 5;
	box-shadow: 0px -1px rgba(0, 0, 0, 0.07);
	color: #fff;
	background: #F5F5F5;
}

.container_ui__item h2, .container_ui__item h3 {
	color: black;
}

.container_ui__item h2 {
	font-size: 15px;
	display: inline-block;
	color: #515151;
	font-weight: 800;
	margin: 20px 0px 0px 80px;
	padding-top: 0px;
}

.container_ui__item h3 {
	font-size: 13px;
	font-weight: 800;
	margin: 5px 0px 10px 80px;
	color: #B2B2B2;
}

.container_ui__item .face {
	width: 100%;
	float: left;
	clear: left;
	margin: 0;
	display: -webkit-inline-box;
	margin-right: 10px;
	position: relative;
}

.container_ui__item .face img {
	width: 50;
	height: 50;
	position: absolute;
	top: 10;
	left: 10;
	border-radius: 50%;
	border: none;
	margin: 5;
}

.btn-primary {
	position: absolute;
	top: 20;
	right: 10;
	color: #FFF;
	background-color: #1c91c4;
	border-color: none;
}

#searchMenu {
	width: 100%;
	height: 8%;
	text-align: center;
	position: relative;
	border-bottom: 1px solid #E4E0E1;
}

#searchMenu #searchBar {
	position: relative;
	width: 80%;
	height: 100%;
	text-align: left;
	line-height: 20px;
	border-radius: 20px;
	border: 1px solid #E4E0E1;
	left: 10;
	outline: none;
	border: none;
	font-size: 15px;
	font-family: Roboto, Arial, Sans-Serif;
}

#searchMenu #searchIcon {
	position: absolute;
	left: 15px;
	top: 36%;
	z-index: 1;
	color: #ccc;
}

/* 왼쪽 사이드바 */
#sidebar {
	position: fixed;
	top: 140px;
	left: 220px;
	width: 220px;
	height: 70%;
	margin-left: -220px;
	border: none;
	border-radius: 0;
	background-color: #222;
}

.side-bar>li>a {
	color: #eee;
	width: 220px;
}

.side-bar li a:hover, .side-bar li a:focus {
	background-color: #333;
}

</style>

<div id="body">

	${m_email}

	<!-- 왼쪽 사이드바 -->
	<div id="sidebar">
		
		<ul class="nav navbar-nav side-bar">
			<li class="side-bar tmargin"><a href="#"><i class="fa fa-newspaper-o" aria-hidden="true">
			</i>&nbsp;&nbsp;&nbsp;타임라인</a></li>
			<li class="side-bar"><a href="#"><i class="fa fa-map-o" aria-hidden="true">
			</i>&nbsp;&nbsp;&nbsp;내 경로</a></li>
			<li class="side-bar"><a href="#"><i class="fa fa-heart-o" aria-hidden="true">
			</i>&nbsp;&nbsp;&nbsp;찜목록</a></li>
			<li class="side-bar"><a href="#"><i class="fa fa-user-o" aria-hidden="true">
			</i>&nbsp;&nbsp;&nbsp;프로필 수정</a></li>
			<li class="side-bar"><a href="#"><i class="fa fa-lock" aria-hidden="true">
			</i>&nbsp;&nbsp;&nbsp;비밀번호 변경</a></li>

		</ul>
	</div>

<!-- 오른쪽 사이드바 -->
<div class='left_container'>
	<div class='container_ui'>
		<div class='container_ui__heading'>
			<h1>Following</h1>
		</div>
		<div id="searchMenu">
			<i class="fa fa-search" id="searchIcon"></i> <input name="searchUser"
				type="text" id="searchBar" placeholder="찾으실 닉네임 또는 이메일을 입력하세요."
				required />
		</div>
		<div class="inner"></div>


	</div>

</div>
</div>