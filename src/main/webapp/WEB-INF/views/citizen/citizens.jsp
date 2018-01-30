<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="../jspf/head_config.jspf"%>
<title>List</title>
</head>
<body class = "idbody">
	<%@include file="../jspf/main_menu.jspf"%><br>
	<%@include file="../jspf/header.jspf"%>
	
	
	
	<div class="guide">
	To jest baza obywateli PESEL.<br>
	Tu możesz:
	<ul>
	<li>Dodać/edytować/usunąć osobę.</li>
	<li>Każda akcja zostanie zapisana w historii.</li>
	<li>Aby móc utworzyć Dowód Osobisty musi on być przyporządkowany osobie z tej bazy.</li>
	<li>Aby móc później utworzyć dowód osobisty skopiuj PESEL wybranej osoby.</li>
	</ul>
	Zapraszam do klikania.
	
	
	</div>
	<p class = "description"> Baza pesel</p>

<a href = "${pageContext.request.contextPath}/citizen/add"><input type = "submit" class="buttons2" value = "Dodaj osobę do bazy PESEL"></a><br><br>
	<Table class ="idtable">
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
	<th colspan = "2">Akcje</th>
	</tr>
		<c:forEach var="c" items="${citizens}">
			<tr>
				<td>${c.id}</td>
				<td>${c.firstName}</td>
				<td>${c.secondName}</td>
				<td>${c.lastName}</td>
				<td>${c.pesel}</td>
				<td>${c.sex}</td>
				<td>${c.dateOfBirth}</td>
				<td>${c.street}</td>
				<td>${c.numberOfBuilding}</td>
				<td>${c.postalCode}</td>
				<td>${c.city}</td>
				
				
				<td><a href="${pageContext.request.contextPath}/citizen/delete/${c.id}"><input type="submit" value="Usuń" class="buttons2"></a></td>
    			<td><a href="${pageContext.request.contextPath}/citizen/edit/${c.id}"><input type="submit" value="Edytuj" class="buttons2"></a></td>

			</tr>
		</c:forEach>

	</Table>
	
	
	</center>
	
	
	
<%@include file="../jspf/footer.jspf"%>





</body>
</html>