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
<link href="<c:url value="/resources/theme1/css/style1.css" />" rel="stylesheet">
</head>
<body>
<table id="customers">
  <tr>
    <th> vehicle no</th>
    <th>id of user</th>
	    <th>owner name</th>
    <th>model </th>
    <th>type </th>
    <th>color </th>

  </tr>
  
  <tr>
    
    <td>
		${bean.getVehicle_no()}</td>
	<td>${bean.getId()}</td>
	<td>${bean.getOwner_name()}</td>
	<td>${bean.getModel()}</td>
	<td>${bean.getType()}</td>
	<td>${bean.getColour()}		</td>			
 
  
</table>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" method="post" action="registerRequest.html">
					<span class="login100-form-title p-b-49">
						Register 
					</span>
							<marquee color=red><font color=red>${message}</font></marquee>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "email is  reauired">
						<span class="label-input100">mail id:</span>
						<input class="input100" type="email" name="email" placeholder="Type your email" value="shaik.naser@capg.com">						
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<input class="input100" type="hidden" value="${bean.getVehicle_no()}" name="vehicle" placeholder="Type your email">
					<div class="wrap-input100 validate-input" data-validate="mobile no is required">
						<span class="label-input100">enter your mobile no:</span>
						<input class="input100" type="mobile" name="mobile" placeholder="Type your mobile" value="8184966313">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="username is required">
						<span class="label-input100">enter your Username</span>
						<input class="input100" type="text" name="username" placeholder="Type your username" value="123456">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">enter your Password</span>
						<input class="input100" type="password" name="password" placeholder="Type your password"value="123">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Re-enter your Password</span>
						<input class="input100" type="password" name="Rpassword" placeholder="Type your password"value="123">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit">
								SIGN UP
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




