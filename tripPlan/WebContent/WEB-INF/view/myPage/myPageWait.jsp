<%@ page contentType="text/html; charset=UTF-8"%>

<style>
#bg {
	position: absolute;
	left: 0px;
	top: 0px;
	height: 100%;
	width: 100%;
	background: #ffffff;
	background:
		url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPHJhZGlhbEdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgY3g9IjUwJSIgY3k9IjUwJSIgcj0iNzUlIj4KICAgIDxzdG9wIG9mZnNldD0iNDAlIiBzdG9wLWNvbG9yPSIjZmZmZmZmIiBzdG9wLW9wYWNpdHk9IjEiLz4KICAgIDxzdG9wIG9mZnNldD0iMTAwJSIgc3RvcC1jb2xvcj0iI2JiYmJiYiIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgPC9yYWRpYWxHcmFkaWVudD4KICA8cmVjdCB4PSItNTAiIHk9Ii01MCIgd2lkdGg9IjEwMSIgaGVpZ2h0PSIxMDEiIGZpbGw9InVybCgjZ3JhZC11Y2dnLWdlbmVyYXRlZCkiIC8+Cjwvc3ZnPg==);
	background: -moz-radial-gradient(center, ellipse cover, #ffffff 40%, #bbbbbb 100%);
	background: -webkit-gradient(radial, center center, 0px, center center, 100%,
		color-stop(40%, #ffffff), color-stop(100%, #bbbbbb));
	background: -webkit-radial-gradient(center, ellipse cover, #ffffff 40%, #bbbbbb 100%
		);
	background: -o-radial-gradient(center, ellipse cover, #ffffff 40%, #bbbbbb 100%);
	background: -ms-radial-gradient(center, ellipse cover, #ffffff 40%, #bbbbbb 100%);
	background: radial-gradient(ellipse at center, #ffffff 40%, #bbbbbb 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff',
		endColorstr='#bbbbbb', GradientType=1);
}

.contact * {
	-webkit-backface-visibility: hidden;
}

.paper:hover {
	color: #000;
}

.contact {
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -125px;
	margin-top: -125px;
	height: 250px;
	width: 250px;
	border-radius: 2px;
	-ms-border-radius: 2px;
	-moz-border-radius: 2px;
	-o-border-radius: 2px;
	-webkit-border-radius: 2px;
}

.contact .envelope {
	position: absolute;
	height: 93px;
	width: 165px;
	left: 50%;
	margin-left: -83px;
	top: 50%;
	margin-top: -50px;
	background: #F9F9F9;
	transition: margin-top 300ms;
	-ms-transition: margin-top 300ms;
	-moz-transition: margin-top 300ms;
	-o-transition: margin-top 300ms;
	-webkit-transition: margin-top 300ms;
}

.contact:hover .envelope {
	transition-delay: 150ms;
	-ms-transition-delay: 150ms;
	-moz-transition-delay: 150ms;
	-o-transition-delay: 150ms;
	margin-top: -20px;
}

.contact .envelope .top {
	position: absolute;
	top: -3px;
	left: 0px;
	width: 100%;
	height: 73px;
	z-index: 30;
	overflow: hidden;
	transform-origin: top;
	-ms-transform-origin: top;
	-moz-transform-origin: top;
	-o-transform-origin: top;
	-webkit-transform-origin: top;
	transition: transform 300ms 150ms, z-index 0ms 150ms, height 300ms 0ms,
		top 300ms 0ms;
	-ms-transition: -ms-transform 300ms 150ms, z-index 0ms 150ms, height
		300ms 0ms, top 300ms 0ms;
	-moz-transition: -moz-transform 300ms 150ms, z-index 0ms 150ms, height
		300ms 0ms, top 300ms 0ms;
	-o-transition: -o-transform 300ms 150ms, z-index 0ms 150ms, height 300ms
		0ms, top 300ms 0ms;
	-webkit-transition: -webkit-transform 300ms 150ms, z-index 0ms 150ms,
		height 300ms 0ms, top 300ms 0ms;
}

.contact:hover .envelope .top {
	transition: transform 300ms 0ms, height 300ms 150ms, top 300ms 150ms;
	-ms-transition: -ms-transform 300ms 0ms, height 300ms 150ms, top 300ms
		150ms;
	-moz-transition: -moz-transform 300ms 0ms, height 300ms 150ms, top 300ms
		150ms;
	-o-transition: -o-transform 300ms 0ms, height 300ms 150ms, top 300ms
		150ms;
	-webkit-transition: -webkit-transform 300ms 0ms, height 300ms 150ms, top
		300ms 150ms;
	height: 10px;
	top: -60px;
	transform: rotateX(180deg);
	-ms-transform: rotateX(180deg);
	-moz-transform: rotateX(180deg);
	-o-transform: rotateX(180deg);
	-webkit-transform: rotateX(180deg);
}

.contact .envelope .outer {
	position: absolute;
	bottom: 0px;
	left: 0px;
	border-left: 83px solid transparent;
	border-right: 82px solid transparent;
	border-top: 70px solid #EEE;
}

.contact .envelope .outer .inner {
	position: absolute;
	left: -81px;
	top: -73px;
	border-left: 81px solid transparent;
	border-right: 80px solid transparent;
	border-top: 68px solid #fb5948;
}

.contact .envelope .bottom {
	position: absolute;
	z-index: 20;
	bottom: 0px;
	left: 2px;
	border-left: 81px solid transparent;
	border-right: 80px solid transparent;
	border-bottom: 45px solid #fb5948;
}

.contact .envelope .left {
	position: absolute;
	z-index: 20;
	top: 0px;
	left: 0px;
	border-left: 81px solid #fb5948;
	border-top: 45px solid transparent;
	border-bottom: 45px solid transparent;
}

.contact .envelope .right {
	position: absolute;
	z-index: 20;
	top: 0px;
	right: 0px;
	border-right: 80px solid #fb5948;
	border-top: 45px solid transparent;
	border-bottom: 45px solid transparent;
}

.contact .envelope .cover {
	position: absolute;
	z-index: 15;
	bottom: 0px;
	left: 0px;
	height: 55%;
	width: 100%;
	background: #EEE;
}

.contact .envelope .paper {
	position: absolute;
	height: 83px;
	padding-top: 10px;
	width: 100%;
	top: 0px;
	left: 0px;
	background: #F9F9F9;
	z-index: 10;
	transition: margin-top 300ms 0ms;
	-ms-transition: margin-top 300ms 0ms;
	-moz-transition: margin-top 300ms 0ms;
	-o-transition: margin-top 300ms 0ms;
	-webkit-transition: margin-top 300ms 0ms;
}

.contact:hover .envelope .paper {
	margin-top: -60px;
	transition: margin-top 300ms 150ms;
	-ms-transition: margin-top 300ms 150ms;
	-moz-transition: margin-top 300ms 150ms;
	-o-transition: margin-top 300ms 150ms;
	-webkit-transition: margin-top 300ms 150ms;
}

.contact .envelope .paper a {
	position: relative;
	display: block;
	font-size: 14px;
	margin: 5px;
	margin-bottom: 0px;
	text-align: center;
	color: #333;
	text-decoration: none;
}

.contact .envelope .paper a {
	color: #333;
	transition: color 200ms;
	-ms-transition: color 200ms;
	-moz-transition: color 200ms;
	-o-transition: color 200ms;
	-webkit-transition: color 200ms;
}

.contact .envelope .paper a:hover {
	color: gray;
}

.contact .envelope .paper a.call:hover .i {
	border-color: #DDD;
}

.contact .envelope .paper a.mail .i {
	position: absolute;
	top: 0px;
	left: 17px;
	display: inline-block;
	font-size: 13px;
	font-weight: bold;
}
.img-in-letter {
	position: relative;
	left: 40;
}
.text-in-letter {
	margin-top: 10;
	font-size: 11;
	text-align: center;
}
</style>
<div id="bg">
	<div class="contact">
		<div class="envelope">
			<div class="top">
				<div class="outer">
					<div class="inner"></div>
				</div>
			</div>
			<div class="bottom"></div>
			<div class="left"></div>
			<div class="right"></div>
			<div class="cover"></div>
			<div class="paper">
				<img class="img-in-letter" src="/tripPlan/assets/images/logo-header-gray.png">
				<div class="text-in-letter"> 이메일 인증을 해주세요</div>
			</div>
		</div>
	</div>
</div>
