<%@page import="com.servlet.student_to_do_web_app.service.TaskService"%>
<%@page import="com.servlet.student_to_do_web_app.dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update-Task</title>
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
		left: 340px;
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
	TaskService taskService = new TaskService();
	String str1 = (String) request.getAttribute("message1");
	String str = (String)request.getAttribute("message");
	String str3 = (String)request.getAttribute("message3");
	Task task = null;
	if(request.getParameter("taskId") != null){
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        task = taskService.getTaskByIdService(taskId);
    }
	%>

	<div class="container1">
		<div class="container2">
		<a href="logout"><button class="btnlogout" type="submit">LogOut</button></a><br>
			<form action="updateTask" method="get">
			
			<%
			if(str != null){%>
			<h3 class="msgHeading"><%= str%></h3><br>
			<%}%>
			
			<%
			if (str1 != null) {
			%>
			<h3 class="msgHeading"><%=str1%></h3>
			<br>
			<%
			}
			%>
			
			<%
				if(str3 != null){%>
				<h3 class="msgHeading"><%= str3%></h3><br>
				<%}%>
			
		
			<h1 class="heading">Update-Task</h1>
			
			<input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
			<input class="inputs" type="text" name="taskName" placeholder="Task Name" autofocus="autofocus" required="required" value="<%=task.getTaskName() %>" ><br><br>
			<input class="inputs" type="date" name="taskDate" placeholder="Task Date" value="<%=task.getTaskDate() %>" ><br><br>
			<textarea class="inputs" name="taskInfo" placeholder="Task Information" ><%=task.getTaskInfo() %></textarea><br><br>
			
			<a href="updateTask"><button class="btn2" type="submit">Update</button></a>
			<button class="btn2" type="reset">Reset</button>
			<a href="home"><button class="btn2" type="button">Home</button></a>

			</form>
		</div>
	</div>
	
</body>
</html>