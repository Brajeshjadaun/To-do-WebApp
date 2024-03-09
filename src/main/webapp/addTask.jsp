<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add-Task</title>
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
	
	.container2 .heading{
		color: #282d3a;
		display: flex;
		align-items: center;
		justify-content: center;
		font-size: 50px;
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
	
	.container2 .msgHeading{
		color: green;
		position: relative;
		left: 380px;
		font-size: 25px;
		margin: 0;
		padding: 0;
	}
	
	.container2 .msgDisplay{
		color: orange;
		position: relative;
		left: 100px;
		font-size: 25px;
		margin: 0;
		padding: 0;
	}
	
	.container2 .inputs {
	border: 2px solid #e4e4e4;
	border-radius: 5px;
	position: relative;
	left: 380px;
	width: 230px;
	height: 50px;
	font-size: 18px;
	}
	
	.container2 .btn2{
		position: relative;
		left: 350px;
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
	
</style>
</head>
<body>

	<%
	String str = (String)request.getAttribute("message");
	%>

	<div class="container1">
		<div class="container2">
			<form action="addTask" method="post">
			
			<%
			if(str != null){%>
			<h3 class="msgHeading"><%= str%></h3><br>
			<%}%>
			
		
			<h1 class="heading">Add-Task</h1>
			
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