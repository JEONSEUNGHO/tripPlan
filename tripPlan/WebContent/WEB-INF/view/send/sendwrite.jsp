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

</style>
<script>
$(function(){
    $('#m_email').blur(function(){
        $.ajax({
            type:"POST"
            ,url:"/tripPlan/tiles/idchk.do"
            ,data:"m_email="+ $('#m_email').val()
            ,dataType:"json"
            ,success:function(args){
                if(args.data == "YES"){
                    $('#idchk').html('<b style="font-size:15px;color:#1ec800">이메일이 확인되었습니다.</b>');
                    $('.btn-send').attr('disabled',false);
                }else if(args.data == "NO"){
                    $('#idchk').html('<b style="font-size:15px;color:#fb5948">이메일이 없습니다. 다시 확인해주세요.</b>');
                    $('.btn-send').attr('disabled',true);
                    $('#sm_title').focus();
                } else if(args.data == "ERROR"){
                	$('#idchk').html('<b style="font-size:15px;color:#ff9800">입력오류입니다.</b>');
                	$('.btn-send').attr('disabled',true);
                	$('#sm_contents').focus();
                }
            }
    	    ,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
    	    	alert(e.responseText);
    	    }
        });    
    });
});

</script>
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
<div class="container">
  <div class="btn-group">
    <a href="letter/sendwrite" class="btn btn-info" role="button">새쪽지</a>
    <a href="letter/receive" class="btn btn-info" role="button">받은 쪽지</a>
    <a href="letter/send" class="btn btn-info" role="button">보낸 쪽지</a>
  </div>
</div>
	<div class="container">
		<form:form action="sendwritePro.do" method="post" commandName="sendDataBean">
			<div class="send">
				<input type="text" class="form-control" name="sm_receiver" id="send" value="${letter.sm_receiver}" placeholder="받는 사람">
				<span id="idchk"></span>
			</div>
			<div class="title">
				<form:label path="sm_title" />
				<form:input type="text" class="form-control" path="sm_title" placeholder="제목"/>
				<form:errors path="sm_title" />
			</div>
			<div class="comment">
				<form:label path="sm_contents" />
  				<form:textarea class="form-control" rows="10" path="sm_contents" placeholder="내용"/>
				<form:errors path="sm_contents" />
			</div>
			<div class="bttn">
				<input type="submit" class="btn btn-info" value="보내기">
				<a href="letter/receive" class="btn btn-info" role="button">취소</a>
			</div>
		</form:form>
	</div>
</body>
</html>
