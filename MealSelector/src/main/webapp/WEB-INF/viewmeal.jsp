<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
        img {
            margin: 10px;
        }
    </style>
<meta charset="UTF-8">
<link href="main.css" rel="stylesheet" type="text/css" />
<title>MealSelector: View Meal</title>
</head>
<body>
	<div class="topnav">
		<a href="index">Home</a> <a href="viewmeal">Random meal</a> <a href="database">Database</a> <a href="inputmeal">Input Meal</a>
	</div>
	<div class="bg-image"></div>
	
	<div class="bg-text">
	
		<c:if test="${goBack}">
			<form action="${back}" method="post">
				<input name="viewpage" class="p1" type="submit" value="Back" />
			</form>
		</c:if>
		<h1 class="p1">${meal.getName()}</h1>
		<h3 class="p1">${meal.getType()}</h3>
		<p class="p1">${meal.getDescription()}</p>
		
		<form action="${meal.getSiteurl()}" method="get">
			<input name="viewpage" class="p1" type="submit" value="Recipe" />
		</form>
		
		<img src="${meal.getImageurl()}">
	</div>
	
</body>
</html>