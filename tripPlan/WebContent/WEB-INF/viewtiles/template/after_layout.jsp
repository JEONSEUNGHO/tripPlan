<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
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
.dropdown {
	width: 60px;
	height: 60px;
	position: absolute;
	top: 20;
	right: 0;
	background-color: transparent;
	color: #fff;
	border-radius: 50%;
	border: none;
	font-size: 11px;
	padding: 5px 0;
	box-sizing: border-box;
	disply: block;
}

.userImg {
	width: 60px;
	height: 60px;
	position: absolute;
	top: 10;
	right: 4;
	background-color: transparent;
	color: #fff;
	border-radius: 50%;
	border: none;
	font-size: 11px;
	padding: 5px 0;
	box-sizing: border-box;
	disply: block;
}


</style>
<body>

	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />
</body>
</html>
