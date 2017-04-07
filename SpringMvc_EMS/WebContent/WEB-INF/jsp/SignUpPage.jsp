<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EMS</title>
<link rel="stylesheet" href="css/project.css">
<script type="text/javascript" src="js/js.js"></script>
</head>
<body>
	<!-- Header  -->
	<div class="border">
		<h1>Employees Management System</h1>
		<h3>Registation Page</h3>
	</div>
	<!-- Contant  -->
	<dir class="contant">
		<div class="form">
			<div id="error"></div>
			<form name="signupForm" action="signup.do" method="post"
				onsubmit="return signupvalidation()">
				<pre>
First Name 	   <input type="text" name="fname"
						onhange="text_validation(this)" class="text_error">
Last Name  	   <input type="text" name="lname"
						onhange="text_validation(this)" class="text_error">
Mobile 	   	   <input type="text" name="mobile"
						onhange="text_validation(this)" class="text_error">
  Age	   	   <input type="text" name="age"
						onhange="text_validation(this)" class="text_error">
Email	  	   <input type="text" name="email"
						onhange="text_validation(this)" id= "email_error" class="text_error">
Password	   <input type="password" name="password"
						onhange="pwd_validation(this)" id="pwd_error" class="text_error">
C_Password	   <input type="password" name="c_password"
						onhange="pwd_validation(this)" id="cpwd_error" class="text_error">

	
	<input type="submit" value="SignUp" name="signup" class="button">
	<input type="reset" value="Reset" class="button">
		</pre>
			</form>
		</div>
	</dir>
	<!-- Footer -->
	<div class="footer">
		<section> copyright&copyDebrajPaul <br>
		<hr>
		For more Information <a
			href="https://in.linkedin.com/in/debraj-paul-442175b0">Debraj
			Paul</a> </section>
	</div>
</body>
</html>