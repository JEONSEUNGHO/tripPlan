<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<link href="/tripPlan/assets/css/after_body.css" rel="stylesheet">
<link rel="stylesheet" href="/tripPlan/assets/css/boardSearch.css">
<link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel="stylesheet" href="/tripPlan/assets/css/boardNavigation.css">
<link href="/tripPlan/assets/css/after_header.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

<title>Insert title here</title>
</head>
<body>

<div id="body">
 <aside class="sidebar">
  <div id="leftside-navigation" class="nano">
    <ul class="nano-content">
      <li>
        <a href="index.html"><i class="fa fa-dashboard"></i><span>Dashboard</span></a>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-cogs"></i><span>UI Elements</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>

          <li><a href="#">Alerts &amp; Notifications</a>
          </li>
          <li><a href="#">Panels</a>
          </li>
          <li><a href="#">Buttons</a>
          </li>
          <li><a href="#">Sliders &amp; Progress</a>
          </li>
          <li><a href="#">Modals &amp; Popups</a>
          </li>
          <li><a href="#">Icons</a>
          </li>
          <li><a href="#">Grid</a>
          </li>
          <li><a href="#">Tabs &amp; Accordions</a>
          </li>
          <li><a href="#">Nestable Lists</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-table"></i><span>Tables</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="tables-basic.html">Basic Tables</a>
          </li>

          <li><a href="tables-data.html">Data Tables</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa fa-tasks"></i><span>Forms</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="forms-components.html">Components</a>
          </li>
          <li><a href="forms-validation.html">Validation</a>
          </li>
          <li><a href="forms-mask.html">Mask</a>
          </li>
          <li><a href="forms-wizard.html">Wizard</a>
          </li>
          <li><a href="forms-multiple-file.html">Multiple File Upload</a>
          </li>
          <li><a href="forms-wysiwyg.html">WYSIWYG Editor</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-envelope"></i><span>Mail</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="mail-inbox.html">Inbox</a>
          </li>
          <li><a href="mail-compose.html">Compose Mail</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-bar-chart-o"></i><span>Charts</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="charts-chartjs.html">Chartjs</a>
          </li>
          <li><a href="charts-morris.html">Morris</a>
          </li>
          <li><a href="charts-c3.html">C3 Charts</a></li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-map-marker"></i><span>Maps</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="map-google.html">Google Map</a>
          </li>
          <li><a href="map-vector.html">Vector Map</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="typography.html"><i class="fa fa-text-height"></i><span>Typography</span></a>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-file"></i><span>Pages</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="pages-blank.html">Blank Page</a>
          </li>
          <li><a href="pages-login.html">Login</a>
          </li>
          <li><a href="pages-sign-up.html">Sign Up</a>
          </li>
          <li><a href="pages-calendar.html">Calendar</a>
          </li>
          <li><a href="pages-timeline.html">Timeline</a>
          </li>
          <li><a href="pages-404.html">404</a>
          </li>
          <li><a href="pages-500.html">500</a>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</aside>
		<form role="search" align="center" method="post" action="searchboard">
			<select id="boardsearch" name="boardsearch">
				<option value="0">후기</option>
				<option value="1">계획</option>
				<option value="2">그룹</option>
			</select>
			<input type="search" name="input" placeholder="검색어를 입력해 주세요">
			<input type="submit" value="검색">
		</form>
	
 					<c:forEach var="list" items="${plan}">
 					<li class="result_item">
						<a href="pathContents.do?b_id=${list.b_id }" class="item">
							<figure>
								<img class="my-image" src="${list.fi_path }" />
								<figcaption class="item_description">
									<p>
									
										<span class="item_title">${list.b_id }</span>
										<c:if test="${list.b_identified == 0 }">
										<span class="item_status label label-primary">후기</span>
										</c:if>
										<c:if test="${list.b_identified == 1 }">
										<span class="item_status label label-primary">계획</span>
										</c:if>
										<c:if test="${list.b_identified ==2 }">
										<span class="item_status label label-primary">그룹</span>
										</c:if>
										<span class="item_introduce"> ${list.b_title }</span>
									</p>
									<p>
										<span class="item_host">최순실</span> | <span class="item_date">${list.b_registertime }</span>
									</p>
								</figcaption>
								<div class="item_entry">
									<span class="entry_number">2</span> / <span class="entry_total">4</span> 명
								</div>
							</figure>
						</a>
					</li>
 					
 					</c:forEach>

	
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
<script src="/tripPlan/assets/js/boardNavigation.js"></script>
</div>
</body>
</html>