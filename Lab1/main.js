function viewX() {
	document.getElementById("text").value = document.getElementById("rangeInput").value
}

function decreaseX(){
	if(document.getElementById("xLabel").value > -3){
		document.getElementById("xLabel").value--
	}
}

function increaseX(){
	if (document.getElementById("xLabel").value < 5)
		document.getElementById("xLabel").value++
}

function decreaseR(){

	check = new Number(document.getElementById("rLabel").value)	

	if(check > 1){
		check-=0.5;
		document.getElementById("rLabel").value = check;
	}
}

function increaseR(){

	check = new Number(document.getElementById("rLabel").value)

	if (check < 3)
		check+=0.5;
		document.getElementById("rLabel").value = check;
}

function iframeLoaded() {
      var iFrameID = document.getElementById('theFrame');
      if(iFrameID) {
            // here you can make the height, I delete it first, then I make it again
            iFrameID.height = "";
            iFrameID.height = iFrameID.contentWindow.document.body.scrollHeight + "px";
      }   
  }

function validate(){

	checkY = document.getElementById("yLabel").value

	if(!isNaN(checkY)){
		if (checkY < -3 || checkY > 3){
			alert("Координата Y должна лежать в диапазоне {-3 ... 3}");
			window.open("server.php", "theFrame");
			return false;
		}else {
			return true;
		}
	}
	else {
			alert("Координата Y не может быть символом");
			return false;
	}
}