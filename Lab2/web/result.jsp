<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.cs.ifmo.entities.Point" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
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

	<c:forEach items="${requestScope.list}" var="point">
		<tr>
			<td>${point.getX()}</td>
			<td>${point.getY()}</td>
			<td>${point.getR()}</td>
			<td>${point.getDate()}</td>
			<td>${point.getWorkTime()} мс</td>
			<td>${point.getResult()}</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>