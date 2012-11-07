 function test(form,name) {
	 img_ok_id = name.toString().concat(new String("_ok_img"));
	 img_bad_id = name.toString().concat(new String("_bad_img"));
	 img_ok = document.getElementById(img_ok_id);
	 img_bad = document.getElementById(img_bad_id);
	if (form[name].value == "") {					
		img_ok.className = "undisplayed";
		img_bad.className = "displayed";
	} else {
		img_ok.className = "displayed";
		img_bad.className = "undisplayed";
	}
}
 function check() {
	var err = false;
	var enter = document.getElementById("enter");
	var ct = document.form1.elements.length-1;
	var i;
	for (i=0;i<ct;i++) {
		img_o_id = document.form1.elements[i].name.toString().concat(new String("_ok_img"));
		img_o = document.getElementById(img_o_id);
		if(img_o.className != "displayed") {
			err = true;
		}
	}
	if (err == true) {		
		enter.className="undisplayed";
	} else {
		enter.className="displayed";
	}
 }