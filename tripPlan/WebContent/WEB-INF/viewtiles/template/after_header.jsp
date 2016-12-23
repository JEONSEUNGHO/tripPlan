<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/tripPlan/assets/css/after_search.css" rel="stylesheet">
<link href="/tripPlan/assets/css/after_header.css" rel="stylesheet">


<title>header</title>
</head>
<body>
	<div id="header">
		<div class="inhead">
			<h1 class="logo">
				<a href="mypage.do"> <img src="/tripPlan/assets/images/sample.png"
					alt="TripPlan">
				</a>
			</h1>
			<div class="top_navi">
				<form id="memberModify" name="memberModify">
					<ul class="t_link">
						<li><a href="#" target="_blank" title="경로생성">경로생성</a></li>
						<li><a href="#">쪽지</a></li>

					</ul>
					<ul class="t_ctr">
						<li><a href="#" id="language" class="ico ilan">Language ▼</a>
						</li>
					</ul>
				</form>

				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="menu1" data-toggle="dropdown">
						<img class="userImg" src="/tripPlan/assets/images/default-user-image.png">
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">마이페이지</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="logout.do">로그아웃</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">회원탈퇴</a></li>
						
					</ul>
				</div>

			</div>
		</div>

		<!-- //Top Navigation -->

		<div class="gnb">
			<div class="ingnb">
				<ul class="gnb_01">
					<li><a href="#"><span>통합검색</span></a></li>

					<li><a href="#"><span>여행계획</span></a></li>

					<li><a href="#"><span>그룹여행</span></a></li>

					<li><a href="#"><span>여행후기</span></a></li>

					<li><a href="#"><span>여행제휴</span></a></li>

				</ul>
			</div>
		</div>


		<div class="sch_box">
			<div class="insch">
				<form id="searchForm" class="searchform cf">
					<input type="text" placeholder="is it me you're looking for?">
					<button type="submit">Search</button>
				</form>
			</div>
		</div>
	</div>
	</div>

</body>
</html>