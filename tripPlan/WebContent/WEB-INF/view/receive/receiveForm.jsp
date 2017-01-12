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
body {
  background: linear-gradient(#ccc, #fff);
  font: 14px sans-serif;
}
.letter {
  background: #fff;
  box-shadow: 0 0 10px rgba(0,0,0,0.3);
  margin: 10px auto 0;
  max-width: 550px;
  min-height: 300px;
  padding: 0 24 0 24px;
  position: relative;
  width: 80%;
}
.letter:before, .letter:after {
  content: "";
  height: 98%;
  position: absolute;
  width: 100%;
  z-index: -1;
}
.letter:before {
  background: #fafafa;
  box-shadow: 0 0 8px rgba(0,0,0,0.2);
  left: -5px;
  top: 4px;
  transform: rotate(-2.5deg);
}
.letter:after {
  background: #f6f6f6;
  box-shadow: 0 0 3px rgba(0,0,0,0.2);
  right: -3px;
  top: 1px;
  transform: rotate(1.4deg);
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
<div class="letter">
	<div class="container">
		<form>
			<div class="receiver">
				<input type="text" class="form-control" id="receiver" value="${receive.rm_sender}" disabled>
			</div>
			<div class="title">
				<input type="text" class="form-control" id="title" value="${receive.rm_title}" disabled>
			</div>
			<div class="comment">
  				<textarea class="form-control" rows="10" id="comment" style="resize: none;" disabled>${receive.rm_contents}</textarea>
			</div>
			<div class="bttn">
				<a href="sendwrite.do?sm_receiver=${receive.rm_sender}" class="btn btn-info" role="button">답장</a>
				<a href="receive.do" class="btn btn-info" role="button">목록</a>
			</div>
		</form>
	</div>
</div>
</body>
</html>
