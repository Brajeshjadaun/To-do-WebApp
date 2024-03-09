<%@page import="com.servlet.student_to_do_web_app.dto.Student"%>
<%@page import="com.servlet.student_to_do_web_app.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Dashboard</title>

<style type="text/css">
body {
	background-color: #4070f4;
}

.container1 {
	max-width: 1000px;
	max-height: 1000px;
	display: flex;
	align-items: center;
	justify-content: center;
	position: relative;
	top: 100px;
	left: 250px
}

.container2 .msgHeading {
	color: green;
	position: relative;
	left: 380px;
	font-size: 25px;
	margin: 0;
	padding: 0;
}

.container2 .msgHeadingTask {
	color: red;
	position: relative;
	left: 380px;
	font-size: 25px;
	margin: 0;
	padding: 0;
}

.container2 .heading {
	color: #282d3a;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 50px;
	margin: 0;
	padding: 0;
}

.container2 .msgDisplay {
	color: orange;
	position: relative;
	left: 100px;
	font-size: 15px;
	margin: 0;
	padding: 0;
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

.container2 .btn1 {
	position: relative;
	left: 380px;
	width: 230px;
	height: 80px;
	background-color: #0171d3;
	color: #ffffff;
	font-size: 25px;
	border: 1px solid #0171d3;
	border-radius: 5px;
	cursor: pointer;
	margin-top: 30px;
	margin-bottom: 30px;
}

.container2 .btn1:hover {
	background-color: blue;
}

.container2 .btn {
	margin: 0;
	border-radius: 0 0 5px 5px;
	width: 234px;
	height: 40px;
}

.container2 .label1 {
	position: relative;
	left: 380px;
	background-color: #0171d3;
	color: #ffffff;
	font-size: 25px;
	border: 1px solid #0171d3;
	border-radius: 5px 5px 0 0;
	padding-top: 5px;
}

.container2 .btn2 {
	position: relative;
	left: 380px;
	background-color: #0171d3;
	color: #ffffff;
	border: 1px solid #0171d3;
	border-radius: 5px;
	cursor: pointer;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-left: 40px;
}

.container2 .btn2:hover {
	background-color: blue;
}

.container2 .btnlogout {
	position: relative;
	left: 800px;
	top: 15px;
	background-color: #0171d3;
	color: #ffffff;
	border: 1px solid #0171d3;
	border-radius: 5px;
	cursor: pointer;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-left: 40px;
}

.container2 .btnlogout:hover {
	background-color: blue;
}

</style>

</head>
<body>

	<%
	String str1 = (String) request.getAttribute("message1");
	Student str2 = (Student) request.getAttribute("message2");
	String str = (String) request.getAttribute("message");
	%>

	<div class="container1">
		<div class="container2">

			<%
			if (str1 != null) {
			%>
			<h3 class="msgHeading"><%=str1%></h3>
			<br>
			<%
			}
			%>

			<%
			if (str != null) {
			%>
			<h3 class="msgHeadingTask"><%=str%></h3>
			<br>
			<%
			}
			%>

			<h1 class="heading">Student Dashboard</h1>
			<br>

			<%
			Student authenticatedUser = (Student) session.getAttribute("userSession");
			if (authenticatedUser != null) {
			%>
			<a href="logout"><button class="btnlogout" type="submit">LogOut</button></a>
			<h3 class="msgDisplay">
				Id:
				<%=authenticatedUser.getStId()%><br> Name:
				<%=authenticatedUser.getStName()%><br> Email:
				<%=authenticatedUser.getStEmail()%><br> Gender:
				<%=authenticatedUser.getGender()%><br>
			</h3>
			<br>
			<%
			}
			%>

			<a href="homeAddSession"><button class="btn1" type="submit">Add
					Your Task</button></a><br> <a href="homeDisplayAllSession"><button
					class="btn1" type="submit">Display Your Tasks</button></a><br> <br>
			<form action="homeDisplayDateSession" method="post">
				<label class="label1">Display Task with Date</label><br> <input
					class="btn1 btn" type="date" name="taskDate"><br>
					<input type="hidden" name="stId" value="<%= authenticatedUser.getStId() %>">
					<a href="homeDisplayDateSession"><button class="btn2"
						type="submit">Display</button></a>
					<button class="btn2" type="reset">Reset</button>
			</form>
		</div>
	</div>
</body>
</html>