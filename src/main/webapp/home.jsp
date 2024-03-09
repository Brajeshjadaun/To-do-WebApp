<%@page import="com.servlet.student_to_do_web_app.dto.Student"%>
<%@page import="com.servlet.student_to_do_web_app.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-Dashboard</title>
<link rel="stylesheet" type="text/css" href="home.css">
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