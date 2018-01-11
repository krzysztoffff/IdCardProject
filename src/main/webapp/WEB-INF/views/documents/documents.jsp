<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dowody osobiste</title>
</head>
<body>
	<p>Dane z bazy pesel</p>


	<table border=1>
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
		target="_blank"><input type="submit" value="Drukuj Wniosek"></a>
	<a
		href="${pageContext.request.contextPath}/documents/add/${citizenfulldata.id}">
		<input type="submit" value="Nowy Dowód Osobisty"></a>






	<br>
	<br> Dokumenty gościa:
	<br>
	<c:choose>
		<c:when test="${documents != []}">

			<Table border="1">
				<tr>


					<th>nr wpisu</th>
					<th>nr dowodu</th>
					<th>scieżka do zdjęcia</th>
					<th>data wydania</th>
					<th>data ważności</th>
					<th>data ważności LocalDate()</th>
				</tr>
				<c:forEach var="d" items="${documents}">
					<tr>

						<td>${d.id}</td>
						<td>${d.idCardNumber}</td>
						<td>${d.photo}</td>
						<td>${d.dateOfIssue}</td>
						<td>${d.expiryDate}</td>
						<td>${d.expiryDate2}</td>



					</tr>
				</c:forEach>

			</Table>


		</c:when>
		<c:otherwise>
		Brak wydanych dokumentów
		</c:otherwise>
	</c:choose>



</body>
</html>