<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<style>
body {
  text-align: center;
  
}

#title {
	margin-bottom: 10px;
	
}
#comment {
	margin-bottom: 10px;
	
}

</style>

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
<script>
/* $(function(){
    $('#sm_receiver').blur(function(){
    	$.ajax({
            type:"POST"
            ,url:"/tripPlan/letter/idchk.do"
            ,data:"sm_receiver="+ $('#sm_receiver').val()
            ,dataType:"json"
            ,success:function(args){
                if(args.data == "YES"){
                    $('#idchk').html('<b style="font-size:15px;color:#1ec800">확인</b>');
                    $('#send').attr('disabled',false);
                }else if(args.data == "NO"){
                    $('#idchk').html('<b style="font-size:15px;color:#fb5948">사용자가 없습니다.</b>');
                    $('#send').attr('disabled',true);
                    $('#sm_receiver').focus();
                } else if(args.data == "ERROR"){
                	$('#idchk').html('<b style="font-size:15px;color:#ff9800">필수항목입니다.</b>');
                	$('#send').attr('disabled',true);
                	$('#sm_receiver').focus();
                }
            }
    	    ,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
    	    	alert(e.responseText);
    	    }
        });    
    });
}); */
$(function(){
	$( "#autocompleteText" ).autocomplete({
		source:  [
	    			"개발로짜",
	    			"roqkffhwk",
	    			"tistory",
	    			"gksql",
	    			"안녕하세요"
	    		 ]
	});
})
</script>
<body>
<div class="container">
  <div class="btn-group" style="margin: 10 0 10 0;">
    <a href="sendwrite.do" class="btn btn-info" role="button">쪽지 쓰기</a>
    <a href="receive.do" class="btn btn-info" role="button">받은 쪽지</a>
    <a href="send.do" class="btn btn-info" role="button">보낸 쪽지</a>
  </div>
</div>
<input id="autocompleteText" type="text" />
	<div class="container">
		<form:form action="sendwritePro.do" method="post" commandName="sendDataBean">
			<div class="send">
				<input type="text" class="form-control" name="sm_receiver" id="sm_receiver" value="${letter.sm_receiver}" placeholder="받는 사람">
				<span id="idchk"></span>
			</div>
			<div class="title">
				<form:label path="sm_title" />
				<form:input type="text" class="form-control" path="sm_title" placeholder="제목"/>
				<form:errors path="sm_title" />
			</div>
			<div class="comment">
				<form:label path="sm_contents" />
  				<form:textarea class="form-control" rows="10" path="sm_contents" style="resize: none;" placeholder="내용"/>
				<form:errors path="sm_contents" />
			</div>
			<div class="bttn" style="margin-top: 10;">
				<input type="submit" class="btn btn-info" id="send" value="보내기">
				<a href="receive.do" class="btn btn-info" role="button">취소</a>
			</div>
		</form:form>
	</div>
</body>
</html>
