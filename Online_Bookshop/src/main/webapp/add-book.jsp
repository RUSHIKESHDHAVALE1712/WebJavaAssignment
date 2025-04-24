<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
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
		<h1>Add Book</h1>
		<form action="addBook" method="post">
		Title: <input type="text" name="title"> <br> <br>
		Price: <input type="text" name="price"> <br> <br>
		Publication Year: <input type="text" name="year"> <br> <br>
		Author Name: <input type="text" name="name"> <br> <br>
		Author Email: <input type="text" name="email"> <br> <br>
		Author Country: <input type="text" name="country"> <br> <br>
		<input type ="submit" value="Submit">
		</form>
	</div>
</body>
</html>