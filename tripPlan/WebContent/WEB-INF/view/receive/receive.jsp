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
				<tr height="30">
					<td align="center"><input type="checkbox" value="rm_check" onclick="check()"></td>
					<td align="center">제목</td>
					<td align="center">보낸이</td>
					<td align="center">날짜</td>
					<td align="center">수신확인</td>
				</tr>
			</thead>

			<tbody>

				<c:if test="${count == 0}">
					<table>
						<tr height="30" class="danger">
							<td align="center">게시판에 저장된 글이 없습니다.</td>
						</tr>
					</table>
				</c:if>

				<c:if test="${count > 0}">
					<table>
						<c:forEach var="receive" items="${receiveList}">
							<tr height="30">
								<td align="center"><input type="checkbox" name="rm_check" /></td>
								<td align="center"><a href="content.do?num=${receive.rm_id}&pageNum=${currentPage}">
								${receive.rm_title}</a></td>
								<td align="center">${receive.rm_sender}</td>
								<td align="center">${receive.rm_date}</td>
								<c:if test="${receive.rm_check == 0}">
									<th>미확인</th>
								</c:if>
								<c:if test="${receive.rm_check == 1}">
									<th>확인</th>
								</c:if>
							</tr>
						</c:forEach>
					</table>

					<!-- 목록 아래 페이지 처리  -->
					<c:if test="${count > 0}">
						<table>
							<tr height="30">

								<c:set var="pageCount"
									value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
								<c:set var="pageBlock" value="${5}" />
								<fmt:parseNumber var="result" value="${currentPage / 5}"
									integerOnly="true" />
								<c:set var="startPage" value="${result * 5 + 1}" />
								<c:set var="endPage" value="${startPage + pageBlock-1}" />
								<c:if test="${endPage > pageCount}">
									<c:set var="endPage" value="${pageCount}" />
								</c:if>

								<c:if test="${startPage > 5}">
									<a href="receive.do?pageNum=${startPage - 5 }">[이전]</a>
								</c:if>
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<a href="receive.do?pageNum=${i}">[${i}]</a>
								</c:forEach>

								<c:if test="${endPage < pageCount}">
									<a href="receive.do?pageNum=${startPage + 5}">[다음]</a>
								</c:if>
							</tr>
						</table>
					</c:if>
				</c:if>
			</tbody>
		</table>
		<input type="submit" class="btn btn-info" value="선택삭제"> <a
			href="#" class="btn btn-info" role="button">취소</a>
	</div>
</body>
</html>