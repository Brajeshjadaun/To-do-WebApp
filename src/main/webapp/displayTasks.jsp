<%@page import="java.sql.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.servlet.student_to_do_web_app.service.TaskService"%>
<%@page import="java.util.List"%>
<%@page import="com.servlet.student_to_do_web_app.dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Tasks</title>
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
	
	.container2 .msgHeading {
	color: green;
	position: relative;
	left: 250px;
	font-size: 25px;
	margin: 0;
	padding: 0;
}
	
	.container2 .msgHeadingTask {
	color: red;
	position: relative;
	left: 250px;
	font-size: 25px;
	margin: 0;
	padding: 0;
}
	
	.container2 .table{
		position: relative;
		left: 250px;
		margin: 10px;
	}
	
	.table .caption{
		color: black;
		font-weight: 20px;
		font-size: 30px;
	}
	
	.container2 .btn2{
		position: relative;
		left: 220px;
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
	TaskService taskService = new TaskService();
	String str = (String) request.getAttribute("message");
	String str1 = (String) request.getAttribute("message1");
	
	int stId = 0;
	// Get stId from request parameter
	if(request.getAttribute("stId") != null){
    	stId = Integer.parseInt(request.getAttribute("stId").toString());
    }
    
    List<Task> tasks = null;
    List<Task> tasks2 = null;
   	
    if(request.getAttribute("taskDate") != null){
    	LocalDate taskDate = LocalDate.parse(request.getAttribute("taskDate").toString());
    	tasks2 = taskService.getTasksByDateService(stId, taskDate);
    }else if(request.getAttribute("taskDate") == null){
    	tasks = taskService.getAllTaskService(stId);	
    }
    %>
	
	<div class="container1">
		<div class="container2">
			
			
			<table class="table" border="2px">
			<%
			if (str1 != null) {
			%>
			<h3 class="msgHeading"><%=str1%></h3>
			<br>
			<%
			}
			%>
			<caption class="caption">Task Details</caption>
				<tr>
					<th>taskId</th>
					<th>taskName</th>
					<th>taskDate</th>
					<th>taskInfo</th>
					<th colspan="2">Action</th>
				</tr>
				
				<tr>
					<%if(tasks2 == null) {%>
						<%for(Task task : tasks){ %>
						<tr>
						<td><%=task.getTaskId()%></td>
						<td><%=task.getTaskName()%></td>
						<td><%=task.getTaskDate()%></td>
						<td><%=task.getTaskInfo()%></td>
						<td><a href="deleteTask?taskId=<%=task.getTaskId()%>"><button style='background-color: red; color: white; cursor: pointer;'>Delete</button></a></td>
						<td><a href="update.jsp?taskId=<%=task.getTaskId()%>"><button style='cursor: pointer;'>Update</button></a></td>
						</tr>
						<%} %>
					<%} else if(tasks2 != null) {%>
						<%if(tasks2.isEmpty()){ %>
							<%if (str != null) {%>
								<h3 class="msgHeadingTask"><%=str%></h3><br>
							<% }%>
						<%} %>
						<%for(Task task : tasks2){ %>
						<tr>
						<td><%=task.getTaskId()%></td>
						<td><%=task.getTaskName()%></td>
						<td><%=task.getTaskDate()%></td>
						<td><%=task.getTaskInfo()%></td>
						<td><a href="deleteTask?taskId=<%=task.getTaskId()%>"><button style='background-color: red; color: white; cursor: pointer;'>Delete</button></a></td>
						<td><a href="update.jsp?taskId=<%=task.getTaskId()%>"><button style='cursor: pointer;'>Update</button></a></td>
						</tr>
						<%} %>
					<%} %>
				</tr>
			</table>
			<a href="home"><button class="btn2" type="button">Home</button></a>
		</div>
	</div>

</body>
</html>