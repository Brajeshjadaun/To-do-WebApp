<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add-Task</title>
<link rel="stylesheet" type="text/css" href="addTask.css">
</head>
<body>

	<%
	String str = (String)request.getAttribute("message");
	%>

	<div class="container1">
		<div class="container2">
			
			<%
			if(str != null){%>
			<h3 class="msgHeading"><%= str%></h3><br>
			<%}%>
			
		
			<h1 class="heading">Add-Task</h1>
			<a href="logout"><button class="btnlogout" type="submit">LogOut</button></a><br>
			
			<form action="addTask" method="post">
			<input class="inputs" type="text" name="taskName" placeholder="Task Name" autofocus="autofocus" required="required"><br><br>
			<input class="inputs" type="date" name="taskDate" placeholder="Task Date" required="required"><br><br>
			<textarea class="inputs" name="taskInfo" placeholder="Task Information"></textarea><br><br>
			
			<a href="addTask"><button class="btn2" type="submit">Add</button></a>
			<button class="btn2" type="reset">Reset</button>
			<a href="home"><button class="btn2" type="button">Home</button></a>

			</form>
		</div>
	</div>

</body>
</html>