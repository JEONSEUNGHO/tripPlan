<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<script src="/tripPlan/assets/js/regFormSecond.js" ></script>

<style>
body {
	background-color: #F3F2F2;
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

.logo-img {
	position: relative;
	left: 27%;
	bottom: 30px;
}
/* text 입력 폼 */
.form-control {
	display: inline;
	width: 70%;
}

#memberInfo {
	position: relative;
	left: 10%;
}

#nickname {
	margin-top: 7%;
	margin-bottom: 5%;
}

.contact-form {
	position: relative;
	top: 25%;
	width: 40%;
	margin: 0 auto;
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
	border-bottom: 1px solid #2abfcc;
}

.contact-main  .contact-main-title h2 {
	margin-top: 0;
}

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
/* // text 입력 폼 */

/* font-awesome 아이콘 색상 */
.fa {
	color: #666;
}

/* 성별 라디오 버튼 */
.male {
	margin-right: 3%;
}

.radio-label {
	display: inline;
	padding-left: 1% !important;
}

/* 나이대 영역 */
.select-label {
	position: relative;
	display: inline-block;
	margin: 30px 0 0;
}

/* // 나이대 영역 */

/* 이미지 영역 */
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
	margin-top: 10px;
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
	position: relative;
	margin-bottom: 14px;
}

.preview-img-upload .preview-img-holder .remove-image {
	width: 20px;
	height: 20px;
	position: absolute;
	top: 0;
	right: 0;
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

.preview-img-upload.active .input-holder {
	display: none;
}

#back {
	font-size: 12px;
}

.error {
	font-size: 15px;
	color: #ff9800;
	display: block;
	margin-left: 5%;
}

.error-box {
	color: #fff;
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
</style>


<div class="contact-form">
	<!-- 로고 이미지 -->
	<a class="logo-img" href="main.do"><img
		src="/tripPlan/assets/images/logo-middle-gray.png"></a>
	<!-- input 태그를 감싸는 form -->
	<form:form action="mypage.do" commandName="memberInfo"
		enctype="multipart/form-data">
		<div class="controls">
			<!-- 유효성 검사 에러시 출력되는 박스 -->
			<form:errors class="error-box" />
			<!-- // 유효성 검사 에러시 출력되는 박스 -->

			<!-- 이전 페이지에서 가져온 정보 -->
			<form:hidden path="m_email" value="${memberInfo.m_email}" />
			<form:hidden path="m_pass" value="${memberInfo.m_pass}" />
			<!-- // 이전 페이지에서 가져온 정보 -->
			<div class="form-group" id="nickname">
				<span><i class="fa fa-user"></i></span>
				<form:label path="m_nickname"></form:label>
				<form:input path="m_nickname" placeholder="닉네임"
					class="form-input-text form-control" />
				<form:errors class="error" path="m_nickname" />
			</div>

			<!-- 성별 영역 -->
			<c:set var="sex" value="${memberInfo.m_sex}" />
			<c:choose>
				<c:when test="${sex eq 'M'}">
					<div class="form-group">
						<span class="male"> <span><i class="fa fa-male"></i></span>
							<form:label class="radio-label" path="m_sex" /> <form:radiobutton
								path="m_sex" value="M" checked="checked" />
						</span> <span class="female"> <span><i class="fa fa-female"></i></span>
							<form:label class="radio-label" path="m_sex" /> <form:radiobutton
								path="m_sex" value="F" /> <form:errors class="error"
								path="m_sex" />
						</span>
					</div>
				</c:when>
				<c:when test="${sex eq 'F'}">
					<div class="form-group">
						<span class="male"> <span><i class="fa fa-male"></i></span>
							<form:label class="radio-label" path="m_sex" /> <form:radiobutton
								path="m_sex" value="M" />
						</span> <span class="female"> <span><i class="fa fa-female"></i></span>
							<form:label class="radio-label" path="m_sex" /> <form:radiobutton
								path="m_sex" value="F" checked="checked" /> <form:errors
								class="error" path="m_sex" />
						</span>
					</div>
				</c:when>
				<c:otherwise>
					<div class="form-group">
						<span class="male"> <span><i class="fa fa-male"></i></span>
							<form:label class="radio-label" path="m_sex" /> <form:radiobutton
								path="m_sex" value="M" />
						</span> <span class="female"> <span><i class="fa fa-female"></i></span>
							<form:label class="radio-label" path="m_sex" /> <form:radiobutton
								path="m_sex" value="F" /> <form:errors class="error"
								path="m_sex" />
						</span>
					</div>
				</c:otherwise>
			</c:choose>


			<!-- 나이대 영역  -->
			<div class="form-group">
				<span><i class="fa fa-birthday-cake"></i></span>
				<form:label path="m_agerange" class="select-label" />
				<form:select path="m_agerange" value="${memberInfo.m_agerange}">
					<form:option value="" label="--- 선택하세요 ---" />
					<form:option value="10" label="10대" />
					<form:option value="20" label="20대" />
					<form:option value="30" label="30대" />
					<form:option value="40" label="40대" />
					<form:option value="50" label="50대 이상" />
				</form:select>
				<form:errors class="error" path="m_agerange" />
			</div>


			<!-- 프로필 이미지 영역 -->
			<div class="upload-image preview-img-upload">
				<span class="input-title"></span>
				<div class="preview-img-holder">
					<span class="remove-image fa fa-times"></span>
					<div class="img-holder">
						<img class="preview-img" src="" alt="image" draggable="false" />
					</div>
				</div>
				<label class="input-holder"><span class="icon fa fa-user"></span>
					<input class="hide" type="file" name="uploadImg" accept="image/*" />
				</label>
			</div>
			
			<!-- submit 버튼 영역  -->
			<div class="send-button">
				<button type="submit" class="btn btn-send send-msg">
					<b>가입</b>
				</button>
			</div>
			<!-- // submit 버튼 영역  -->
			<a href="regist.do?m_email=${memberInfo.m_email}" > <!-- font-awesome 아이콘 --> <i
				class="fa fa-chevron-left"></i> &nbsp;&nbsp;<span id="back">뒤로가기</span>
			</a>
		</div>
	</form:form>
	<!-- // input 태그를 감싸는 form -->
</div>




