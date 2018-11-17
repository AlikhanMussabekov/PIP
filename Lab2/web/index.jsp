<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.cs.ifmo.entities.Point" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.cs.ifmo.model.Model" %>
<jsp:useBean id="results" class="ru.cs.ifmo.model.Model" scope="session"/>

<!DOCTYPE html>

<html>

<head>
	<meta charset="utf-8">
	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
	<script type="text/javascript" src="./js/confetti.js"></script>
	<script type="text/javascript" src="./js/main.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>Servlet</title>
</head>

<body>

<div class="title">
	Мусабеков Алихан Нурланович. Группа Р3211. Вариант 28112

	<ul>
		<li>
			<a href="http://vk.com/vm_franky">
				<img src="./media/vk.png" border="0" width="30" height="30">
			</a>

		<li>
			<a href="http://instagram.com/alikhan_msb">
				<img src="./media/instagram.png" border="0" width="30" height="30">
			</a>

		<li>
			<a href="http://github.com/alikhanmussabekov">
				<img src="./media/github.png" border="0" width="30" height="30">
			</a>

	</ul>

</div>
<form id="form" method="get" action="controller">

	<table class="mainTable" >
		<tr>
			<td>
				<div class="megaBlock">
					<div class="block">

						<div class="blockText">
							Координата X (диапазон от -4 до 4)
						</div>

						<div class="inputBlock" >

							<input type="radio" id="-4" value="-4" name="x">
							<label for="-4">-4</label>

							<input type="radio" id="-3" value="-3" name="x">
							<label for="-3">-3</label>

							<input type="radio" id="-2" value="-2" name="x">
							<label for="-2">-2</label>

							<input type="radio" id="-1" value="-1" name="x">
							<label for="-1">-1</label>

							<input checked type="radio" id="0" value="0" name="x">
							<label for="0">0</label>

							<input type="radio" id="1" value="1" name="x">
							<label for="1">1</label>

							<input type="radio" id="2" value="2" name="x">
							<label for="2">2</label>

							<input type="radio" id="3" value="3" name="x">
							<label for="3">3</label>

							<input type="radio" id="4" value="4" name="x">
							<label for="4">4</label>
						</div>

					</div>

					<div class="block" id="yBlock">

						<div class="blockText">
							Координата Y (диапазон от -5 до 5)
						</div>

						<div class="inputBlock">
							<input class="input" id="yLabel" type="text" name="y" maxlength="10">
						</div>

					</div>

					<div class="block">

						<div class="blockText">
							Параметр R (диапазон от 1 до 5 )
						</div>

						<div class="inputBlock">

							<select id="r" form="form" name="r">
								<option selected value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>

						</div>

					</div>

					<div class="buttonBlock">
						<input type="submit" class="submitButton" value="Проверить" onclick="return validate()">


					</div>

				</div>
			</td>

			<td>
				<div class="chartBlock">
					<canvas width="300" height="300" id="canvas"></canvas>
				</div>
			</td>
		</tr>
	</table>

</form>

<%--<div align="center">
	<iframe id="theFrame" name="theFrame" onload="iframeLoaded()"></iframe>
</div>--%>

<table class="resultTable">
	<c:if test="${results.getPoints().size() != 0}">
		<tr>
			<td>x</td>
			<td>y</td>
			<td>r</td>
			<td>Время</td>
			<td>Время работы</td>
			<td>Результат</td>
		</tr>

		<c:forEach items="${results.getPoints()}" var="point">
			<tr>
				<td>${point.getX()}</td>
				<td>${point.getY()}</td>
				<td>${point.getR()}</td>
				<td>${point.getDate()}</td>
				<td>${point.getWorkTime()} мс</td>

				<c:choose>
					<c:when test="${point.getResult() == 'Лежит'}">
						<td class="true">${point.getResult()}</td>
					</c:when>

					<c:otherwise>
						<td class="false">${point.getResult()}</td>
					</c:otherwise>

				</c:choose>
			</tr>
		</c:forEach>
	</c:if>
</table>
<canvas class="confetti" id="confetti"></canvas>
</body>

</html>