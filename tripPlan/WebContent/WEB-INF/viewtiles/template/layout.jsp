<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>

<title><tiles:getAsString name="title" /></title>
<!-- favicon 설정 -->
<link rel="shortcut icon" href="/tripPlan/assets/ico/favicon.ico"
	type="image/x-icon" />
<!-- bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/tripPlan/assets/css/bootstrap.min.css" />
<!-- font-awesome  -->
<link rel="stylesheet" type="text/css"
	href="/tripPlan/assets/css/font-awesome.min.css" />
<!-- 나눔고딕 웹 폰트 적용 -->
<link rel="stylesheet" type="text/css"
	href="/tripPlan/assets/css/nanumfont.css" />
<!-- Javascript -->
<script src="/tripPlan/assets/js/jquery-3.1.1.min.js"></script>
<script src="/tripPlan/assets/js/bootstrap.min.js"></script>
</head>
<style>
/* 전체 화면 */
html, body {
	margin: 0px;
	padding: 0px;
}
/* anchar태그 색상 */
a, a:hover, a:active, a:focus {
	color: #999;
}

/* 헤더 navbar */
.navbar-wrapper {
	position: absolute;
	top: 20;
	left: 0;
	right: 0;
	z-index: 20;
}
#text {
	font-size: 12px;
}
/* 로고 */
.navbar-brand {
	margin-top: -5;
}

.navbar-wrapper .nav>li>a:focus, .navbar-wrapper .nav>li>a:hover,
	.footer-wrapper .nav>li>a:focus, .footer-wrapper .nav>li>a:hover {
	color: none;
	text-decoration: none;
	background: none;
	outline: none;
}

.navbar-nav>li {
	margin-right: 15;
}

footer {
	margin: 0;
	padding: 0;
	padding: 20px 0;
	min-width: 100%;
}

footer, footer a, footer a:hover, footer a:active, footer a:visited,
	footer a:focus {
	color: #999;
	text-decoration: none;
}

address {
	clear: both;
	color: #999;
	font-size: 0.85em;
	line-height: 1;
}

.footer-wrapper {
	position: absolute;
	bottom: 0;
	text-align: center;
	padding: 0;
}

.footer_menu {
	float: none;
}

.footer_menu.nav li {
	float: none;
	display: inline-block;
	margin-left: 0;
}

.footer_menu li:last-child {
	border-right: none;
}

.address {
	margin-right: 20px;
}
</style>
<body>
<tiles:insertAttribute name="header" />

<tiles:insertAttribute name="body" />

<tiles:insertAttribute name="footer" />
</body>
</html>
