<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

</head>
<style>
#container {
	min-height: 100%;
}
/* anchar태그 색상 */
a, a:hover, a:active, a:focus {
	color: #FFFFFF;
}
/* 메인 배경 이미지 */
.bg-container {
	width: 100%;
	height: 100%;
	margin: 0 auto;
	position: relative;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
/* 텍스트를 부각하기위한 이미지 필터처리 */
.bg-container-overlay {
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.4);
	position: absolute;
	top: 0;
	left: 0;
}
/* 로고와 서브타이틀을 감싸는 컨테이너 */
.logo-container {
	width: auto;
	height: 30%;
	margin: 0 auto;
	position: absolute;
	top: 30%;
	left: 33.3%;
	bottom: 0;
	padding: 16px 0px;
	color: #FFF;
}
/* 시작하기 버튼 */
#btn-container, a.btn-outline {
	color: #50514F;
	background: #FFF;
	box-shadow: none;
	border-radius: 10px;
}
footer, footer a, footer a:hover, footer a:active, footer a:visited,
	footer a:focus {
	color: #fff;
	text-decoration: none;
}

address {
	clear: both;
	color: #fff;
	font-size: 0.85em;
	line-height: 1;
}

</style>
<script>
	history.pushState(null, null, location.href);
	window.onpopstate = function(event) {
		history.go(1);
	}
</script>
<body>

<header class="navbar-wrapper">
	<div class="container">
		<!-- 헤더 메뉴바 -->
		<div class="navbar navbar-static-top" role="navigation">
			<!-- 로고 영역 -->
			<div class="navbar-header">

				<!-- 로고 -->
				<a class="navbar-brand" href="main.do"><img src="/tripPlan/assets/images/logo-header.png"></a>
				<!--// 로고 -->
			</div>
			<!--// 로고 영역 -->
			<!-- 헤더 영역 -->
			<div class="navbar-collapse collapse">
				<!-- 헤더메뉴 -->
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="regist.do">
							<!-- font-awesome 회원 추가 아이콘 -->
							<i class="fa fa-user-plus"></i>
							&nbsp;&nbsp;<span id="text">회원가입</span>
						</a>
					</li>
					<li>
						<a href="login.do">
							<!-- font-awesome 로그인 아이콘 -->
							<i class="fa fa-sign-in"></i>
							&nbsp;&nbsp;<span id="text">로그인</span>
						</a>
					</li>

				</ul>
				<!--// 헤더메뉴 -->
			</div>
			<!--// 헤더 영역 -->
		</div>
		<!--// 헤더 메뉴바 -->
	</div>

</header>
	<div id="container">
		<!-- 그룹페이지 메인화면 상단 container -->
		<div class="bg-container"
			style="background-image: url('/tripPlan/assets/images/mainImage3.jpg');">
			<!-- text를 강조하기 위해 사진배경을 어둡게 하는 기능 -->
			<div class="bg-container-overlay"></div>
			<!-- 로고와 서브 타이틀을 입력하기 위한 container -->
			<div class="logo-container">
				<!--  로고 이미지 -->
				<div class="logo">
					<img src="/tripPlan/assets/images/logo-main.png" />
				</div>
				<!-- 서브 타이틀 -->
				<div class="sub-title">서브 타이틀 텍스트 등록(관리자 DB에서 정보 가져옴)</div>
				<!-- 시작하기 버튼  -->
				<div id="btn-container" class="col-xs-2 text-right">
					<a class="btn btn-lg btn-outline btn-clock" href="login.do"><b>시작하기</b></a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>