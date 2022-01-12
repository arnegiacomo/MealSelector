<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="main.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>MealSelector: Home</title>
</head>
<body>
	<div class="topnav">
		<a class="active" href="index">Home</a> <a href="database">Database</a>
		 <a href="about">About</a>
	</div>
	<div class="bg-image"></div>

	<div class="bg-text">
		<h1 class="p1">MealSelector</h1>
		<a href="selector" class="p1">Random meal</a> <br /> <br />

		<form action="selector" method="post">
			<fieldset>
				<legend class="p1">Meal Options</legend>
				<fieldset>
					<legend class="p1">Meal Type</legend>
					<select name="type">
						<option hidden disabled selected value>-- Select an
							option --</option>
						<option value="Breakfast">Breakfast</option>
						<option value="Lunch">Lunch</option>
						<option value="Dinner">Dinner</option>
						<option value="Snacks">Snacks</option>
						<option value="Other">Other</option>
					</select>
				</fieldset>
				<fieldset>
					<legend class="p1">Preperation time (maximum minutes)</legend>
					<p>
						<input type="radio" name="preptime" value="1" /> 15 <input
							type="radio" name="preptime" value="2" />30 <input type="radio"
							name="preptime" value="3" />45 <input type="radio"
							name="preptime" value="4" />60 <input type="radio"
							name="preptime" value="5" />90 <input type="radio"
							name="preptime" value="6" />90+
					</p>
				</fieldset>
				<p>
					<input type="submit" value="Narrow down your search" />
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>