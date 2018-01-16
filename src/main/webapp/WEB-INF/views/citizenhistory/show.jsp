<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="../jspf/head_config.jspf"%>
<title>Show history</title>
</head>
<body class = "idbody">
	<%@include file="../jspf/main_menu.jspf"%><br>
	<%@include file="../jspf/header.jspf"%>
	
	<p class = "description">Historia bazy PESEL</p>




 
	<form:form  method="post" modelAttribute="findchistory">
	<form:label class = "description" path="pesel">Historia po nr PESEL </form:label>
	<form:input path="pesel" /><form:errors path = "pesel" />
	<input type=submit value="Generuj">
	</form:form>
	



	<br>
	<br>

	<c:choose>
		<c:when test="${onecitizenhistory != null}">

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
					<th>Wykonane akcje</th>
					<th>Czas akcji</th>
				</tr>


				<c:forEach var="cl" items="${onecitizenhistory}">
					<tr>

						<td>${cl.id}</td>
						<td>${cl.firstName}</td>
						<td>${cl.secondName}</td>
						<td>${cl.lastName}</td>
						<td>${cl.pesel}</td>
						<td>${cl.sex}</td>
						<td>${cl.dateOfBirth}</td>
						<td>${cl.street}</td>
						<td>${cl.numberOfBuilding}</td>
						<td>${cl.postalCode}</td>
						<td>${cl.city}</td>
						<td>${cl.action}</td>
						<fmt:formatDate value="${cl.actionTime}" var="actionTimeb"
							pattern="dd/MM/yyyy HH:mm" />
						<td>${actionTimeb}</td>


					</tr>
				</c:forEach>
			</table>


		</c:when>

	</c:choose>


	<br>
	


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
			<th>Wykonane akcje</th>
			<th>Czas akcji</th>
		</tr>


		<c:forEach var="ch" items="${citizenhistory}">
			<tr>

				<td>${ch.id}</td>
				<td>${ch.firstName}</td>
				<td>${ch.secondName}</td>
				<td>${ch.lastName}</td>
				<td>${ch.pesel}</td>
				<td>${ch.sex}</td>
				<td>${ch.dateOfBirth}</td>
				<td>${ch.street}</td>
				<td>${ch.numberOfBuilding}</td>
				<td>${ch.postalCode}</td>
				<td>${ch.city}</td>
				<td>${ch.action}</td>
				<fmt:formatDate value="${ch.actionTime}" var="actionTime"
					pattern="dd/MM/yyyy HH:mm" />
				<td>${actionTime}</td>


			</tr>
		</c:forEach>
	</table>







	<br>
	<br>



<%@include file="../jspf/footer.jspf"%>




</body>
</html>