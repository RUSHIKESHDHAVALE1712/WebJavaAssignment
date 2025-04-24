<%@page import="com.bookshop.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
<style type="text/css">
	#box{
		margin: auto;
		width: 500px;
		height: auto;
		border: 2px solid red;
		padding: 5px
		}

</style>
</head>
<body>
	<div id = "box">
		<h1>📔Book Details📔</h1>
		<%
			Book book = (Book) request.getAttribute("book");
		%>
		<h3><%= book.getTitle() %></h3> <br>
		Price: <%= book.getPrice() %> <br>
		Author: <%= book.getAuthor().getName() %> <br>
		PublicationYear: <%= book.getPublicationYear() %> <br>
		<button>Buy</button> <br>
	</div>
</body>
</html>