<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="main.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>MealSelector: Input confirmed</title>
</head>
<body>
	<div class="topnav">
		<a href="index">Home</a> <a class="active" href="database">Database</a>
	</div>
	<div class="bg-image"></div>
	
	<div class="bg-text">
		<p>${confirmedmeal} has been successfully added to the database!</p>
	</div>
	
	<br>
	
	<a href="index" class="p1">Return to home</a>
	
</body>
</html>