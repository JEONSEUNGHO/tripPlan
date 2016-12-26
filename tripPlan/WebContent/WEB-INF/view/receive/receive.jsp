<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>받은쪽지</title>
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
<!-- 체크한 쪽지 수 만큼 cbox배열에 저장  -->
<script type="text/javascript">
	function check() {
		cbox = deleteform.chk;
		if (cbox.length) {
			for (var i = 0; i < cbox.length; i++) {
				cbox[i].checked = deleteform.allcheck.checked;
			}
		} else {
			cbox.checked = deleteform.allcheck.checked;
		}
	}
</script>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th><label><input type="checkbox" value="" name="allcheck"
									onclick="check()"></label></th>
					<th>제목</th>
					<th>보낸이</th>
					<th>날짜</th>
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
							<th><label><input type="checkbox" ></label></th>
							<th>제목</th>
							<th>보낸이</th>
							<th>날짜</th>
						</tr>
						<c:forEach var="receive" items="${receiveList}">
							<th><input type="checkbox" name="chk"
								value="${receive.rm_id}" /></th>
							<th>${receive.rm_title}</th>
							<th>${receive.rm_sender}</th>
							<th>${receive.rm_date}</th>

						</c:forEach>
					</table>

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
						<a href="list.do?pageNum=${startPage - 10 }">[이전]</a>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="list.do?pageNum=${i}">[${i}]</a>
					</c:forEach>

					<c:if test="${endPage < pageCount}">
						<a href="list.do?pageNum=${startPage + 10}">[다음]</a>
					</c:if>
				</c:if>
			</tbody>
		</table>
		<input type="submit" class="btn btn-info" value="선택삭제"> <a
			href="#" class="btn btn-info" role="button">취소</a>
	</div>
</body>
</html>