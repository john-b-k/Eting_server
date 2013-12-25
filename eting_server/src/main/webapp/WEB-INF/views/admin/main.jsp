<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>Admin Page</title>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="/eting/css/bootstrap.min.css">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/eting/js/jquery-2.0.3.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="/eting/js/bootstrap.min.js"></script>
	<!-- login page css -->
	<link rel="stylesheet" href="/eting/css/navbar.css">
	
	<!-- Just for debugging purposes. Don't actually copy this line! -->
	<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
	</head>
</head>
<body>

    <div class="container">

      <!-- Static navbar -->
      <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Eting 관리화면</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">메세지</a></li>
            <li><a href="#">로그</a></li>
            <li><a href="#">통계</a></li>
            
          <!--   <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li> -->
            
          </ul>
          <!-- 
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="./">Default</a></li>
            <li><a href="../navbar-static-top/">Static top</a></li>
            <li><a href="../navbar-fixed-top/">Fixed top</a></li>
          </ul>
           -->
        </div><!--/.nav-collapse -->
      </div>

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>메세지 보내기</h1>
        <p>이팅 사용자들에게 메세지를 보냅니다.</p>
        <form id="theFrm" action="/eting/admin/sendAdminMsg" method="post">
        <textarea class="form-control" name="msg_content" rows="4"></textarea>
        <input type="checkbox" name="isNoti" value="Y"> 푸쉬알림
        <input type="checkbox" name="isTest" value="Y" checked="checked"> 테스트(관리자에게 전송함.)
        <p>
          <a class="btn btn-lg btn-primary" href="#" role="button" id="frmSubmit">전송 &raquo;</a>
        </p>
        </form>
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
  <script type="text/javascript">
  $(document).ready(function(){
	  $('#frmSubmit').click(function(){
		  $('#theFrm').submit();
	  }); 
  });
  
  </script>
</html>
