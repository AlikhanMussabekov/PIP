<?php

//https://youtu.be/PilI7T4soFw?t=21m51s

	session_start();

 	$time_pre = microtime(true);

	date_default_timezone_set("Europe/Moscow");

	if(isset($_POST["x"]) and isset($_POST["y"]) and isset($_POST["r"])){

 		$x = intval($_POST["x"]); 
		$y = floatval(str_replace(",", ".", $_POST["y"])); 
		$r = floatval($_POST["r"]); 

		
		$check = false;
		$result = "Не лежит";

		if (!(is_numeric($x) && is_numeric($y) && is_numeric($r))) {

        	array_push ($_SESSION['arr'],"<tr> <td colspan='6' class='false'><b>ОШИБКА</b></td> </tr>");

    	}
    	elseif (  ($x<(-3)) || ($x>5)  ||  ($y<(-3)) || ($y>3)  ||  ($r<1) || ($r > 3)  ) {

    		array_push ($_SESSION['arr'],"<tr> <td colspan='6' class='false'><b>ОШИБКА</b></td> </tr>");

    	} 
    	else {

	 		if ($x<=0 && $y>=0){

	 			if($x >= (0-$r) && $y <= $r){
	 				$result = "Лежит";
	 				$check = true;
	 			}

	 		}elseif($x >= 0 && $y >= 0){

	 			$count = 4 * ($x*$x + $y*$y);

	 			if($count <= $r*$r){
	 				$result = "Лежит";
	 				$check = true;
	 			}

	 		}elseif($x>=0 && $y<=0){

	 			$rad=$r/2;

	 			$count = (-3 - $rad)*$x + (0 - $rad)*$y + (0-($rad*(-3)));

				if($count<=0){
					$result = "Лежит";
					$check = true;
				}

	 		}

	 		$date = date('h:i:s a', time());
 			$time = number_format(stop() - $time_pre,6);

 			$checkStr = $check ? "true" : "false";

 			$td = "<tr> <td>$x</td> <td>$y</td> <td>$r</td>
                     <td>$date</td> <td>$time сек</td> <td class=$checkStr>$result</td></tr>";


			array_push($_SESSION['arr'], $td);

 		}

	}else{
		array_push ($_SESSION['arr'],"<tr> <td colspan='6' class='false'><b>ОШИБКА</b></td> </tr>");
	}	
 		
	function stop(){
		return microtime(true);
	}

?>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./style.css">
	<title>Result</title>
</head>
<body>

	<table class="resultTable">
		<tr>
			<td>x</td>
			<td>y</td>
			<td>r</td>
			<td>Время</td>
			<td>Время работы</td>
			<td>Результат</td>
		</tr>

		<?php 
			foreach ($_SESSION['arr'] as $item) {
  				echo $item;
			}
		?>

	</table>

</body>
</html>


<!-- <?php echo $check ? "true" : "false"; ?> -->