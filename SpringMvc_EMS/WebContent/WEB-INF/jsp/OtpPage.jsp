<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<h3>Login Page</h3>
	</div>
	<!-- Contant  -->
	<div class="contant">
		<div class="form">
			<form name="otp" action="otp.do" method="post"
				onsubmit="return loginvalidation();">
				<pre>
			OTP	  		<input type="password" name="otp"
						onhange="text_validation(this)" id="pwd">	
	<input type="submit" value="Validate" name="otp" class="button">
				</pre>
			</form>
			<a href="LoginPage.jsp">Login Page</a>
		</div>
	</div>
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