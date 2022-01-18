<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.bg-imageview {
  /* The image used */
  background-image: url("${meal.getImageurl()}");

  /* Full height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

</style>
<meta charset="UTF-8">
<link href="main.css" rel="stylesheet" type="text/css" />
<title>MealSelector: View Meal</title>
</head>
<body>
	<div class="topnav">
		<a href="index">Home</a> <a href="database">Database</a>  <a href="about">About</a> 
	</div>
	<div class="bg-imageview"></div>
	
	<div class="bg-text">
		<h1 class="p1">${meal.getName()}</h1>
		<h3 class="p1">${meal.getType()}</h3>
		<p class="p1">${meal.getDescription()}</p>
		<p class="p1"><a href="${meal.getSiteurl()}">Recipe</a></p>
	</div>
	
</body>
</html>