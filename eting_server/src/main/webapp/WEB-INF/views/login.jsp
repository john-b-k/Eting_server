<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>Home</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="/eting/css/bootstrap.min.css">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/eting/js/jquery-2.0.3.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="/eting/js/bootstrap.min.js"></script>
	<!-- login page css -->
	<link rel="stylesheet" href="/eting/css/login.css">
	
	<!-- Just for debugging purposes. Don't actually copy this line! -->
	<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
</head>


<body>

	<div class="container">

		<form class="form-signin" role="form" action="/eting/loginProcess" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" name="userId" class="form-control" placeholder="User ID" required autofocus> 
			<input type="password" name="password" class="form-control" placeholder="Password" required> 
			<!-- <label class="checkbox"> 
			<input type="checkbox" value="remember-me">	Remember me	</label> -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign	in</button>
		</form>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
</body>


</html>
