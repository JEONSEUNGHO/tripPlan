<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>받은 쪽지함</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/tripPlan/assets/css/bootstrap.min.css">
<script src="/tripPlan/assets/js/jquery-3.1.1.min.js"></script>
<script src="/tripPlan/assets/js/bootstrap.min.js"></script>
</head>
<style>
body {
	margin-top: 10px;
	text-align: center;
}

a:link, a:hover, a:visited, a:active, a:focus {
	text-decoration: none;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		//최상단 체크박스 클릭
		$("#checkall").click(function() {
			//클릭되었으면
			if ($("#checkall").prop("checked")) {
				//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
				$("input[id=chk]").prop("checked", true);
				//클릭이 안되있으면
			} else {
				//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
				$("input[id=chk]").prop("checked", false);
			}
		})
	})
</script>
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
		<div class="btn-group">
			<a href="sendwrite.do" class="btn btn-info" role="button">쪽지 쓰기</a> <a
				href="receive.do" class="btn btn-info" role="button">받은 쪽지</a> <a
				href="send.do" class="btn btn-info" role="button">보낸 쪽지</a>
		</div>
		<table class="table">
			<thead>
				<tr height="30">
					<td align="center" style="position: absolute; left: 10;"><input
						type="checkbox" id="checkall" value="rm_check"></td>
					<td align="center" style="position: absolute; left: 170;">제목</td>
					<td align="center" style="position: absolute; right: 200;">보낸이</td>
					<td align="center" style="position: absolute; right: 50;">날짜</td>
				</tr>
			</thead>
			<tbody>

				<c:if test="${count == 0}">
					<table>
						<hr>
						<tr height="30" class="danger">
							<td style="position: absolute; left: 40%;">받은 쪽지가 없습니다.</td>
						</tr>
					</table>
				</c:if>

				<c:if test="${count > 0}">
					<table style="width: 100%; font-size: 13px;">
						<hr>
						<c:forEach var="receive" items="${receiveList}">
							<tr height="30">
								<td align="center" style="position: absolute; left: 18;"><input
									type="checkbox" id="chk" name="rm_check" /></td>

								<c:if test="${receive.rm_check == 0}">
									<td align="center" style="position: absolute; left: 8%;"><a
										href="content.do?rm_id=${receive.rm_id}&pageNum=${currentPage}"
										style="color: #FB5948;"> ${receive.rm_title}</a></td>
								</c:if>

								<c:if test="${receive.rm_check == 1}">
									<td align="center" style="position: absolute; left: 8%;"><a
										href="content.do?rm_id=${receive.rm_id}&pageNum=${currentPage}">
											${receive.rm_title}</a></td>
								</c:if>

								<td align="center"
									style="text-align: center; position: absolute; right: 170;">${receive.rm_sender}</td>
								<td align="center"
									style="text-align: center; position: absolute; right: 13;">${receive.rm_date}</td>
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
			href="javascript:window.close()" class="btn btn-info" role="button">닫기</a>
	</div>


</body>
</html>