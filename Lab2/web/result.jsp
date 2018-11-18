<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.cs.ifmo.entities.Point" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.cs.ifmo.model.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="point" class="ru.cs.ifmo.entities.Point" scope="session"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i" rel="stylesheet">
	<title>Result</title>
</head>
<body>

<div id="tableContainer-1">
	<div id="tableContainer-2">

		<table class="resultTable center">
			<tr>
				<td>x</td>
				<td>y</td>
				<td>r</td>
				<td>Время</td>
				<td>Время работы</td>
				<td>Результат</td>
			</tr>


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

			<tr>
				<td colspan="6">
					<form action="${pageContext.request.contextPath}/index.jsp">
						<button class="back_button" type="submit">Вернуться на главную</button>
					</form>
				</td>
			</tr>

		</table>
	</div>
</div>
</body>
</html>