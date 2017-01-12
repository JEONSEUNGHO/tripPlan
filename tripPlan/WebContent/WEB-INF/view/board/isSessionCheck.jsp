<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionCheck==0 }">
	<script type="text/javascript">
		alert("세션이 종료되었습니다. \n다시 로그인 해주세요");
	</script>
	<meta http-equiv="Refresh" content="0;url=main.do" >
</c:if>
<c:if test="${sessionCheck!=0 }">
	<script type="text/javascript">
		alert("세션이 종료되었습니다. \n다시 로그인 해주세요");
	</script>
	<meta http-equiv="Refresh" content="0;url=main.do" >
</c:if>
</body>
</html>