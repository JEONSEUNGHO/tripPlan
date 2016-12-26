<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body {
	margin-top: 50px;
	text-align: center;
}
</style>
<script type="text/javascript">
	function check() {
		cbox = deleteform.chk;
		if (cbox.length) { // 여러 개일 경우
			for (var i = 0; i < cbox.length; i++) {
				cbox[i].checked = deleteform.allcheck.checked;
			}
		} else { // 한 개일 경우
			cbox.checked = deleteform.allcheck.checked;
		}
	}
</script>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th><label><input type="checkbox" value=""></label></th>
					<th width="150">제목</th>
					<th>받은이</th>
					<th>날짜</th>
					<th>수신확인</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${count == 0}">
					<table>
						<tr class="danger">
							<td align="center">게시판에 저장된 글이 없습니다.</td>
						</tr>
					</table>
				</c:if>
				<c:if test="${count > 0}">
					<table>
						<tr>
							<th><label><input type="checkbox" name="allcheck"
									onclick="check()"></label></th>
							<th>제목</th>
							<th>받은이</th>
							<th>날짜</th>
							<th>수신확인</th>
						</tr>
						<c:forEach var="send" items="${sendList}">
							<th><input type="checkbox" name="chk"
								value="${send.sm_receiver}" /></th>
							<th>${send.sm_title}</th>
							<th>${send.sm_id}</th>
							<th>${send.sm_date}</th>
							<th>${send.sm_check}</th>
							<c:if test="${send.sm_check ==0}">
								<th>미확인</th>
							</c:if>
							<c:if test="${send.sm_check ==1}">
								<th>확인</th>
							</c:if>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${count > 0}">
					<c:set var="pageCount"
						value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
					<c:set var="pageBlock" value="${10}" />
					<fmt:parseNumber var="result" value="${currentPage / 10}"
						integerOnly="true" />
					<c:set var="startPage" value="${result * 10 + 1}" />
					<c:set var="endPage" value="${startPage + pageBlock-1}" />
					<c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}" />
					</c:if>

					<c:if test="${startPage > 10}">
						<a href="#?pageNum=${startPage - 10 }">[이전]</a>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="#?pageNum=${i}">[${i}]</a>
					</c:forEach>

					<c:if test="${endPage < pageCount}">
						<a href="#?pageNum=${startPage + 10}">[다음]</a>
					</c:if>
				</c:if>
			</tbody>
		</table>
		<input type="submit" class="btn btn-info" value="선택삭제"> <a
			href="#" class="btn btn-info" role="button">취소</a>
	</div>

</body>
</html>