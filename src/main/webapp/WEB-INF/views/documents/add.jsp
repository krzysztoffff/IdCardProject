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
<title>Nowy dokument</title>
</head>
<body class="idbody">
	<%@include file="../jspf/main_menu.jspf"%><br>
	<%@include file="../jspf/header.jspf"%>
	<p class="description">Nowy dokument</p>


	<center>
		<table>
			<tr>
				<td><form:form method="post" modelAttribute="documents">
						<form:input path="citizen" value="${documents.citizen.id}"
							type="hidden" />
						<br>
		<span class = "guide">Imie i nazwisko: </span>${documents.citizen.firstName } ${documents.citizen.lastName }<br>
  		<span class = "guide">PESEL </span> ${documents.citizen.pesel }<br>
						<span class = "guide">Nadaj nr dowodu osobistego </span><form:input path="idCardNumber" placeholder="idCardNumber" />
						<form:errors path="idCardNumber" />
						<br>
						<span class = "guide">Unikalna nazwa pliku zdjęcia na serwerze </span><form:input path="photo" readonly="readonly" 
							value="${sessionScope.photopath}" placeholder="photo" />
						<form:errors path="photo" />
						<br>

						<span class = "guide">Wprowadź datę wydania </span><form:input type="date" path="dateOfIssue"
							placeholder="dateOfIssue" />
						<form:errors path="dateOfIssue" />
						<br>
						<span class = "guide">Ustal datę ważności </span><form:input type="date" path="expiryDate" placeholder="expiryDate" />
						<form:errors path="expiryDate" />
						<br>


						<input class="buttons" type="submit">

					</form:form></td>
				<td><img class="idimage" alt="Twoje zdjęcie"
					src="${pageContext.request.contextPath}/resources/images/${sessionScope.photopath}"><br>
					<br></td>
			</tr>
		</table>





		<%@include file="../jspf/footer.jspf"%>
</body>
</html>