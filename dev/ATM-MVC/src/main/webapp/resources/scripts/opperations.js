var element = null;
function opp(name) {
	if (element == null) {
		document.getElementById(name).className="displayed";
		element = name;
	} else {
		document.getElementById(element).className="undisplayed";
		document.getElementById(name).className="displayed";
		element = name;
	}
}

function errorTimer() {
	document.getElementById("error").innerHTML = '';
}

setTimeout(errorTimer, 5000);