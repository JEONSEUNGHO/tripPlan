<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<link rel="stylesheet" href="/tripPlan/assets/css/boardSearch.css">
<link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel="stylesheet" href="/tripPlan/assets/css/boardNavigation.css">
<link rel="stylesheet" href="/tripPlan/assets/css/boardContents.css">
<link href="/tripPlan/assets/css/after_header.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<script src="/tripPlan/assets/js/pathContents.js"></script>
<title>Insert title here</title>
<style type="text/css">
div#resume {
  min-width: 310px;
  font: 16px Helvetica, Avernir, sans-serif;
  line-height: 24px;
  color: #000
}

div#resume h1 {
  margin: 0 0 16px 0;
  padding: 0 0 16px 0;
  font-size: 42px;
  font-weight: bold;
  letter-spacing: -2px;
  border-bottom: 1px solid #999;
  line-height: 50px
}

div#resume h2 {
  font-size: 20px;
  margin: 0 0 6px 0;
  position: relative
}

div#resume h2 span {
  position: absolute;
  bottom: 0;
  right: 0;
  font-style: italic;
  font-family: Georgia, serif;
  font-size: 16px;
  color: #999;
  font-weight: normal
}

div#resume p {
  margin: 0 0 16px 0
}

div#resume a {
  color: #999;
  text-decoration: none;
  border-bottom: 1px dotted #999
}

div#resume a:hover {
  border-bottom-style: solid;
  color: #000
}

div#resume p.objective {
  font-family: Georgia, serif;
  font-style: italic;
  color: #666
}

div#resume dt {
  font-style: italic;
  font-weight: bold;
  font-size: 18px;
  text-align: right;
  padding: 0 26px 0 0;
  width: 150px;
  border-right: 1px solid #999
}

div#resume dl {
  display: table-row
}

div#resume dl dt,
div#resume dl dd {
  display: table-cell;
  padding-bottom: 20px
}

div#resume dl dd {
  width: 500px;
  padding-left: 26px
}

div#resume img {
  float: right;
  padding: 10px;
  background: #fff;
  margin: 0 30px;
  -webkit-transform: rotate(-4deg);
          transform: rotate(-4deg);
  box-shadow: 0 0 4px rgba(0, 0, 0, .3);
  width: 50%;
  max-width: 500px
}

@media screen and (max-width:1100px) {
  div#resume h2 span {
    position: static;
    display: block;
    margin-top: 2px
  }
}

@media screen and (max-width:550px) {
  body {
    margin: 1rem
  }
  div#resume img {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg)
  }
}

@media screen and (max-width:400px) {
  div#resume dl dt {
    border-right: none;
    border-bottom: 1px solid #999
  }
  div#resume dl,
  div#resume dl dd,
  div#resume dl dt {
    display: block;
    padding-left: 0;
    margin-left: 0;
    padding-bottom: 0;
    text-align: left;
    width: 100%
  }
  div#resume dl dd {
    margin-top: 6px
  }
  div#resume h2 {
    font-style: normal;
    font-weight: 400;
    font-size: 18px
  }
  div#resume dt {
    font-size: 20px
  }
  h1 {
    font-size: 36px;
    margin-right: 0;
    line-height: 0
  }
  div#resume img {
    margin: 0
  }
}

@media screen and (max-width:320px) {
  body {
    margin: 0
  }
  img {
    margin: 0;
    margin-bottom: -40px
  }
  div#resume {
    width: 320px;
    padding: 12px;
    overflow: hidden
  }
  p,
  li {
    margin-right: 20px
  }
}

</style>
<!--                       -->
<style type="text/css">
.media{text-align:center}

.thumbnail{
  width:250px;
  height:150px;
  border:1px solid #0ff;
  display:inline-block;
  overflow:hidden;
  margin:5px;
  cursor:zoom-in;
}
.thumbnail:hover img{opacity:0.7}
.thumbnail img{
  width:100%;
  height:auto;
}
.thumb-viewer{
position: relative;
	top: 120px;
	width: 100%;
	min-height: 70%;
	margin-top: 120px;
	display:none;
}
.view-open{overflow:hidden;}
.view-open .thumb-viewer{
  display:block;
  background:rgba(0,0,0,0.7);
  position:fixed;
  left:0; right:0; top:0; bottom:0;  
}
.viewer-body{
  margin:auto;
  width:800px;
  position:absolute;
  height:300px;
  left:0; right:0; top:0; bottom:0;
  text-align:center;
}
.viewer-body img{
  width:auto;
  max-width:800px;
  height:600px;
}
.prev, .next{
  display:inline-block;
  width:35px;
  height:35px;
  border-top:5px solid #bbb;
  border-left:5px solid #bbb;
  transform:rotate(-45deg);
  -moz-transform:rotate(-45deg);
  -webkit-transform:rotate(-45deg);
  cursor:pointer;
  position: absolute;
  top:0;
  bottom:0;
  left:15px;
  margin:auto 15px;
  opacity:0.6;
  z-index:5;
}
.next{
  border:none;
  border-bottom:5px solid #bbb;
  border-right:5px solid #bbb;
  left:auto;
  right:15px;
}
.close{
  color:#fff;
  position: absolute;
  right:15px;
  top:5px;
  font-size:32px;
  font-family: Helvetica;
  font-weight:lighter;
  opacity:0.6;
  cursor:pointer;
}
.prev:hover, .next:hover, .close:hover{opacity:1;}
</style>
<!--                       -->
</head>
<body>

<div id="body">
<div class="main-container">
  <section id="timeline" class="timeline-outer">
    <div class="container" id="content">
      <div class="row">
        <div class="col s12 m12 l12">
        <div id="resume">
  <img src="${boardContents[0].b_mainphoto }" alt="Trip Plan">
  <h1 class="blue-text lighten-1 header">${boardContents[0].b_title }</h1>
<dl>
  <dt>작성자
  <dd>
    <p align="left">${boardContents[0].m_nickname }</p>
</dl>
<dl>
<dt>여행 일자
<dd>
<p align="left">${boardContents[0].b_startdate } ~ ${boardContents[0].b_enddate }
</dl>
<dl>
<dt>소개
<dd>
<p align="left">${boardContents[0].b_maincontents }
</dl>
<dl>
<dt>총 경비
<dd>
<p align="left">${totalCost } 원
</dl>
<dl>
<dt>문의
<dd>
<p align="left"><a>${boardContents[0].m_email }</a>
</dl>
	</div>
          <div class="timeline">
          	<c:forEach var="subList" items="${boardContents }">
	            <div class="event" data-date="${subList.sb_tripdate }">
          
	            <div class="media">
	            <c:if test="${subList.sb_photo1 != null}">
				   <a class="thumbnail">
				    <img src="${subList.sb_photo1 }">
				   </a>
				</c:if>
				<c:if test="${subList.sb_photo2 != null}">
				   <a class="thumbnail">
				    <img src="${subList.sb_photo2 }">
				   </a>
				</c:if>
				<c:if test="${subList.sb_photo3 != null}">
				   <a class="thumbnail">
				    <img src="${subList.sb_photo3 }">
				   </a>
				</c:if>
				<c:if test="${subList.sb_photo4 != null}">
				   <a class="thumbnail">
				    <img src="${subList.sb_photo4 }">
				   </a>
				</c:if>
				<c:if test="${subList.sb_photo5 != null}">
				   <a class="thumbnail">
				    <img src="${subList.sb_photo5 }">
				   </a>
				</c:if>
				</div>


				<div class="thumb-viewer">
				    <a class="prev"></a>
				    <a class="next"></a>
				    <a class="close">x</a>
				  <div class="viewer-body"></div>
				 </div>
<hr/>
				<div id="resume">
				<dl>
				  <dt>소제목
				  <dd>
				    <p align="left">${subList.sb_subtitle }</p>
				</dl>
				<dl>
				  <dt>내용
				  <dd>
				    <p align="left">${subList.sb_subcontent }</p>
				</dl>
				<dl>
				  <dt>경비
				  <dd>
				    <table>
				    	<tr>
				    		<td>교통비</td><td>${subList.sb_tcharge } 원</td>
				    	</tr>
				    	<tr>
				    		<td>식비</td><td>${subList.sb_fcharge } 원</td>
				    	</tr>
				    	<tr>
				    		<td>숙박비</td><td>${subList.sb_rcharge } 원</td>
				    	</tr>
				    </table>
				</dl>
	              </div>
	            </div>
 					
            </c:forEach>
          </div>
          <form method="post" action="insertReply.do">
	          		<p class="bg-info" align="center"><strong style="font-size:25px; margin:10px;">댓글</strong></p>
	          	<c:forEach var="replylist" items="${replyList }">
					<c:if test="${size >0 }">
						<div class="row">
						  <div class="col-md-7">${replylist.re_contents }</div>
						  <div class="col-md-2">${replylist.re_registdate }</div>
						  <div class="col-md-2">${replylist.m_email }</div>
						  <div class="col-md-1">
						  <c:if test="${m_email eq replylist.m_email }">
								<input type="button" class="btn btn-danger btn-xs" value="x" onclick="location.href='deleteReply.do?re_id=${replylist.re_id}&b_id=${boardContents[0].b_id }'">
						  </c:if>
						  </div>
						</div>
					</c:if> 
					<c:if test="${size ==0 }">
						<div class="row">
						  <div class="col-md-12">댓글이 없습니다.</div>
						</div>
					</c:if>       	
	          	</c:forEach>
	          	<hr/>
	          		<input type="hidden" name="b_id" value="${boardContents[0].b_id}">
	          		<div class="row">
					    <div class="col-md-11">
					      <input type="text" name="re_contents" class="form-control" placeholder="100자 이내로 작성해주세요." required="required">
					    </div>
					    <div class="col-md-1">
					    	<input type="submit" class="btn btn-primary" value="등록">
					    </div>
					</div>
          </form>
        </div>
      </div>
    </div>
  </section>
  <br/>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
<script src="/tripPlan/assets/js/boardNavigation.js"></script>
</div>
</body>
</html>