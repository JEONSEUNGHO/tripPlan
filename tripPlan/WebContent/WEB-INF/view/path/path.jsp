<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<link rel="stylesheet" href="/tripPlan/assets/css/boardSearch.css">
<title>Insert title here</title>
</head>
<body>

<div id="body">

	<c:if test="${List>0 }">
 					<c:forEach var="list" items="${member}">
 					<li class="result_item">
						<a href="#" class="item">
							<figure>
								<span class="item_category">영어 > 영어회화</span>
								<img class="my-image" src="/tripPlan/assets/images/travel.jpg" />
								<figcaption class="item_description">
									<p>
									
										<span class="item_title">${list.b_id }</span>
										<span class="item_status label label-primary">${list.b_title }</span>
										<span class="item_label label label-danger">${list.b_totalspendtime}</span>
										<span class="item_introduce"> - 해외 이민을 목표로 영어회화 스터디 하실 분 모십니다~~! </span>
									</p>
									<p>
										<span class="item_host">최순실</span> | <span class="item_date">2016.10.17</span>
									</p>
								</figcaption>
								<div class="item_entry">
									<span class="entry_number">2</span> / <span class="entry_total">4</span> 명
								</div>
							</figure>
						</a>
					</li>
 					
 					</c:forEach>
 				</c:if>

</table>
</div>
</body>
</html>