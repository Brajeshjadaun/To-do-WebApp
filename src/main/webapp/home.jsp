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
	
	.container2 .btn1{
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
	
	.container2 .btn{
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
	
	.container2 .btn2{
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
	
</style>

</head>
<body>
	<div class="container1">
		<div class="container2">
		
			<h1 class="heading">Student Dashboard</h1>
			
			<a href="addTask.jsp"><button class="btn1" type="submit">Add Your Task</button></a><br>
			<button class="btn1" type="submit">Display Your Task</button><br><br>
			<label class="label1">Display Task with Date</label><br>
			<input class="btn1 btn" type="date" name="taskDate"><br>
			<button class="btn2" type="submit">Display</button><button class="btn2" type="reset">Reset</button>

		</div>
	</div>
</body>
</html>