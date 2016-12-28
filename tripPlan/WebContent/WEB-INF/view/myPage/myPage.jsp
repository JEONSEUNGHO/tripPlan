<%@ page contentType="text/html; charset=UTF-8"%>
<head>
</head>

<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<script>
	history.pushState(null, null, location.href);
	window.onpopstate = function(event) {
		history.go(1);
	}
</script>
<div id="body">

	<p><li><a href="" onClick="window.open('/tripPlan/letter/sendwrite.do','mypage','width=600,height=350'); return false;">
					<i class="fa fa-paper-plane-o"></i>&nbsp;&nbsp;쪽지</a>
				</li></p>
	${m_email}
	
</div>




