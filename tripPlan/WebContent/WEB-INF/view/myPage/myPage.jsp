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

	
	${m_email}
	
</div>




