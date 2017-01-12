<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<link href="/tripPlan/assets/css/path.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.4.0/css/pikaday.css'>
<link rel='stylesheet prefetch' href='http://cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.3/animate.min.css'>
 <link rel="stylesheet" href="/tripPlan/assets/css/mainboard.css">

<script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
<div id="body">
<form method="post" action="createBoard.do" enctype="multipart/form-data">
	<div class="wrapper">
    
    <section class="container animated fadeInDown slow custom-ease">
      
      <h1>Plan a Trip</h1>
      
 
      <div class="content">
        <form id="add-form" action="#" action="post">    

          <div class="row">
            <label class="column">
              <span class="group-label">제목</span>
              <input name="b_title" type="text" tabindex="1" placeholder="제목을 입력하세요.." required="required" autofocus>
            </label>
          </div>

          <div class="row">
            <label class="column">
              <span class="group-label">시작일</span>
              <span class="date-wrapper">
                <input type="date" id="b_startdate" name="b_startdate" required="required">
              </span>
            </label>
          </div>
		  <div class="row">
            <label class="column">
              <span class="group-label">종료일</span>
              <span class="date-wrapper">
                <input type="date" id="b_enddate" name="b_enddate" required="required">
              </span>
            </label>
          </div>
          <div class="row">
            <label class="has-other">
              <span class="group-label">구분</span>
              
              <div class="select-wrapper">
                <span class="select">
                  <select name="b_identified" tabindex="3" required="required">
                    <option value="" selected disabled>Why?</option>
                    <option value="0">후기</option>
                    <option value="1">계획</option>
                    <option value="2">그룹</option>
                  </select>
                  <span class="icon select-icon"></span>
                </span>
              </div>
              
            </label>
          </div>

          <div class="row clearfix group">
            <span class="group-label">상태</span>
            <label class="column inline radio-wrapper">
              <input name="b_activity" type="radio" value="1" tabindex="4" checked>
              <span class="label">Private</span>
            </label>
            <label class="b_column inline radio-wrapper">
              <input name="b_activity" type="radio" value="2" tabindex="5">
              <span class="label">Public</span>
            </label>
          </div>
		<div class="row">
			<span class="group-label">메인사진</span>
			<input type="file" name="b_mainphoto" accept="image/*" >
		</div>
		
        
		<div class="row">
			<span class="group-label">내용</span>
			<textarea class="form-control" rows="5" id="comment" name="b_maincontents" required="required"></textarea>
		</div>
        </div><!-- .content -->

        <input class="button button-primary" type="submit" value="다음" tabindex="7">
		</div><!-- .content -->
      </form>
    </section>
  
</div><!-- .wrapper -->

<div class="modal">
  <p>Yay!</p>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/pikaday/1.4.0/pikaday.min.js'></script>

    <script src="/tripPlan/assets/js/mainboard.js"></script>
</div>
</body>
</html>