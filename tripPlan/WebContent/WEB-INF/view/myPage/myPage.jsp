<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<!-- 캐쉬 제거 -->
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</head>

<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<script src="/tripPlan/assets/js/jquery-ui-1.8.21.custom.min.js"></script>

<script>
	// 뒤로가기 방지
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
						$.ajax({
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
							$.ajax({
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
				$('#searchBar').focus();
			}
		});
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
				$('#searchBar').focus();
			}
		});
		list();
	}

	// 이미지 업로드 처리
	function previewImageBeforeUpload() {
		var element = $('.preview-img-upload');
		var reader;

		function readURL(input, selector) {
			if (input.files && input.files[0]) {
				reader = new FileReader();
				reader.onload = function(e) {
					selector.parents('.preview-img-upload').addClass('active')
							.find('.preview-img').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			}
		}

		$(document.body).on('change', '.preview-img-upload input', function() {
			readURL(this, $(this));
		});

	}
	previewImageBeforeUpload();
	var m_profile = $('.load-img').attr('src');
	$(function() {
		$('.remove-image').click(
				function() {

					$(this).parents('.preview-img-upload')
							.removeClass('active').find('.preview-img').attr(
									'src', '');
					$(this).parents('.preview-img-upload').find('input')
							.val('');
				});
	});

	// 비밀번호 변경 tab - 기존비밀번호 일치 여부 처리
	$(function() {
		$('#m_pass')
				.keyup(
						function() {
							$
									.ajax({
										type : "POST",
										url : "/tripPlan/tiles/passchk.do",
										data : "m_pass=" + $('#m_pass').val(),
										dataType : "json",
										success : function(args) {
											if (args.data == "YES") {
												$('#passchk')
														.html(
																'<b style="font-size:15px;color:#1ec800">비밀번호가 일치합니다</b>');
												$('.changepass-btn').attr(
														'disabled', false);
											} else if (args.data == "NO") {
												$('#passchk')
														.html(
																'<b style="font-size:15px;color:#fb5948">비밀번호가 일치하지 않습니다</b>');
												$('.changepass-btn').attr(
														'disabled', true);
											}
										},
										error : function(e) { // 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
											alert(e.responseText);
										}
									});
						});
	});

	$(function() {
		$('#m_pass1')
				.keyup(
						function() {
							var m_pass1 = $("#m_pass1").val();

							if (m_pass1
									.match(/(?=.*[a-zA-Z])(?=.*[!@#$%^&*()`\"'+-./])(?=.*[0-9]).{8,16}$/)) {
								$('#passsecure')
										.html(
												'<b style="font-size:15px;color:#1ec800">확인</b>');

							} else {
								$('#passsecure')
										.html(
												'<b style="font-size:15px;color:#fb5948">숫자/특수문자를 포함해 8자 이상 입력하세요</b>');
							}

						});
	});
	$(function() {
		$('#m_pass2')
				.keyup(
						function() {
							var m_pass1 = $("#m_pass1").val();
							var m_pass2 = $("#m_pass2").val();

							if (m_pass1 == m_pass2) {
								$('#passconfirm')
										.html(
												'<b style="font-size:15px;color:#1ec800">확인</b>');
							} else {
								$('#passconfirm')
										.html(
												'<b style="font-size:15px;color:#fb5948">비밀번호가 일치하지 않습니다</b>');
							}
						});
	});
	$(function() {
		$('#m_pass2')
				.keyup(
						function() {
							$('#m_pass1')
									.keyup(
											function() {
												var m_pass1 = $("#m_pass1")
														.val();
												var m_pass2 = $("#m_pass2")
														.val();

												if (m_pass1 == m_pass2) {
													$('#passconfirm')
															.html(
																	'<b style="font-size:15px;color:#1ec800">확인</b>');
												} else {
													$('#passconfirm')
															.html(
																	'<b style="font-size:15px;color:#fb5948">비밀번호가 일치하지 않습니다</b>');
												}
											});
						});
	});

	// 비밀번호 유효성 검사
	function validation() {
		var m_pass1 = $("#m_pass1").val();
		var m_pass2 = $("#m_pass2").val();

		if (m_pass1
				.match(/(?=.*[a-zA-Z])(?=.*[!@#$%^&*()`\"'+-./])(?=.*[0-9]).{8,16}$/)) {
			$('#passsecure').html(
					'<b style="font-size:15px;color:#1ec800">확인</b>');
			if (m_pass1 == m_pass2) {
				$('#passconfirm').html(
						'<b style="font-size:15px;color:#1ec800">확인</b>');
				$('.changepass-btn').attr('disabled', false);
				return true;
			} else {
				$('#passconfirm')
						.html(
								'<b style="font-size:15px;color:#fb5948">비밀번호가 일치하지 않습니다</b>');
				return false;
			}
		} else {
			$('#passsecure')
					.html(
							'<b style="font-size:15px;color:#fb5948">숫자/특수문자를 포함해 8자 이상 입력하세요</b>');
			return false;
		}
	}

	// 슬라이드 이펙트 기능
	function slideEffect() {
		var bottom = $(this);
		var runner = $(this).prev();
		var reset = $(this).next();
		$(this > '.bottom-cover').hide();
		// 한 번만 클릭되게 하기 위해 click 이벤트 제거 
		bottom.unbind('click');
		reset.unbind('click');
		
		runner.slider({
			value : 0,
			min : 0,
			max : 50,
			slide : function(e, ui) {
				chop(ui.value)
			}
		});
		function chop(val) {
			bottom.attr('data-val', val);
			runner.attr('data-val', val);
		}

		var start = setTimeout(function() {
			var c = 0;
			var interval = setInterval(function() {
				runner.slider("value", c);
				bottom.attr('data-val', c);
				runner.attr('data-val', c);
				c += 9;
				if (c > 46) {
					clearInterval(interval);
				}
			}, 25);
		}, 500)

		reset.css({
			opacity : 1,
			transition : 'opacity 2s ease-in-out'
		});

		reset.bind('click', recoveryEffect);
	}

	// 슬라이드 복구 기능
	function recoveryEffect() {
		var bottom = $(this).prev();
		var runner = bottom.prev();
		var reset = $(this);
		bottom.children('.bottom-cover').hide();
		reset.unbind('click');
		bottom.unbind('click');

		runner.slider("value", 0);
		bottom.attr('data-val', 0);
		runner.attr('data-val', 0);
		bottom.bind('click', slideEffect);

		reset.css({
			opacity : 0,
			transition : 'opacity 0.5s ease-in-out'
		});
	}

	// 하단 클릭 시 슬라이드 이벤트 발생 & ajax 실행
	$(function() {
		$('.bottom').bind('click', slideEffect);

	});

	// 복구 버튼 클릭 시 복구 & ajax 실행
	$(function() {
		$('#reset').bind('click', recoveryEffect);
	});

	$(function() {
		$('.bottom-cover').hide();
		
		$('.bottom').hover(function() {
			$(this).find('.bottom-cover').show();
		},
		function() {
			$('.bottom-cover').hide();
		
		});
	});
</script>
<style>
html {
	height: 100%;
	background-color: #f5f8fa; 
}
body {
	padding: 0;
	margin: 0;
	text-rendering: optimizeLegibility;
	-webkit-font-smoothing: antialiased;
}

.page-container {
	margin-right: auto;
	margin-left: auto;
	padding-left: 15px;
	padding-right: 15px
}

@media ( min-width :768px) {
	.page-container {
		margin-top: 10px;
		width: 750px
	}
}

@media ( min-width :992px) {
	.page-container {
		margin-top: 10px;
		width: 970px
	}
}

@media ( min-width :1200px) {
	.page-container {
		margin-top: 10px;
		width: 1170px
	}
}

#form-search {
	width: 100%;
}

/* 오른쪽 사이드바 */
.left_container {
	width: 18%;
	text-align: center;
	height: 73%;
	position: fixed;
	right: 17%;
	top: 120;
	margin-top: 15;
}

.container_ui {
	width: 100%;
	overflow-x: scroll;
	background: #Fff;
	height: 100%;
	border: 1px solid #ccc;
	border-radius: 10px;
	-webkit-transition-property: opacity, top;
	transition-property: opacity, top;
	-webkit-transition-duration: 0.4s;
	transition-duration: 0.4s;
	-webkit-animation: pop .5s forwards;
	animation: pop .5s forwards;
}

.container_ui__heading {
	text-align: center;
	height: 45px;
	width: 100%;
	background: #fb5948;
}

.container_ui__heading h1 {
	color: #fff;
	text-transform: uppercase;
	font-weight: 700;
	height: 10px;
	position: relative;
	margin: 0;
	font-size: 15px;
	float: left;
	width: 100%;
	letter-spacing: 1px;
	line-height: 50px;
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
	margin: 23px 0px 0px 75px;
	padding-top: 0px;
}

.container_ui__item h3 {
	font-size: 13px;
	font-weight: 800;
	margin: 5px 0px 10px 75px;
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
	width: 40;
	height: 40;
	position: absolute;
	top: 15;
	left: 10;
	border-radius: 50%;
	border: none;
	margin: 5;
}

.btn-primary {
	position: absolute;
	top: 20;
	right: 5;
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
	background-color: #fff;
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
	left: 30%;
	width: 220px;
	height: 70%;
	margin-left: -220px;
	border: 1px solid #ccc;
	border-radius: 10px;
	background-color: #fff;
}

.side-bar>li>a {
	color: #666;
	width: 220px;
}

.side-bar li a:hover, .side-bar li a:focus, .side-bar li a:active {
	background-color: #fb5948;
	color: #fff;
}

.tab-content {
	position: absolute;
	top: 100;
	left: 31%;
	width: 33%;
}

.nav-tabs {
	float: left;
	border-bottom: 0;
}

.nav-tabs li {
	float: none;
	margin: 0 0 20 0;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover
	{
	background-color: #fb5948 !important;
	color: #fff;
}

/* text 입력 폼 */
.form-control[disabled] {
	display: inline;
	width: 70%;
}

.contact-form[disabled] {
	position: relative;
	top: 25%;
	width: 40%;
	margin: 0 auto;
}

.contact-form[disabled], .form-control[disabled] {
	border: none;
	background-color: #f3f2f2;
	box-shadow: none;
	border-radius: 0;
	border-bottom: 1.5px solid #f3f2f2;
	font-weight: bold;
	font-size: 17px;
}

.contact-form[disabled] .send-msg {
	width: 75%;
	color: #F3F2F2;
	height: 35px;
	background-color: #33adff;
	margin-top: 10px;
}

/* font-awesome 아이콘 색상 */
.fa {
	color: #666;
}

/* 성별 라디오 버튼 */
.male {
	margin-right: 3%;
}

/* 이미지 영역 */
#preview-img {
	width: 80;
	height: 80;
	border-radius: 50%;
}

.choose_file {
	position: relative;
	display: inline-block;
	border-radius: 8px;
	padding: 4px 6px 4px 8px;
	margin-top: 2px;
}

.choose_file input[type="file"] {
	-webkit-appearance: none;
	position: absolute;
	top: 0;
	left: 0;
	opacity: 0;
}

.btn-file input[type="file"] {
	outline: none;
	background: white;
	cursor: inherit;
}

form .input-holder {
	width: 300px;
	height: 35px;
	margin-bottom: 14px;
	display: block;
	position: relative;
	/* background-color: rgba(255,255,255,0.1); */
	border-bottom: 2px solid rgba(255, 255, 255, 0.9);
}

form .input-holder input {
	width: 300px;
	height: 35px;
	background-color: transparent;
	border: none;
	color: #fff;
}

form .input-holder input:focus {
	outline: none;
}

form .input-holder.submit {
	background-color: #fff;
	border: none;
	border-radius: 3px;
	margin-top: 15px;
	margin-bottom: 0;
}

form .upload-image {
	width: 300px;
	text-align: left;
}

form .upload-image .input-holder, form .upload-image .preview-img-holder
	{
	width: 80px;
	height: 80px;
	border: 2px solid #33adff;
	border-radius: 50%;
	display: inline-block;
	text-align: center;
	cursor: pointer;
	box-sizing: border-box;
	vertical-align: middle;
}

form .upload-image .input-holder .icon, form .upload-image .preview-img-holder .icon
	{
	display: inline-block;
	font-size: 30px;
	color: #33adff;
	margin-top: 25px;
}

.preview-img-upload .preview-img-holder {
	width: 80px;
	height: 80px;
	display: none !important;
	border: none !important;
	position: relatvie;
	margin-bottom: 50px;
}

.preview-img-upload .preview-img-holder .remove-image {
	width: 20px;
	height: 20px;
	position: relative;
	top: 15;
	left: 30;
	background-color: red;
	color: #fff;
	border-radius: 50%;
	font-size: 11px;
	padding: 5px 0;
	box-sizing: border-box;
}

.preview-img-upload .preview-img-holder .img-holder {
	width: 100%;
	height: 100%;
	border-radius: 50%;
	overflow: hidden;
}

.preview-img-upload .preview-img-holder .img-holder img {
	width: 100%;
	min-height: 100%;
}

.preview-img-upload.active .preview-img-holder {
	display: inline-block !important;
}

.preview-img-upload.active .load-img {
	width: 80px;
	height: 80px;
	display: none !important;
	border: none !important;
	position: relative;
	margin-bottom: 14px;
}

.load-img {
	width: 80px;
	height: 80px;
	text-align: center;
	border-radius: 50%;
	position: relative;
	margin-bottom: 30px;
	margin-top: 14;
	display: inline-block !important;
}

.preview-img-upload.active .input-holder {
	display: none;
}
/* 비밀번호 변경 */
#passchk, #passsecure, #passconfirm {
	display: block;
	width: 100%;
	margin-left: 15;
}

.form-group {
	width: 300;
}

#m_pass, #m_pass1, #m_pass2 {
	width: 70%;
	display: inline-block;
	background-color: #F3f2f2;
}

.changepass-btn {
	width: 75%;
	color: #f3f2f2;
	height: 35;
	background-color: #33adff;
	transition: all 0.5s ease-out;
	margin-top: 10px;
}

.changepass-btn:hover {
	height: 35;
	background-color: #2273aa;
	color: #f3f2f2;
}

/* 수정하기 버튼 영역 */
.send-msg {
	width: 75%;
	color: #F3F2F2;
	height: 35px;
	background-color: #33adff;
	transition: all 0.5s ease-out;
	margin-top: 10px;
}

.send-msg:hover {
	height: 35px;
	background-color: #2273aa;
	color: #f3f2f2;
}

.update {
	position: absolute;
}

.inputgroup {
	width: 50%;
}

.fade-out {
	background-color: #70c1b3;
	width: 30%;
	color: #fff;
	position: absolute;
	top: 15;
	left: 32.5%;
	font-size: 14;
	padding: 15px;
	border-radius: 3px;
	-webkit-animation: fade-out 5s linear forwards;
	animation: fade-out 5s linear forwards;
	opacity: 1;
}

@
-webkit-keyframes fade-out { 100% {
	opacity: 0;
}

}
@
keyframes fade-out { 100% {
	opacity: 0;
}

}

/* 타임라인 */
.section {
	width: 80%;
	margin: 0 auto;
	position: relative;
}

.section .top, .section .bottom {
	border-radius: 15px;
	width: 100%;
	background: linear-gradient(to right, rgba(0, 0, 0, 0.03),
		rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.03)), #fffae6;
	z-index: 0;
	cursor: pointer;
	box-shadow: 0 0px 2px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
	transition: all 0.2s ease-in-out;
}

.section .top:hover, .section .bottom:hover {
	box-shadow: 0 7px 14px rgba(0, 0, 0, 0.19), 0 6px 6px
		rgba(0, 0, 0, 0.23);
}

.top {
	height: 150;
}

.bottom {
	height: 60;
}

.bottom-cover {
	position: absolute;
	top: -45;
	height: 60;
	z-index: 1;
	border-radius: 15px;
	width: 100%;
	background-color: #ccc;
	color: #fff;
	font-size: 30;
	text-align: center;
	cursor: pointer;
	border: none;
	opacity: 0.9;
}

.section .runner {
	width: 100%;
	height: 20px;
	margin: 0 0 -20;
	border-top: 1px dashed #ccc;
	position: relative;
	z-index: 12345;
}

.bottom[data-val="0"] {
	border-radius: 20px;
	width: 100%;
	background: linear-gradient(to right, rgba(0, 0, 0, 0.03),
		rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.03)), #fffae6;
	z-index: 0;
	cursor: pointer;
	box-shadow: 0 0px 2px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
	transition: all 0.2s ease-in-out;
	height: 60;
}

.bottom[data-val="9"] {
	border-top-left-radius: 18% 3.6px;
	transform: rotate(-0.63deg);
	transform-origin: 18% top;
}

.bottom-cover[data-val="9"] {
	opacity: 0;
}

.bottom[data-val="18"] {
	border-top-left-radius: 36% 7.2px;
	transform: rotate(-1.26deg);
	transform-origin: 36% top;
}

.bottom-cover[data-val="18"] {
	opacity: 0;
}

.bottom[data-val="27"] {
	border-top-left-radius: 54% 10.8px;
	transform: rotate(-1.89deg);
	transform-origin: 54% top;
}

.bottom-cover[data-val="27"] {
	opacity: 0;
}

.bottom[data-val="36"] {
	border-top-left-radius: 72% 14.4px;
	transform: rotate(-2.52deg);
	transform-origin: 72% top;
}

.bottom-cover[data-val="36"] {
	opacity: 0;
}

.bottom[data-val="45"] {
	border-top-left-radius: 90% 18px;
	transform: rotate(-3.15deg);
	transform-origin: 90% top;
	transition: margin-top 0.5s ease-in, transform 0.5s ease-in,
		background-color 0.2s ease, opacity 0.2s linear 0.2s;
	opacity: 0;
}

.bottom-cover[data-val="45"] {
	opacity: 0;
}

#reset {
	position: absolute;
	display: block;
	left: 47%;
	opacity: 0;
	top: 77%;
	font-size: 20;
	width: 30px;
	height: 30px;
	border-radius: 15px;
	background-color: transparent;
}

.timeline-lists {
	position: relative;
	margin-left: 0;
	list-style: none;
}

.timeline-items {
	background: #fff;
	border: 1px solid #e1e8ed;
	background-clip: padding-box;
	margin-bottom: 30px;
}

.timeline-items:hover {
	background: #f5f8fa;
	border-left: 1px solid #e1e8ed;
	border-right: 1px solid #e1e8ed;
	background-clip: padding-box;
}

.timeline-item {
	border-bottom: 1px solid #e1e8ed;
	cursor: pointer;
	position: relative;
	padding: 9px;
	min-height: 51px;
}

.timeline-content {
	margin-left: 58;
}

.user-image {
	width: 50;
	height: 50;
	border-radius: 10%;
	margin-left: -58;
}

/* 티켓 영역 */
.ticket-img {
	position: absolute;
	top: 30;
	left: 15%;
	opacity: 0.2;
	width: 70%;
	height: 100;
}

.top-container {
	width: 100%;
	height: 15;
	position: absolute;
	top: 0;
	background-color: #99b3be;
	border-radius: 15px 15px 0 0;
}

.bottom-container {
	width: 100%;
	height: 15;
	position: absolute;
	bottom: 0;
	background-color: #99b3be;
	border-radius: 0 0 15px 15px;
}

.point {
	position: absolute;
	top: 30;
	left: 100;
	color: #666;
	font-size: 20;
	font-weight: 900;
}
.end-point {
	margin-left: 110;
}
.date {
	position: absolute;
	top: 55;
	color: #666;
}
.comment {
	margin-left: 58;
	position: relative;
	height: auto;
}
.my-profile {
	width: 40;
	height: 40;
	border-radius: 50%;
	margin: 5 5 5 -30px;
}
#footer {
	display: none;
}
</style>
<div id="body">
	<div class="page-container">
		<c:set var="check" value="${param.check}" />
		<c:if test="${check == 1 }">
			<div class="fade-out one">
				<i class="fa fa-thumbs-up" style="color: #fff;" aria-hidden="true"></i>
				수정되었습니다
			</div>
		</c:if>
		<!-- 왼쪽 사이드바 -->
		<div id="sidebar">
			<ul class="nav nav-tabs side-bar" id="myTab">
				<li class="active"><a href="#timeline" data-toggle="tab"
					aria-expanded="true"> <i class="fa fa-newspaper-o"
						aria-hidden="true"> </i>&nbsp;&nbsp;&nbsp;타임라인
				</a></li>
				<li class=""><a href="#mymap" data-toggle="tab"
					aria-expanded="false"> <i class="fa fa-map-o"
						aria-hidden="true"> </i>&nbsp;&nbsp;&nbsp;내 경로
				</a></li>
				<li class=""><a href="#favorite" data-toggle="tab"
					aria-expanded="false"> <i class="fa fa-heart-o"
						aria-hidden="true"> </i>&nbsp;&nbsp;&nbsp;찜목록
				</a></li>
				<li class=""><a href="#profile" data-toggle="tab"
					aria-expanded="false"> <i class="fa fa-user-o"
						aria-hidden="true"> </i>&nbsp;&nbsp;&nbsp;프로필 수정
				</a></li>
				<c:set var="m_identified" value="${m_identified}" />
				<c:if test="${m_identified == 1}">
					<li class=""><a href="#password" data-toggle="tab"
						aria-expanded="false"> <i class="fa fa-lock"
							aria-hidden="true"> </i>&nbsp;&nbsp;&nbsp;비밀번호 변경
					</a></li>
				</c:if>
			</ul>
		</div>
		<!-- 왼쪽 사이드바 상세 페이지 -->
		<div id="tab-content" class="tab-content">
			<!-- 타임라인 -->
			<div class="tab-pane fade active in" id="timeline">
				<div class="timeline-lists">
					<ol class="timeline-list">

						<!-- 반복문 시작 -->
						<li class="timeline-items">
							<div class="timeline-item">
								<div class="timeline-content">
									<a class="user-profile" href=""> <img class="user-image"
										src="/tripPlan/assets/images/default-user-image.png"></a> <strong
										class="user-nickname">라온하늬</strong>님이 <strong class="title">3박4일
											오사카 투어~!!</strong>경로를 작성했습니다.
									<!-- 티켓  -->
									<div class="section">
										<!-- 티켓 상단 -->
										<div class="top">
											<!-- 티켓 왼쪽 이미지 영역 -->
											<div class="top-container">
												<img class="ticket-img"
													src="/tripPlan/assets/images/boarding-pass.png">
												<!-- text를 강조하기 위해 사진배경을 어둡게 하는 기능 -->
												<!-- 로고와 서브 타이틀을 입력하기 위한 container -->
												<div class="logo-container">
													<!-- 출발지 / 도착지 -->
													<div class="point">
														<span class="start-point">검암역</span>  
														<span class="end-point">오사카</span>
													</div>
													<!-- 출발일 / 도착일 -->
													<div class="date">
														<span class="start-date">2016/09/11</span> 
														<span class="start-date">2016/09/15</span>
													</div>
												</div>
											</div>
										</div>
										<!-- // top -->
										<!-- 점선 -->
										<div class="runner"></div>
										<!-- 티켓 하단 -->
										<div class="bottom">
											<div class="bottom-container">
												<!-- 티켓 하단 hover -->
											<button class="bottom-cover">
												<i class="fa fa-scissors" aria-hidden="true"></i>&nbsp;스크랩
											</button>
											</div>
										</div>
										<div id="reset"><i
											class="fa fa-repeat" aria-hidden="true"></i></div> 
									</div>
										
								</div>
								<!-- // section -->

							</div>
							<!-- timeline-content -->
							<div class="comment">
							
							<!-- 불러온 댓글 -->
							
							
								<!-- 댓글 달기 -->
								<img class="my-profile"
										src="/tripPlan/assets/images/default-user-image.png"> 
								<input type="text" class="comment-content">
							</div>
						</li>
						
							<li class="timeline-items">
							<div class="timeline-item">
								<div class="timeline-content">
									<a class="user-profile" href=""> <img class="user-image"
										src="/tripPlan/assets/images/default-user-image.png"></a> <strong
										class="user-nickname">라온하늬</strong>님이 <strong class="title">3박4일
											오사카 투어~!!</strong>경로를 작성했습니다.
									<!-- 티켓  -->
									<div class="section">
										<!-- 티켓 상단 -->
										<div class="top">
											<!-- 티켓 왼쪽 이미지 영역 -->
											<div class="top-container">
												<img class="ticket-img"
													src="/tripPlan/assets/images/boarding-pass.png">
												<!-- text를 강조하기 위해 사진배경을 어둡게 하는 기능 -->
												<!-- 로고와 서브 타이틀을 입력하기 위한 container -->
												<div class="logo-container">
													<!-- 출발지 / 도착지 -->
													<div class="point">
														<span class="start-point">검암역</span>  
														<span class="end-point">오사카</span>
													</div>
													<!-- 출발일 / 도착일 -->
													<div class="date">
														<span class="start-date">2016/09/11</span> 
														<span class="start-date">2016/09/15</span>
													</div>
												</div>
											</div>
										</div>
										<!-- // top -->
										<!-- 점선 -->
										<div class="runner"></div>
										<!-- 티켓 하단 -->
										<div class="bottom">
											<div class="bottom-container">
												<!-- 티켓 하단 hover -->
											<button class="bottom-cover">
												<i class="fa fa-scissors" aria-hidden="true"></i>&nbsp;스크랩
											</button>
											</div>
										</div>
										<div id="reset" title="reset"><i
											class="fa fa-repeat" aria-hidden="true"></i></div>
									</div>
								</div>
								<!-- // section -->

							</div>
							<!-- timeline-content -->
							<div class="comment">
							
							<!-- 불러온 댓글 -->
							
							
								<!-- 댓글 달기 -->
								<img class="my-profile"
										src="/tripPlan/assets/images/default-user-image.png"> 
								<input type="text" class="comment-content">
							</div>
						</li>
						
						
							<li class="timeline-items">
							<div class="timeline-item">
								<div class="timeline-content">
									<a class="user-profile" href=""> <img class="user-image"
										src="/tripPlan/assets/images/default-user-image.png"></a> <strong
										class="user-nickname">라온하늬</strong>님이 <strong class="title">3박4일
											오사카 투어~!!</strong>경로를 작성했습니다.
									<!-- 티켓  -->
									<div class="section">
										<!-- 티켓 상단 -->
										<div class="top">
											<!-- 티켓 왼쪽 이미지 영역 -->
											<div class="top-container">
												<img class="ticket-img"
													src="/tripPlan/assets/images/boarding-pass.png">
												<!-- text를 강조하기 위해 사진배경을 어둡게 하는 기능 -->
												<!-- 로고와 서브 타이틀을 입력하기 위한 container -->
												<div class="logo-container">
													<!-- 출발지 / 도착지 -->
													<div class="point">
														<span class="start-point">검암역</span>  
														<span class="end-point">오사카</span>
													</div>
													<!-- 출발일 / 도착일 -->
													<div class="date">
														<span class="start-date">2016/09/11</span> 
														<span class="start-date">2016/09/15</span>
													</div>
												</div>
											</div>
										</div>
										<!-- // top -->
										<!-- 점선 -->
										<div class="runner"></div>
										<!-- 티켓 하단 -->
										<div class="bottom">
											<div class="bottom-container">
												<!-- 티켓 하단 hover -->
											<button class="bottom-cover">
												<i class="fa fa-scissors" aria-hidden="true"></i>&nbsp;스크랩
											</button>
											</div>
										</div>
										<div id="reset" title="reset"><i
											class="fa fa-repeat" aria-hidden="true"></i></div>
									</div>
								</div>
								<!-- // section -->

							</div>
							<!-- timeline-content -->
							<div class="comment">
							
							<!-- 불러온 댓글 -->
							
							
								<!-- 댓글 달기 -->
								<img class="my-profile"
										src="/tripPlan/assets/images/default-user-image.png"> 
								<input type="text" class="comment-content">
							</div>
						</li>
						
						
					</ol>
				</div>
			</div>
			<!-- 내 경로 -->
			<div class="tab-pane fade" id="mymap">my map</div>
			<!-- 찜목록 -->
			<div class="tab-pane fade" id="favorite">my favorite</div>
			<!-- 프로필 수정  -->
			<div class="tab-pane fade" id="profile">
				<!-- input 태그를 감싸는 form -->
				<form action="profile.do" method="post"
					enctype="multipart/form-data">
					<div class="controls">
						<div class="form-group" id="nickname">
							<span><i class="fa fa-envelope"></i></span> <input
								name="m_nickname" type="email"
								class="form-input-text form-control" value="${m_email}" disabled />
						</div>

						<div class="form-group" id="nickname">
							<span><i class="fa fa-user"></i></span> <input name="m_nickname"
								class="form-input-text form-control" value="${m_nickname}"
								disabled />
						</div>

						<!-- 성별 영역 -->
						<c:set var="sex" value="${m_sex}" />
						<c:choose>
							<c:when test="${sex eq 'M'}">
								<div class="form-group">
									<span class="male"> <span><i class="fa fa-male"></i></span>
										<input type="radio" name="m_sex" value="M" checked="checked" />
									</span> <span class="female"> <span><i
											class="fa fa-female"></i></span> <input type="radio" name="m_sex"
										value="F" disabled />
									</span>
								</div>
							</c:when>
							<c:when test="${sex eq 'F'}">
								<div class="form-group">
									<span class="male"> <span><i class="fa fa-male"></i></span>
										<input type="radio" name="m_sex" value="M" disabled />
									</span> <span class="female"> <span><i
											class="fa fa-female"></i></span> <input type="radio" name="m_sex"
										value="F" checked="checked" />
									</span>
								</div>
							</c:when>
						</c:choose>


						<!-- 나이대 영역  -->
						<div class="form-group">
							<span><i class="fa fa-birthday-cake"></i></span> <select
								name="m_agerange">
								<c:if test="${m_agerange eq '10'}">
									<option value="10" selected>10대</option>
									<option value="20">20대</option>
									<option value="30">30대</option>
									<option value="40">40대</option>
									<option value="50">50대 이상</option>
								</c:if>
								<c:if test="${m_agerange eq '20'}">
									<option value="10">10대</option>
									<option value="20" selected>20대</option>
									<option value="30">30대</option>
									<option value="40">40대</option>
									<option value="50">50대 이상</option>
								</c:if>
								<c:if test="${m_agerange eq '30'}">
									<option value="10">10대</option>
									<option value="20">20대</option>
									<option value="30" selected>30대</option>
									<option value="40">40대</option>
									<option value="50">50대 이상</option>
								</c:if>
								<c:if test="${m_agerange eq '40'}">
									<option value="10">10대</option>
									<option value="20">20대</option>
									<option value="30">30대</option>
									<option value="40" selected>40대</option>
									<option value="50">50대 이상</option>
								</c:if>
								<c:if test="${m_agerange eq '50'}">
									<option value="10">10대</option>
									<option value="20">20대</option>
									<option value="30">30대</option>
									<option value="40">40대</option>
									<option value="50" selected>50대 이상</option>
								</c:if>
							</select>
						</div>


						<!-- 프로필 이미지 영역 -->
						<div class="upload-image preview-img-upload">


							<c:set var="m_profile" value="${m_profile }" />

							<c:choose>
								<c:when test="${m_profile eq null}">
									<img class="load-img"
										src="/tripPlan/assets/images/default-user-image.png">
									<div class="preview-img-holder">
										<span class="remove-image fa fa-times"></span>
										<div class="img-holder">
											<img class="preview-img" src="">
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<img class="load-img" src="${m_profile}">
									<div class="preview-img-holder">
										<span class="remove-image fa fa-times"></span>
										<div class="img-holder">
											<img class="preview-img" src="">
										</div>
									</div>
								</c:otherwise>
							</c:choose>
							<div class="choose_file">
								<span class="btn btn-default btn-file btn-xs"><i
									class="fa fa-camera"></i>&nbsp;&nbsp;이미지 업로드<input type="file"
									id="upload" name="uploadImg" accept="image/*" value=""></span>
							</div>
						</div>
						<!-- submit 버튼 영역  -->
						<div class="send-button">
							<button type="submit" class="btn btn-send send-msg">
								<b>수정</b>
							</button>
						</div>

					</div>
				</form>
			</div>
			<!-- 비밀번호 변경  -->
			<div class="tab-pane fade" id="password">
				<div class="controls">
					<form action="pass.do" method="POST">
						<h3 style="margin-bottom: 25px;">비밀번호 변경</h3>
						<div class="form-group">
							<span><i class="fa fa-lock"></i></span> <input type="password"
								id="m_pass" name="m_pass" placeholder="기존 비밀번호"
								class="form-input-text form-control"> <span id="passchk"></span>
						</div>
						<div class="form-group">
							<span><i class="fa fa-lock"></i></span> <input type="password"
								id="m_pass1" name="m_pass1" placeholder="새 비밀번호"
								class="form-input-text form-control"> <span
								id="passsecure"></span>
						</div>
						<div class="form-group">
							<span><i class="fa fa-lock"></i></span> <input type="password"
								id="m_pass2" name="m_pass2" placeholder="비밀번호 확인"
								class="form-input-text form-control"> <span
								id="passconfirm"></span>
						</div>
						<!-- submit 버튼 영역  -->
						<div class="send-button">
							<button type="submit" class="btn btn-send changepass-btn"
								disabled onclick="return validation();">
								<b>수정</b>
							</button>
						</div>

					</form>
				</div>
			</div>
		</div>

		<!-- 오른쪽 사이드바 -->
		<div class='left_container'>
			<div class='container_ui'>
				<div class='container_ui__heading'>
					<h1>Following</h1>
				</div>
				<div id="searchMenu">
					<i class="fa fa-search" id="searchIcon"></i> <input
						name="searchUser" type="text" id="searchBar"
						placeholder="찾으실 닉네임 또는 이메일을 입력하세요." required />
				</div>
				<div class="inner"></div>


			</div>

		</div>
	</div>
</div>
