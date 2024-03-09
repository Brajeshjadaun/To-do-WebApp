<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-Page</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>

	<%
	String str3 = (String)request.getAttribute("message3");
	%>

	<div class="container1">
		<div class="container2">

			<form action="loginStudent" method="post">
			
				<%
				if(str3 != null){%>
				<h3 class="msgHeading"><%= str3%></h3><br>
				<%}%>
			
				<h1 class="heading">Login</h1>
				<br> <input class="inputs" type="text" autofocus="autofocus"
					placeholder="Enter your email here" name="email"><br>
				<br> <input class="inputs" type="password"
					placeholder="Enter your password here" , name="password"><br>
				<br> <a href="loginStudent">
					<button class="loginbtn" type="submit">Login</button> <br> <br>
				</a>
			</form>

			<label class="label1">Don't have an account?</label><a
				href="signup.jsp"><button class="loginbtn2" type="submit">Signup</button></a>
		</div>
	</div>
</body>
</html>