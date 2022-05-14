<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/dropdown.js" defer></script>
<script src="js/preptimeslider.js" defer></script>
<link href="main.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>MealSelector: Home</title>
</head>
<body>
	<div class="topnav">
		<a class="active" href="index">Home</a> <a href="viewmeal">Random meal</a> <a href="database">Database</a> <a href="inputmeal">Input Meal</a>
	</div>
	<div class="bg-image"></div>

	<div class="bg-text">
		<h1 class="p1">MealSelector</h1>

		<form action="selector" method="get">
			<fieldset>
				<legend class="p1">Meal Options</legend>
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
					<input type="hidden" id="type" name="type" value="" />
				</fieldset>
			
			<fieldset>
				<legend class="p1">Max preperation time</legend>
				<input class="slider" name="preptime" id="preptime" type="range"
					min="5" max="120" step="5" value="120">
				<p>
					Preptime: <span id="demo"></span> minutes
				</p>

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
					<input type="hidden" id="cuisine" name="cuisine" value="" />
				</fieldset>
			</fieldset>
			<p>
				<input type="submit" value="Narrow down your search" />
			</p>
			</fieldset>
		</form>
	</div>

</body>
</html>