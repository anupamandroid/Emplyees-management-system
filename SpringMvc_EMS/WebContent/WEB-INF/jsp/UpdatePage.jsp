<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

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
		<h3>Update Page</h3>
	</div>
	<!-- Contant  -->
	<dir class="contant">

		<div class="form">
			<form action="update.do" method="post">
				<c:forEach items="" var="i">
					<pre>
First Name 	   <input type="text" name="fname" value="${dto.fname}">
Last Name  	   <input type="text" name="lname" value="${dto.lname}">
Mobile 	   	   <input type="text" name="mobile" value="${dto.mobile}">
Email	  	   <input type="text" name="email" value="${dto.email}"
							class="transparent-input">
Age	   	  	   <input type="text" name="age" value="${dto.age}">
	
		<input type="submit" value="Update" name="update" class="button">
		</pre>
				</c:forEach>
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