<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="main.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>MealSelector: Add meal</title>
<script src="js/dropdown.js" defer></script>
<script src="js/unfinishedchanges.js" defer></script>
<script src="js/preptimeslider.js" defer></script>
</head>
<body>
	<div class="topnav">
		<a href="index">Home</a> <a href="selector">Random meal</a> <a href="database">Database</a> <a class="active" href="inputmeal">Input Meal</a>
	</div>
	<div class="bg-image"></div>

	<div class="bg-text">
		<h1 class="p1">Add new meal</h1>

		<form action="inputmeal" method="post" id="inputform">
			<fieldset>
				<legend class="p1">Meal Options</legend>
				<fieldset>
					<legend class="p1">Name of meal:</legend>
					<input required type="text" name="name" id="name"
						value="${nameerror}" placeholder="Fill in name of meal"
						title="Meal must start with a capital letter, and cannot be longer than 100 characters."
						required pattern="[A-ZÆØÅ][A-ZÆØÅa-zæøå\s]{0,99}" /> <span
						class="errormessage">${nameerror}</span>
				</fieldset>
				<fieldset>
					<legend class="p1">Meal description:</legend>
					<textarea class="p2" placeholder="Fill in description of meal" required
						id="description" name="description" rows="5" cols="100"
						title="Description can contain any characters, and cannot be longer than 100000 characters."></textarea>
					<span class="errormessage">${descriptionerror}</span>
				</fieldset>

				<fieldset>
					<legend class="p1">Type</legend>
					<div class="dropdown">
						<button id="typeButton" type="button" onclick="showDropdownt()"
							class="dropbtn">Choose Type</button>
						<div id="typeDropdown" class="dropdown-content">
							<input type="text" placeholder="Search.." id="typeInput"
								onkeyup="filterFunctiont()">

							<c:forEach items='${requestScope["types"]}' var="type">
								<a id="${type.getName()}" onclick="hideDropdownt(this.id)">${type.getName()}</a>
							</c:forEach>

						</div>
					</div>
					<input type="hidden" id="type" name="type" />
				</fieldset>
				
				<fieldset>
						<legend class="p1">Cuisine</legend>
						<div class="dropdown">
							<button id="cuisineButton" type="button" onclick="showDropdown()"
								class="dropbtn">Choose Cuisine</button>
							<div id="myDropdown" class="dropdown-content">
								<input type="text" placeholder="Search.." id="cuisineInput"
									onkeyup="filterFunction()"> 
									
								<c:forEach items='${requestScope["cuisines"]}' var="cuisine">
									<a id="${cuisine.getName()}" onclick="hideDropdown(this.id)">${cuisine.getName()}</a>
								</c:forEach>

							</div>
						</div>
						<input type="hidden" id="cuisine" name="cuisine" />
					</fieldset>
				</fieldset>

				<fieldset>
					<legend class="p1">Preperation time</legend>
					<input class="slider" name="preptime" id="preptime" type="range"
						min="5" max="120" step="5" value="60" >
					<p>Preptime: <span id="demo"></span> minutes</p>
					<span class="errormessage">${preptimeerror}</span>

				</fieldset>

				<fieldset>
					<legend class="p1">URL of recipe:</legend>
					<input required type="text" name="siteurl" id="siteurl"
						value="${siteurlerror}" placeholder="Fill in recipe url"
						title="Must be a valid url" required
						pattern="https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)" />
					<span class="errormessage">${siteurlerror}</span> <br>
				</fieldset>

				<fieldset>
					<legend class="p1">URL of image for meal:</legend>
					<input required type="text" name="imageurl" id="imageurl"
						value="${imageurlerror}" placeholder="Fill in image url"
						title="Must be a valid url" /> 
<!-- 						required pattern="https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)"-->
						 
					<span class="errormessage">${imageurlerror}</span> <br>
				</fieldset>

				<input type="submit" value="Add meal to database" />

			</fieldset>
		</form>
	</div>
</body>
</html>