<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${check==0 }">
	<script type="text/javascript">
		alert("생성에 실패했습니다.");
	</script>
	<meta http-equiv="Refresh" content="0;url=main.do" >
</c:if>
<c:if test="${check!=0 }">
	<script type="text/javascript">
		alert("해당 게시물이 생성되었습니다.");
	</script>
	<meta http-equiv="Refresh" content="0;url=main.do" >
</c:if>
	
</body>
</html>