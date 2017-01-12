<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="utf-8">
    <meta name="description" content="Test your JavaScript, CSS, HTML or CoffeeScript online with JSFiddle code editor.">
    <meta name="keywords" content="online javascript editor, testing javascript online, online ide, online code editor, html, css, coffeescript, scss online editor">
    <meta name="author" content="JSFiddle">
    <meta name="copyright" content="share alike">
    <!-- <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests"> -->

    
      <meta name="robots" content="index, follow">
      <meta name="googlebot" content="index, follow">
    

    

    
      <meta name="google-site-verification" content="9m4aWTtDLfQ1kJNm3NtNsCrtpsOx_QoOPQRJ7jAwup8" />
    

    <!--meta name="viewport" content="width=device-width, maximum-scale=0.5" /-->
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-touch-fullscreen" content="yes" />

    
      <script type="text/javascript" src="/js/_dist-editor.js?update_14_12_2016_1"></script>

    
    
    <link rel="stylesheet" type="text/css" href="/css/_dist-editor.css?update_14_12_2016_1"/>


    
      <link rel="stylesheet" type="text/css" href="/css/light.css?update_14_12_2016_1"/>

    
</head>
<body>
<div id="body">
<input type="text" id="routeFrom" name="routeFrom" value="37.394253037,126.9568210126" />
<label for="routeFrom">From</label><br />
<input type="text" id="routeTo" name="routeTo" value="Huntersville, NC" />
<label for="routeTo">To</label><br />
<select id="routeMode" name="routeMode">
    <option value="DRIVING">Driving</option>
    <option value="WALKING">Walking</option>
    <option value="BICYCLING">Bicycling</option>
    <option value="TRANSIT">Transit</option>
</select>
<label for="routeMode">Mode</label><br />
<div class="textcenter">
    <button id="routeGo">Route</button>
    <button id="routeClear">Clear Route</button>
</div>
<div id="map_canvas"></div>
<div id="directions"></div>
</div>
</body>
</html>