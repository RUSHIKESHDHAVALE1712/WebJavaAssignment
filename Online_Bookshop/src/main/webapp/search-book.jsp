<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Book</title>
<style type="text/css">
	#box{
		margin: auto;
		width: 500px;
		height: auto;
		border: 2px solid red
		}

</style>
</head>
<body>
	<div id = "box">
		<h1>📔Enter Book Title📔</h1>
		<form action="searchBook" method="post">
			Title: <input type="text" name="title"> <br> <br>
			<input type ="submit" value="Search">
		</form>
	</div>
</body>
</html>