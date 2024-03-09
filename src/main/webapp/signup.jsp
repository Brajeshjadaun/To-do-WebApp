<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup Page</title>
<link rel="stylesheet" type="text/css" href="signup.css">
</head>
<body>
	<div class="container1">
		<div class="container2">
			<form action="signupStudent">
				<h1 class="heading">Signup</h1>
				<br> <input class="inputs" type="text" autofocus="autofocus"
					placeholder="Enter student ID here" name="stId"><br> <br>
				<input class="inputs" type="text" autofocus="autofocus"
					placeholder="Enter student name here" name="stName"><br>
				<br> <input class="inputs" type="text" autofocus="autofocus"
					placeholder="Enter email here" name="stEmail"><br> <br>
				<input class="inputs" type="password" placeholder="create password"
					, name="password"><br> <br>
				<div class="gender">
					<label>Gender</label><br> <input type="radio" name="gender"
						value="male">Male <input type="radio" name="gender"
						value="female">Female <input type="radio" name="gender"
						value="other">Other<br> <br>
				</div>

				<a href="signupStudent">
					<button class="signupbtn" type="submit">Signup</button> <br> <br>
				</a>
			</form>
			<label class="label1">Already have an account?</label><a
				href="login.jsp"><button class="signupbtn2" type="submit">Login</button></a>
		</div>

	</div>
</body>
</html>