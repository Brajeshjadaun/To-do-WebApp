<%@page import="com.servlet.student_to_do_web_app.service.TaskService"%>
<%@page import="com.servlet.student_to_do_web_app.dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update-Task</title>
<link rel="stylesheet" type="text/css" href="update.css">
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