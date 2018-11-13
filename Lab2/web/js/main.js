var plot_canvas;
var plot_context;
var x;
var y;
var state = false;

document.addEventListener("DOMContentLoaded", function(event) {
	
	plot_canvas = document.getElementById("canvas");
    plot_context = plot_canvas.getContext("2d");
    var rr = document.getElementById("r");
    draw();
});

function iframeLoaded() {
      var iFrameID = document.getElementById('theFrame');
      if(iFrameID) {
            
            iFrameID.height = "";
            iFrameID.height = iFrameID.contentWindow.document.body.scrollHeight + "px";
      }   
}

function draw(){

    plot_context.beginPath();
    plot_context.arc(150, 150, 100, Math.PI, Math.PI/180*270);
    plot_context.lineTo(150, 150);
    plot_context.closePath();

    plot_context.rect(150, 150, 100, 50);
    plot_context.fillStyle = 'blue';
    plot_context.fill();

    plot_context.beginPath();
    plot_context.moveTo(150, 150);
    plot_context.lineTo(150, 100);
    plot_context.lineTo(250, 150);
    plot_context.lineTo(150, 150);
    plot_context.closePath();
    plot_context.fillStyle = 'blue';
    plot_context.fill();

	plot_context.beginPath();
	//Ox
	plot_context.moveTo(30, 150);
	plot_context.lineTo(270, 150);
	plot_context.lineTo(260, 140);
	plot_context.moveTo(270, 150);
	plot_context.lineTo(260, 160);
	//Oy
	plot_context.moveTo(150, 30);
	plot_context.lineTo(140, 40);
	plot_context.moveTo(150, 30);
	plot_context.lineTo(160, 40);
	plot_context.moveTo(150, 30);
	plot_context.lineTo(150, 270);
	plot_context.moveTo(30, 150);
	plot_context.closePath();
	plot_context.stroke();

    plot_canvas.addEventListener("click", drawPoint, false);
  
	/*pic = new Image();
	pic.src = './media/areas.png';
	pic.onload = function(){
		ctx.drawImage(pic,0,0,canvas.width, canvas.height);
	}*/
}


function validate(){

	yDiv = document.getElementById("yBlock");
	xDiv = document.getElementById("xBlock");
	yLabel = document.getElementById("yLabel");
	checkX = document.querySelector('input[name="x"]:checked').value;
	checkY = yLabel.value;

	if (checkY == "PARTY") {
		var confettiSettings = {
			"target": "canvas",
			"max": "100",
			"size": "2",
			"animate": true,
			"props": ["circle", "square", "triangle", "line"],
			"colors": [[165, 104, 246], [230, 61, 135], [0, 199, 228], [253, 214, 126]],
			"clock": "30",
			"rotate": false,
			"width": "300",
			"height": "300"
		};
		var confetti = new ConfettiGenerator(confettiSettings);

		if(!state) {
			confetti.render();
			state = true;
		}
		else{
			confetti.clear();
			state = false;
			//draw();
		}
		/*setTimeout(confetti.clear(), 10 * 1000);

		draw();*/

		return false;
	}

	var result = checkY.match(/^(\-|\+)?([0-9]+((\.|\,)[0-9]+)?)((E|e)\-?[0-9]+)?$/);

	if (result)
	{
		if (checkY < -5 || checkY > 5 || checkY==""){
			
			yDiv.style.backgroundColor = 'red'

			return false;
		}else {
			yLabel.style.borderColor = 'white';

			yDiv.style.backgroundColor = '#1976D2';

			return true;
		}
	}else{

		yDiv.style.backgroundColor = 'red'

		return false;
	}

}

function drawPoint(e) {

	    var rSelect = document.getElementById("r");
	    var R = rSelect.options[rSelect.selectedIndex].value;

		var cell = getCursorPosition(e);

		plot_context.beginPath();
		plot_context.rect(x, y, 5, 5);

		x -= 150;
		y -= 150;
		y *= -1;
		x = x/100*R;
		y = y/100*R;

		$.ajax({
			type:'get',
			url:'controller',
			data:{'x':x, 'y':y, 'r':R},
			response:'text',
			error: function (message) {
				console.log(message);

				alert("Error " + message);
			},
			success:function (data) {
				console.log(data);

				var ifr = document.getElementById('theFrame').contentDocument;
				ifr.open();
				ifr.writeln(data);
				ifr.close();

			}
		});

    }

function getCursorPosition(e) {
	var rect = canvas.getBoundingClientRect();
	x = e.clientX - rect.left;
	y = e.clientY - rect.top
}

