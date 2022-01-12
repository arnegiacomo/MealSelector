"use strict";

class inputmeal {

}
let myForm = document.getElementById('inputform');
let formChanged = false;
myForm.addEventListener('change', () => formChanged = true);
myForm.addEventListener('submit', () => formChanged = false);
window.addEventListener('beforeunload', (event) => {
	if (formChanged) {
		event.returnValue = 'You have unfinished changes!';
	}
});