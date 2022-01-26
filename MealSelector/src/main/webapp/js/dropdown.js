/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function showDropdownt() {
	document.getElementById("typeDropdown").classList.toggle("show");
}

function hideDropdownt(id) {
	showDropdownt();
	document.getElementById("typeButton").innerText=id;
	document.getElementById("type").value=id;
}

function filterFunctiont() {
  var input, filter, ul, li, a, i;
  input = document.getElementById("typeInput");
  filter = input.value.toUpperCase();
  div = document.getElementById("typeDropdown");
  a = div.getElementsByTagName("a");
  for (i = 0; i < a.length; i++) {
    txtValue = a[i].textContent || a[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      a[i].style.display = "";
    } else {
      a[i].style.display = "none";
    }
  }
}

function showDropdown() {
  document.getElementById("myDropdown").classList.toggle("show");
}

function hideDropdown(id) {
  showDropdown();
  document.getElementById("cuisineButton").innerText=id;
  document.getElementById("cuisine").value=id;
}

function filterFunction() {
  var input, filter, ul, li, a, i;
  input = document.getElementById("cuisineInput");
  filter = input.value.toUpperCase();
  div = document.getElementById("myDropdown");
  a = div.getElementsByTagName("a");
  for (i = 0; i < a.length; i++) {
    txtValue = a[i].textContent || a[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      a[i].style.display = "";
    } else {
      a[i].style.display = "none";
    }
  }
}