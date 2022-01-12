<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="main.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>MealSelector: Add meal</title>
<script src="js/inputmeal.js" defer></script>
</head>
<body>
	<div class="topnav">
		<a href="index">Home</a> <a class="active" href="database">Database</a>
		<a href="about">About</a>
	</div>
	<div class="bg-image"></div>

	<div class="bg-text">
		<h1 class="p1">Add new meal</h1>

		<form action="inputmeal" method="post" id="inputform">
			<fieldset>
				<legend class="p1">Meal Options</legend>
				<fieldset>
					<legend class="p1">Name of meal:</legend>
					<input required type="text" name="name" id="name" value="${nameerror}"
						placeholder="Fill in name of meal"
						title="Meal must start with a capital letter, and cannot be longer than 100 characters."
						required pattern="[A-ZÆØÅ][A-ZÆØÅa-zæøå\s]{0,99}" /> <span
						class="errormessage">${nameerror}</span>
				</fieldset>
				<fieldset>
					<legend class="p1">Meal description:</legend>
					<input required type="text" name="description" id="description"
						value="${descriptionerror}"
						placeholder="Fill in description of meal"
						title="Description can contain any characters, and cannot be longer than 100000 characters."
						required pattern=".{0,100000}" /> <span class="errormessage">${descriptionerror}</span>
				</fieldset>
				
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
					
					<input required type="text" name="preptime" id="preptime"
						value="${preptimeerror}"
						placeholder="Fill in preperation time of meal"
						title="Preperation time must only contain numbers"
						required pattern="[0-9]{0,10000}" /> <span class="errormessage">${preptimeerror}</span>

				</fieldset>
				
				<fieldset>
					<legend class="p1">URL of recipe:</legend>
					<input required type="text" name="siteurl" id="siteurl" value="${siteurlerror}"
						placeholder="Fill in recipe url"
						title="Must be a valid url"
						required pattern="https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)" /> <span
						class="errormessage">${siteurlerror}</span> <br>
				</fieldset>
				
				<fieldset>
					<legend class="p1">URL of image for meal:</legend>
					<input required type="text" name="imageurl" id="imageurl" value="${imageurlerror}"
						placeholder="Fill in image url"
						title="Must be a valid url"
						required pattern="https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)" /> <span
						class="errormessage">${imageurlerror}</span> <br>
				</fieldset>

				<input type="submit" value="Add meal to database" />

			</fieldset>
		</form>
	</div>
</body>
</html>