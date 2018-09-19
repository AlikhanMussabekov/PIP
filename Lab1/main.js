document.addEventListener("DOMContentLoaded", function(event) { 
	var canvas = document.getElementById("canvas");
	/*var video = document.getElementById("video");
	video.style.visibility  = 'hidden';*/

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

//fixed header
window.onscroll = function(){
	scrollHeader();
	console.log(2);
}

function scrollHeader(){
	if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
}

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

/*video.addEventListener('play', function() {
  var $this = this; //cache
  (function loop() {
    if (!$this.paused && !$this.ended) {
      ctx.drawImage($this, 0, 0);
      setTimeout(loop, 1000 / 30); // drawing at 30fps
    }
  })();

}, 0);*/

function validate(){

	yDiv = document.getElementById("yBlock");
	yLabel = document.getElementById("yLabel");
	checkY = yLabel.value;

	/*if (checkY == "NANI"){

		video.style.visibility = 'visible';

		video.load();
		video.autoplay = true;
		canvas.width  = video.videoWidth;
		canvas.height = video.videoHeight;

		return false;
	}*/

	//var result = checkY.match(/^[+-]?[0123]{0,1}([\.\,]\d+)?$/);
	var result = checkY.match(/^(\-|\+)?([0-9]+((\.|\,)[0-9]+)?)((E|e)\-?[0-9]+)?$/);
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

