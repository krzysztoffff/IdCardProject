<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="../jspf/head_config.jspf"%>
<title>Dowody osobiste</title>
</head>
<body class = "idbody">
	<%@include file="../jspf/main_menu.jspf"%><br>
	<%@include file="../jspf/header.jspf"%>
	<p>Dane z bazy pesel</p>


	<table class ="idtable">
		<tr>
			<th>id</th>
			<th>Imie</th>
			<th>Drugie imie</th>
			<th>Nazwisko</th>
			<th>PESEL</th>
			<th>Płeć</th>
			<th>Data urodzenia</th>
			<th>ulica</th>
			<th>nr domu</th>
			<th>Kod pocztowy</th>
			<th>Miasto</th>
		</tr>
		<tr>

			<td>${citizenfulldata.id}</td>
			<td>${citizenfulldata.firstName}</td>
			<td>${citizenfulldata.secondName}</td>
			<td>${citizenfulldata.lastName}</td>
			<td>${citizenfulldata.pesel}</td>
			<td>${citizenfulldata.sex}</td>
			<td>${citizenfulldata.dateOfBirth}</td>
			<td>${citizenfulldata.street}</td>
			<td>${citizenfulldata.numberOfBuilding}</td>
			<td>${citizenfulldata.postalCode}</td>
			<td>${citizenfulldata.city}</td>

		</tr>
	</table>
	<a
		href="${pageContext.request.contextPath}/documents/printdo/${citizenfulldata.id}"
		target="_blank"><input type="submit" class = "buttons" value="Drukuj Wniosek"></a>
	<a
		href="${pageContext.request.contextPath}/documents/add2/${citizenfulldata.id}">
		<input type="submit" class = "buttons" value="Nowy Dowód Osobisty"></a>






	<br>
	<br> Dokumenty gościa:
	<br>
	<c:choose>
		<c:when test="${documents != []}">

			<Table class ="idtable">
				<tr>


					<th>nr wpisu</th>
					<th>nr dowodu</th>
					<th>zdjęcie</th>
					<th>data wydania</th>
					<th>data ważności</th>
				</tr>
				<c:forEach var="d" items="${documents}">
					<tr>

						<td>${d.id}</td>
						<td>${d.idCardNumber}</td>
						<td><img class="idimage" alt="Twoje zdjęcie"
					src="${pageContext.request.contextPath}/resources/images/${d.photo}"></td>
						<td>${d.dateOfIssue}</td>
						<td>${d.expiryDate}</td>



					</tr>
				</c:forEach>

			</Table>


		</c:when>
		<c:otherwise>
		Brak wydanych dokumentów
		</c:otherwise>
	</c:choose>

<%@include file="../jspf/footer.jspf"%>

</body>
</html>