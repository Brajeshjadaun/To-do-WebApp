<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-Page</title>
<style type="text/css">
body {
	background-color: #4070f4;
}

.container1 {
	max-width: 500px;
	max-height: 500px;
	display: flex;
	align-items: center;
	justify-content: center;
	position: relative;
	top: 100px;
	left: 500px
}

.container2 {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	background-color: #ffffff;
	border: 1px solid #ffffff;
	border-radius: 24px;
	box-shadow: 2px 10px 20px rgba(0, 0, 0, 0.5);
	padding-bottom: 20px;
}

.container2 .heading {
	color: #282d3a;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 50px;
}

.container2 .inputs {
	border: 2px solid #e4e4e4;
	border-radius: 5px;
	position: relative;
	left: 140px;
	font-size: 18px;
}

.container2 .loginbtn {
	position: relative;
	left: 140px;
	width: 230px;
	background-color: #0171d3;
	color: #ffffff;
	font-size: 20px;
	border: 1px solid #0171d3;
	border-radius: 5px;
	cursor: pointer;
}

.container2 .loginbtn:hover{
	background-color: blue;
}

.container2 .label1 {
	position: relative;
	left: 140px;
}

.container2 .loginbtn2 {
	border: none;
	background-color: #ffffff;
	position: relative;
	left: 140px;
	color: #84a4dc;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container1">
		<div class="container2">

			<form action="loginStudent" method="get">
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