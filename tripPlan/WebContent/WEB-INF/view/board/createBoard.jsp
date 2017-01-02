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
<form method="post" action="createBoard.do">
	<div class="wrapper">
    
    <section class="container animated fadeInDown slow custom-ease">
      
      <h1>Plan a Trip</h1>
      
 
      <div class="content">
        <form id="add-form" action="#" method="post">    

          <div class="row">
            <label class="column">
              <span class="label">Destination</span>
              <input name="destination" type="text" tabindex="1" placeholder="제목을 입력하세요.." autofocus>
            </label>
          </div>

          <div class="row">
            <label class="column">
              <span class="label">Departure</span>
              <span class="date-wrapper">
                <input id="departure" class="date" name="departure" type="text" tabindex="2" placeholder="제목" readonly>
                <input id="departure-timestamp" name="departureTimestamp" type="hidden"> <!-- used to store unix timestamp -->
                
                <span class="icon date-icon">
                  <svg width="16px" height="16px" viewBox="0 0 16 16" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                      <rect fill-opacity="0" fill="#FFFFFF" x="0" y="0" width="16" height="16"></rect><rect fill="#969B9C" x="0" y="5" width="16" height="1"></rect><rect fill="#969B9C" x="1" y="15" width="14" height="1"></rect><rect fill="#969B9C" x="15" y="1" width="1" height="15"></rect><rect fill="#969B9C" x="0" y="1" width="1" height="15"></rect><rect fill="#969B9C" x="14" y="1" width="1" height="1"></rect><rect fill="#969B9C" x="1" y="1" width="1" height="1"></rect><rect fill="#969B9C" x="5" y="1" width="6" height="1"></rect><rect fill="#969B9C" x="12" y="0" width="1" height="3" rx="1"></rect><rect fill="#969B9C" x="3" y="0" width="1" height="3" rx="1"></rect>
                    </g>
                  </svg>
                </span>
                
              </span>
            </label>
          </div>

          <div class="row">
            <label class="has-other">
              <span class="label">Purpose</span>
              
              <div class="select-wrapper">
                <span class="select">
                  <select name="purpose" tabindex="3">
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
            <span class="group-label">Activity</span>
            <label class="column inline radio-wrapper">
              <input name="activity" type="radio" value="private" tabindex="4" checked>
              <span class="label">Private</span>
            </label>
            <label class="column inline radio-wrapper">
              <input name="activity" type="radio" value="public" tabindex="5">
              <span class="label">Public</span>
            </label>
          </div>

                
        </div><!-- .content -->

        <input class="button button-primary" type="submit" value="다음" tabindex="7">

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