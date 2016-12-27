<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<link href="/tripPlan/assets/css/path.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
<div id="body">
<form method="post" action="createBoard.do">
	<article class="page">
	  <h2>여행 계획</h2>
	  <table width="400" border="1">
	  	<tr>
	  		<td width="100">제목 </td>
	  		<td width="200"><input type="text" name="maintitle"></td>
	  		<td width="100">
	  		<select id="board-identified" name="identified">
	  			<option>후기</option>
	  			<option>계획</option>
	  			<option>그룹</option>
	  		</select></td>
	  	</tr>
	  	<tr>
	  		<td width="100" colspan="1">메인사진 선택</td><td width="300" colspan="2"><input type="file" name="mainphoto"/></td>
	  	</tr>
	  	<tr>
	  		<td colspan="3" width="400"><textarea rows="10" cols="50" name="maincontents"></textarea></td>
	  	</tr>
	  </table>
	</article>
	<input type="submit" class="btn btn-success controls" value="다음"/>
</form>
</div>
</body>
</html>