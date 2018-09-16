document.addEventListener("DOMContentLoaded", function(event) { 
	var canvas = document.getElementById("canvas");
	ctx = canvas.getContext('2d');
	
	/*ctx.moveTo(canvas.width/2,canvas.height);
	ctx.lineTo(canvas.width/2,0);

	ctx.moveTo(0,canvas.height/2);
	ctx.lineTo(canvas.width, canvas.height/2);

	ctx.stroke();*/

	pic = new Image();
	pic.src = './media/areas.png';
	pic.onload = function(){
		ctx.drawImage(pic,0,0,canvas.width, canvas.height);
	}

});

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
            
            iFrameID.height = "";
            iFrameID.height = iFrameID.contentWindow.document.body.scrollHeight + "px";
      }   
  }

function validate(){

	yDiv = document.getElementById("yBlock");
	yLabel = document.getElementById("yLabel");
	checkY = yLabel.value;

	var result = checkY.match(/^[+-]?[0123]{0,1}([\.\,]\d+)?$/);

	if (result)
	{

		if (checkY < -3 || checkY > 3 || checkY==""){
			
			yDiv.style.backgroundColor = 'red'

			return false;
		}else {
			yLabel.style.borderColor = 'white';

			yDiv.style.backgroundColor = '#1976D2';

			return true;
		}
	}else {

		yDiv.style.backgroundColor = 'red'

		return false;
	}

}



