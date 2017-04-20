<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EMS</title>
<link rel="stylesheet" href="css/project.css">
</head>
<body>
	<!-- Header  -->
	<div class="border">
		<h1>Employees Management System</h1>
		<h3>Home Page</h3>
	</div>
	<!-- Contant  -->
	<dir class="contant">
		<div class="form">
			<h3>Hello ${loginUser}</h3>
			
			<h3>Profile Image</h3>
			<h3 style="color: red">${filesuccess}</h3>
			
			<form action="upload.do" method="post" enctype="multipart/form-data">
				<label for="image">Choose Image</label> 
				<input name="file" type="file" /> 
				<input type="submit" value="Upload" name="upload" class="button">
			</form>
			
			<a href="callupdate.do"class="reg_section"> Update Profile</a>
			<a href="logout.do"class="reg_section"> Logout</a>

		</div>
	</dir>
	<!-- Footer -->
	<div class="footer">
		<section> copyright&copyDebrajPaul <br>
		<hr>
		For more Information <a href="https://in.linkedin.com/in/debraj-paul-442175b0">Debraj Paul</a> 
		</section>
	</div>
</body>
</html>