<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<style>
/* 입력 폼 css */
body {
	background-color: #F3F2F2;
}

.form-control {
	display: inline;
	width: 70%;
}

.form-group {
	margin-bottom: 5%;
}

.contact-form {
	position: relative;
	top: 25%;
	width: 40%;
	margin: 0 auto;
}

#memberInfo {
	position: relative;
	left: 10%;
}

#email {
	margin-top: 7%;
}

.contact-form .form-control {
	border: none;
	background-color: #F3F2F2;
	box-shadow: none;
	border-radius: 0;
	border-bottom: 1px solid #bbc0d0;
	transition: 0.5s ease;
	font-weight: bold;
	font-size: 17px;
}

.contact-form .form-control:focus {
	transition: 0.5s ease;
	border-bottom: 1px solid #33adff;
}

.contact-main  .contact-main-title h2 {
	margin-top: 0;
}
/* 다음 버튼 */
.contact-form .send-msg {
	width: 75%;
	color: #F3F2F2;
	height: 35px;
	background-color: #33adff;
	transition: all 0.5s ease-out;
	margin-top: 10px;
}

.contact-form .send-msg:hover {
	height: 35px;
	background-color: #2273aa;
}
/* 회원가입 아이콘 색상 */
.fa {
	color: #666;
}

a, a:hover {
	color: #999;
	text-decoration: none;
	background: none;
	outline: none;
}

.btn {
	font-size: 17px;
}

.error {
	font-size: 15px;
	color: #ff9800;
	display: block;
	margin-left: 5%;
}

#back {
	font-size: 14px;
}

.logo-img {
	position: relative;
	left: 27%;
	bottom: 30px;
}

.error-box {
	font-size: 15px;
	background-color: #ff9800;
	color: #fff;
	padding-top: 2%;
	padding-bottom: 2%;
	padding-right: 20%;
	padding-left: 20%;
	text-align: center;
	vertical-align: middle;
	border-radius: 4px;
	margin-top: 25px;
	margin-bottom: 20px;
}

.naver-login {
	font-size: 17px;
	background-color: #1ec800;
	color: #fff;
	padding-top: 0.5%;
	padding-bottom: 1%;
	width: 75%;
	text-align: center;
	vertical-align: middle;
	border-radius: 4px;
	margin-top: 10px;
	margin-bottom: 10px;
}

.naver-logo {
	float: left;
	margin-left: 15px;
}

.text {
	margin-right: 45px;
}
</style>
<script>
$(function(){
    $('#m_email').blur(function(){
        $.ajax({
            type:"POST"
            ,url:"/tripPlan/tiles/idchk.do"
            ,data:"m_email="+ $('#m_email').val()
            ,dataType:"json"
            ,success:function(args){
                if(args.data == "YES"){
                    $('#idchk').html('<b style="font-size:15px;color:#1ec800">사용가능한 이메일입니다.</b>');
                    $('.btn-send').attr('disabled',false);
                }else if(args.data == "NO"){
                    $('#idchk').html('<b style="font-size:15px;color:#fb5948">등록된 이메일입니다.</b>');
                    $('.btn-send').attr('disabled',true);
                    $('#m_email').focus();
                } else if(args.data == "ERROR"){
                	$('#idchk').html('<b style="font-size:15px;color:#ff9800">입력오류입니다.</b>');
                	$('.btn-send').attr('disabled',true);
                	$('#m_email').focus();
                }
            }
    	    ,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
    	    	alert(e.responseText);
    	    }
        });    
    });
});

</script>

<div class="contact-form">
	<!-- 로고 이미지 -->
	<a class="logo-img" href="main.do"><img
		src="/tripPlan/assets/images/logo-middle-gray.png"></a>
	<!-- input 태그를 감싸는 form -->
	<form:form action="regist.do" method="post" commandName="memberInfo">
		<div class="controls">
			<!-- 유효성 검사 에러시 출력되는 박스 -->
			<form:errors class="error-box" />
			<!-- // 유효성 검사 에러시 출력되는 박스 -->
			<div class="form-group" id="email">
				<span><i class="fa fa-envelope"></i></span>
				<form:label path="m_email"></form:label>
				<form:input type="email" path="m_email" placeholder="이메일"
					value="${param.m_email}" class="form-input-text form-control" />
				<span id="idchk"></span>
				<form:errors class="error" path="m_email" />
			</div>
			<div class="form-group">
				<span><i class="fa fa-lock"></i></span>
				<form:label path="m_pass"></form:label>
				<form:input type="password" path="m_pass" placeholder="비밀번호"
					class="form-input-text form-control" />
				<form:errors class="error" path="m_pass" />
			</div>
			<div class="form-group">
				<span><i class="fa fa-lock"></i></span>
				<form:label path="m_pass2"></form:label>
				<form:input type="password" path="m_pass2" placeholder="비밀번호 확인"
					class="form-input-text form-control" />
				<form:errors class="error" path="m_pass2" />
			</div>

			<div class="send-button">
				<button type="submit" class="btn btn-send send-msg">
					<b>다음</b>
				</button>
			</div>
			<!-- 네이버 아이디로 로그인 -->
			<div class="naver-login">
				<a class="naver-login" href="${url}"><img class="naver-logo"
					src="/tripPlan/assets/images/logo-naver.png" /> <span class="text"><b>네이버</b>&nbsp;
						<b>아이디로</b>&nbsp; <b>로그인</b></span></a>
			</div>

			<a href="main.do"> <!-- font-awesome 로그인 아이콘 --> <i
				class="fa fa-chevron-left"></i> &nbsp;&nbsp;<span id="back">메인으로</span>
			</a>
		</div>
	</form:form>
</div>