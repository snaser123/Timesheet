<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V4</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<c:url value="/resources/theme1/bootstrap/images/icons/favicon.ico"/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/vendor/bootstrap/css/bootstrap.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/fonts/iconic/css/material-design-iconic-font.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/vendor/animate/animate.css"/>">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/vendor/css-hamburgers/hamburgers.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/vendor/animsition/css/animsition.min.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/vendor/select2/select2.min.css"/>">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/vendor/daterangepicker/daterangepicker.css"/>">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/css/util.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme1/bootstrap/css/main.css"/>">
<!--===============================================================================================-->

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method="post" action="loginrequest.html">
					<span class="login100-form-title p-b-49">
						Login
					</span>
						${message }
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" name="feild1" placeholder="Type your username" value=123456>
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="feild2" placeholder="Type your password" value=123>
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					
					<div></div>
					<br/>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Login
							</button>
						</div>
					</div>

					
					
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="<c:url value="resources/theme1/bootstrap/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/theme1/bootstrap/vendor/animsition/js/animsition.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/theme1/bootstrap/vendor/bootstrap/js/popper.js"/>"></script>
	<script src="<c:url value="resources/theme1/bootstrap/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/theme1/bootstrap/vendor/select2/select2.min.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/theme1/bootstrap/vendor/daterangepicker/moment.min.js"/>"></script>
	<script src="<c:url value="resources/theme1/bootstrap/vendor/daterangepicker/daterangepicker.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/theme1/bootstrap/vendor/countdowntime/countdowntime.js"/>"></script>
<!--===============================================================================================-->
	<script src="<c:url value="resources/theme1/bootstrap/js/main.js"/>"></script>

</body>
</html>

