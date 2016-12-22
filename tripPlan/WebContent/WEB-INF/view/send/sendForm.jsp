<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<link href="/assets/css/note.css" rel="stylesheet" >
<html>
<head>
<style>
body {
  text-align: center;
  
}
#receiver {
	margin-top: 50px;
	margin-bottom: 10px;
	
}
#title {
	margin-bottom: 10px;
	
}
#comment {
	margin-bottom: 10px;
	
}

</style>
<title>쪽지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<form>
			<div class="send">
				<input type="text" class="form-control" id="send" value="${letter. }" placeholder="받는 사람">
			</div>
			<div class="title">
				<input type="text" class="form-control" id="title" placeholder="제목">
			</div>
			<div class="comment">
  				<textarea class="form-control" rows="10" id="comment" placeholder="내용"></textarea>
			</div>
			<div class="bttn">
				<input type="submit" class="btn btn-info" value="보내기">
				<a href="#" class="btn btn-info" role="button">취소</a>
			</div>
		</form>
	</div>

</body>
</html>
