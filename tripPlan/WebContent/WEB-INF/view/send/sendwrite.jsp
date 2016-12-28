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
	src="/tripPlan/assets/js/jquery-3.1.1.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="/tripPlan/assets/js/jquery-ui.min.js" ></script>
<link rel="stylesheet"
	href="/tripPlan/assets/css/jquery-ui.min.css">	

</head>
<script>

$(function(){
	$('#sm_receiver').blur(function(){
		 $.ajax({
	 		type:"POST"
	 		,url:"/tripPlan/letter/idchk2.do"
			,data:"sm_receiver="+ $('#sm_receiver').val()
			,dataType:"json"
			,success:function(args){
				if(args.data == "YES"){
					$('.errors').html('');
					$('#idchk').html('<b style="font-size:14px;color:#1ec800">확인</b>');
	 				$('#send').attr('disabled',false);
	 			}else if(args.data == "NO"){
	 				$('.errors').html('');
	 				$('#idchk').html('<b style="font-size:14px;color:#fb5948">사용자가 없습니다.</b>');
	 				$('#send').attr('disabled',true);
	 				$('#sm_receiver').focus();
	 			} else if(args.data == "ERROR"){
	 				$('.errors').html('');
	 				$('#idchk').html('<b style="font-size:14px;color:#ff9800">필수항목입니다.</b>');
					 $('#send').attr('disabled',true);
	 				$('#sm_receiver').focus();
				}
	 	}
	 	,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
		alert(e.responseText);
		}
	 	});    
	});
}); 
	 $(function(){
 		$( "#sm_receiver" ).autocomplete({
 			source : function( request, response ) {
 				//많이 봤죠? jquery Ajax로 비동기 통신한 후
 				//json객체를 서버에서 내려받아서 리스트 뽑는 작업
 		        $.ajax({
 		        	//호출할 URL
 		            url: "/tripPlan/letter/idchk.do",
 		            //우선 jsontype json으로
 		            dataType: "json",
 		            // parameter 값이다. 여러개를 줄수도 있다.
 		            data: {
 		              //request.term >> 이거 자체가 text박스내에 입력된 값이다.
 		              searchValue: request.term
 		            },
 		            success: function( result ) {
 		            	//return 된놈을 response() 함수내에 다음과 같이 정의해서 뽑아온다.
 		                response( 
 		                	$.map( result, function( item ) {
 		                			var jbString = item.data
		                			var jbSplit = jbString.split('(')
		                			var jbString2 = jbSplit[1]
		                			var jbSplit2 = jbString2.split(')')
 		                			return {
 		                			//label : 화면에 보여지는 텍스트
 		                			//value : 실제 text태그에 들어갈 값
 		                			//본인은 둘다 똑같이 줬음
 		                			//화면에 보여지는 text가 즉, value가 되기때문 
 		                			
 		                  				label: item.data,
 		                  				value: jbSplit2[0]
 		                			}
 		              		})
 		              	);
 		            }
 		          });
 		    },
  		        //최소 몇자 이상되면 통신을 시작하겠다라는 옵션
 			minLength: 2,
 			//자동완성 목록에서 특정 값 선택시 처리하는 동작 구현
 			//구현없으면 단순 text태그내에 값이 들어간다.
 			select: function( event, ui ) {}
 		});
})
</script>
<body>
	<div class="container">
		<div class="btn-group" style="margin: 10 0 10 0;">
			<a href="sendwrite.do" class="btn btn-info" role="button">쪽지 쓰기</a> <a
				href="receive.do" class="btn btn-info" role="button">받은 쪽지</a> <a
				href="send.do" class="btn btn-info" role="button">보낸 쪽지</a>
		</div>
	</div>
	<div class="container">
		<form:form action="sendwritePro.do" method="post"
			commandName="sendDataBean">
			<div class="send">
				<form:label path="sm_receiver" />
				<form:input type="text" class="form-control" path="sm_receiver"
					 value="${letter.sm_receiver}" placeholder="받는 사람" />
				<form:errors style="font-size:14px;color:#ff9800;" class="errors" path="sm_receiver" />
				<span id="idchk"></span>
			</div>
			<div class="title">
				<form:label path="sm_title" />
				<form:input type="text" class="form-control" path="sm_title"
					placeholder="제목" />
				<form:errors style="font-size:14px;color:#ff9800;" path="sm_title" />
			</div>
			<div class="comment">
				<form:label path="sm_contents" />
				<form:textarea class="form-control" rows="10" path="sm_contents"
					style="resize: none;" placeholder="내용" />
				<form:errors style="font-size:14px;color:#ff9800;" path="sm_contents" />
			</div>
			<div class="bttn" style="margin-top: 10;">
				<input type="submit" class="btn btn-info" id="send" value="보내기">
				<a href="receive.do" class="btn btn-info" role="button">취소</a>
			</div>
		</form:form>
	</div>
</body>
</html>
