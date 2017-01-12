<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<link href="/tripPlan/assets/css/after_header.css" rel="stylesheet">
<script>
	(function poll() {
		setTimeout(function() {
			$.ajax({
				type : "GET",
				url : "/tripPlan/tiles/realtimeCount.do",
				success : function(args) {
					$('#realtimeCount').html(args.data);
				},
				dataType : "json",
				complete : poll
			});
		}, 3000);
	})();
</script>
<title>header</title>
<nav id="header" class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar"></button>
			<a class="navbar-brand" href="mypage.do"><img
				src="/tripPlan/assets/images/logo-header-gray.png"
				 alt="triPplan"></a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<form class="navbar-form navbar-left" role="search" action="search">
				<div id="form-search" class="form-group">
					<input id="input-site-search" type="search"
						class="form-control typeahead" name="keywordsearch" value=""
						placeholder="검색어를 입력하세요">
					<!--<span id="input-site-search-clear"><i class="fa fa-times"></i></span>-->
					<input type="submit" value="검색">
					<a id="navbar-search-submit" href="#"><i class="fa fa-search"></i></a>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="createBoard.do"><i class="fa fa-pencil-square-o"></i>&nbsp;&nbsp;경로생성</a>
				</li>
				<li><a href="" onClick="window.open('/tripPlan/letter/receive.do','mypage','width=750,height=405'); return false;">
					<i class="fa fa-paper-plane-o"></i>&nbsp;&nbsp;쪽지<span style="color: #fb5948;" id="realtimeCount"></span></a>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"
					style="padding-bottom: 17px; padding-top: 17px; background-color: transparent;">
					<c:if test="${m_profile == null}">
					<img class="userImg" src="/tripPlan/assets/images/default-user-image.png">
					</c:if>
					<c:if test="${m_profile != null}">
					<img class="userImg" src="${m_profile}">
					</c:if>
					</a>
					
					<ul class="dropdown-menu" role="menu">
						<li><a href="mypage.do">마이페이지</a></li>
						<li><a href="logout.do">로그아웃</a></li>
						<li><a href="/sign_out/">회원탈퇴</a></li>
					</ul></li>
			</ul>

		</div>
		<div class="gnb">
			<div class="ingnb">
				<ul class="gnb_01">

					<li><a href="pathList">통합검색</a></li>

					<li><a href="planList.do">여행계획</a></li>

					<li><a href="groupList.do">그룹여행</a></li>

					<li><a href="reviewList.do">여행후기</a></li>

					<li><a href="#">여행제휴</a></li>

				</ul>
			</div>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
