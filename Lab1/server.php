<?php

//https://youtu.be/PilI7T4soFw?t=21m51s

	session_start();

 	$time_pre = microtime(true);

	date_default_timezone_set("Europe/Moscow");

	if(isset($_POST["x"]) and isset($_POST["y"]) and isset($_POST["r"])){

		session_regenerate_id();

 		$x = intval($_POST["x"]); 
		$y = floatval(str_replace(",", ".", $_POST["y"])); 
		$r = floatval($_POST["r"]); 

		
		$check = false;
		$result = "Не лежит";

		if (!(is_numeric($x) && is_numeric($y) && is_numeric($r))) {

        	array_push ($_SESSION['arr'],"<tr> <td colspan='6'><b>ОШИБКА1</b></td> </tr>");

    	}
    	elseif (  ($x<(-3)) || ($x>5)  ||  ($y<(-3)) || ($y>3)  ||  ($r<1) || ($r > 3)  ) {

    		array_push ($_SESSION['arr'],"<tr> <td colspan='6'><b>ОШИБКА2</b></td> </tr>");

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
 			$time = stop() - $time_pre;


			array_push($_SESSION['arr'], "<tr> <td>$x</td> <td>$y</td> <td>$r</td>
                     <td>$date</td> <td>$time</td> <td>$result</td></tr>");

 		}

	}else{
		array_push ($_SESSION['arr'],"<tr> <td colspan='6'><b>ОШИБКА</b></td> </tr>");
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

	<!-- <div id="tableContainer-1">
 		<div id="tableContainer-2">
 -->
			<table>
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

	<!-- 	</div>
	</div> -->

</body>
</html>


<!-- <!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./style.css">
	<title>Result</title>
</head>
<body>

	<div id="tableContainer-1">
 		<div id="tableContainer-2">
 
			<table class="<? echo $check ? 'true' : 'false'; ?>">
				<tr>
					<td> Координата X: </td>

					<td><?php echo $x?></td>
				</tr>

				<tr>
					<td> Координата Y: </td>

					<td><?php echo $y?></td>
				</tr>
				<tr>
					<td> Параметр R: </td>

					<td><?php echo $r?></td>
				</tr>
				<tr>
					<td> Текущее время: </td>

					<td><?php echo $date?></td>
				</tr>
				<tr>
					<td> Время работы скрипта: </td>

					<td><?php echo date("i:s:u",stop()-$time_pre) ?></td>
				</tr>

				<tr>
					<td class=<?php echo $check ? "true" : "false"; ?> colspan="2"> <?php echo $result?> </td>
				</tr>

			</table>
		</div>
	</div>

</body>
</html> -->