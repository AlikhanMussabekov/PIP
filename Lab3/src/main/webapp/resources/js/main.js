var plot_canvas;
var plot_context;
var x;
var y;
var r=1;
var state = false;

$(document).ready(function(){
	plot_canvas = document.getElementById("canvas");
    plot_context = plot_canvas.getContext("2d");
    var rr = document.getElementById("r");
    draw();

	$(".resultTable tr").click(function() {

		event.currentTarget.style.backgroundColor = "grey";

		var values = $(event.currentTarget).find("td").toArray();

		x = values[0].innerText;
		y = values[1].innerText;
		statusText = values[4].innerText;

		var rSelect = document.getElementById("form:r");
		var R = rSelect.options[rSelect.selectedIndex].value;

		x = x*100/R;
		y = y*100/R;

		y *= -1;

		x += 150;
		y += 150;


		plot_context.beginPath();
		if(statusText === "Лежит")
			plot_context.fillStyle = 'white';
		else if (statusText === "Ошибка")
			return;
		else
			plot_context.fillStyle = 'red';

		plot_context.fillRect(x, y, 5, 5);

	});

});

function draw(){

    plot_context.beginPath();
    plot_context.arc(150, 150, 100, Math.PI, Math.PI/180*270);
    plot_context.lineTo(150, 150);
    plot_context.closePath();

    plot_context.rect(150, 150, 100, 50);
    plot_context.fillStyle = '#1976D2';
    plot_context.fill();

    plot_context.beginPath();
    plot_context.moveTo(150, 150);
    plot_context.lineTo(150, 100);
    plot_context.lineTo(250, 150);
    plot_context.lineTo(150, 150);
    plot_context.closePath();
    plot_context.fillStyle = '#1976D2';
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

	//r r/2 y
	plot_context.fillStyle = 'black';
	plot_context.beginPath();
	plot_context.moveTo(145,50);
	plot_context.lineTo(155,50);
	plot_context.stroke();

	plot_context.moveTo(145,100);
	plot_context.lineTo(155,100);
	plot_context.stroke();

	plot_context.moveTo(145,200);
	plot_context.lineTo(155,200);
	plot_context.stroke();

	plot_context.moveTo(145,250);
	plot_context.lineTo(155,250);
	plot_context.stroke();

	//r r/2 x
	plot_context.moveTo(50,145);
	plot_context.lineTo(50,155);
	plot_context.stroke();

	plot_context.moveTo(100,145);
	plot_context.lineTo(100,155);
	plot_context.stroke();

	plot_context.moveTo(200,145);
	plot_context.lineTo(200,155);
	plot_context.stroke();

	plot_context.moveTo(250,145);
	plot_context.lineTo(250,155);
	plot_context.stroke();

	//chars
	plot_context.beginPath();
	plot_context.font = "13px Montserrat";

	plot_context.fillText("Y",130,35);
	plot_context.fillText("r",160,55);
	plot_context.fillText("r/2",160,105);
	plot_context.fillText("0",140,165);
	plot_context.fillText("-r/2",120,195);
	plot_context.fillText("-r",130,245);

	plot_context.fillText("-r",50,165);
	plot_context.fillText("-r/2",100,165);
	plot_context.fillStyle = 'white';
	plot_context.fillText("r/2",200,165);
	plot_context.fillStyle = 'black';
	plot_context.fillText("r",250,165);
	plot_context.fillText("X",270,165);


    plot_canvas.addEventListener("click", drawPoint, false);
}


function validate(){

	var yDiv = document.getElementById("yBlock");
	var xDiv = document.getElementById("xBlock");
	var yLabel = document.getElementById("yLabel");
	var checkX = document.querySelector('input[name="x"]:checked').value;
	var checkY = yLabel.value;

	if (checkY === "party") {

		if (!state){
			start();

			var audio = new Audio('./media/Macarena.mp3');
			audio.play();
			changeBackground();

			state = true;
			return false;
		}else{
			location.reload();
			state = false;
			return false;
		}
	}

	var result = checkY.match(/^(\-|\+)?([0-9]+((\.|\,)[0-9]+)?)((E|e)\-?[0-9]+)?$/);

	if (result)
	{
		if (checkY < -5 || checkY > 5 || checkY===""){
			
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

function setR(value){
	resetCanvas();
	r = value;
}

function drawPoint(e) {
		var cell = getCursorPosition(e);

		plot_context.beginPath();
		plot_context.fillStyle = 'white';
		plot_context.fillRect(x, y, 5, 5);

		var rSelect = document.getElementById("form:r");
		var R = rSelect.options[rSelect.selectedIndex].value;


		x -= 150;
		y -= 150;
		y *= -1;
		x = x/100*R;
		y = y/100*R;

		$('#form\\:xLabel').val(x);
		$('#form\\:yLabel').val(y);

		$('#form\\:submitButton').click();

		$('#form\\:xLabel').val(null);
		$('#form\\:yLabel').val(null);

    }

function getCursorPosition(e) {
	var rect = canvas.getBoundingClientRect();
	x = e.clientX - rect.left;
	y = e.clientY - rect.top
}

function changeBackground()
{
	window.setTimeout( "changeBackground()", 571); // 5000 milliseconds delay

	var index = Math.round(Math.random() * 9);

	var ColorValue = "FFFFFF"; // default color - white (index = 0)

	if(index === 1)
		ColorValue = "FFCCCC"; //peach
	if(index === 2)
		ColorValue = "CCAFFF"; //viovar
	if(index === 3)
		ColorValue = "A6BEFF"; //lt blue
	if(index === 4)
		ColorValue = "99FFFF"; //cyan
	if(index === 5)
		ColorValue = "D5CCBB"; //tan
	if(index === 6)
		ColorValue = "99FF99"; //lt green
	if(index === 7)
		ColorValue = "FFFF99"; //lt yellow
	if(index === 8)
		ColorValue = "FFCC99"; //lt orange
	if(index === 9)
		ColorValue = "CCCCCC"; //lt grey

	document.getElementsByTagName("body")[0].style.backgroundColor = "#" + ColorValue;

}

function resetCanvas(){
	plot_context.clearRect(0, 0, plot_canvas.width, plot_canvas.height);
	draw();
}
