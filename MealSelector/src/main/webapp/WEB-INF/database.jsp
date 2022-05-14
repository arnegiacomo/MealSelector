<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="main.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>MealSelector: Database</title>
<style>
table.center {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<div class="topnav">
		<a href="index">Home</a> <a href="selector">Random meal</a> <a class="active" href="database">Database</a> <a href="inputmeal">Input Meal</a>
	</div>
	<div class="bg-image"></div>
	
	<div class="bg-text">
		<h1 class="p1">All meals</h1>
		<br>
		<br>
		<table class="table">
			<tr bgcolor="#cccccc">
				<th class="p1" align="center"> Name </th>
				<th class="p1" align="center"> Type </th>
				<th class="p1" align="center"> Prep time </th>
				<th class="p1" align="center"> Page </th>
				<th class="p1" align="center"> Recipe url </th>
			</tr>

			<c:forEach items='${requestScope["meals"]}' var="meal">
			
				<tr bgcolor="#ffffff">
					<td class="p1" align="left">${meal.getName()}</td>
					<td class="p1" align="left">${meal.getType()}</td>
					<td class="p1" align="left">${meal.getPreptime()}</td>
					<td>
						<form action="viewmeal" method="post">
							<input name="viewpage" class="p1" type="submit" value="View page" />
							<input type="hidden" name="ID" value="${meal.getID()}">
						</form>
					</td>
					<td><a class="p1" href="${meal.getSiteurl()}"> Recipe </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>