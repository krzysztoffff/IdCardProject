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
	
	<div class="guide">
		Dodawanie dowodu osobistego - ostatni krok.<br>
		<ul>
			<li>Wypełnij pola zgodnie z opisami.</li>
			<li>Kliknij zapisz i zobacz czy <i>obywatel</i> ma nowy dowód osobisty.</li>

		</ul>


	</div>
	
	<p class="description">Nowy dokument</p>


	<center>

		<form:form method="post" modelAttribute="documents">
			<form:input path="citizen" value="${documents.citizen.id}"
				type="hidden" />
			<table>
				<tr>
					<td id="td_add_doc"><span class="description2">Imie i nazwisko: </span></td>
					<td>${documents.citizen.firstName }
						${documents.citizen.lastName }</td>
					<td rowspan="6" id="td_photo"><img class="idimage" alt="Twoje zdjęcie"
						src="${pageContext.request.contextPath}/resources/images/${sessionScope.photopath}"><br>
						<br></td>
				</tr>
				<tr>
					<td id="td_add_doc"><span class="description2">PESEL </span></td>
					<td>${documents.citizen.pesel }</td>
				</tr>
				<tr>
					<td id="td_add_doc"><span class="description2">Nadaj nr dowodu osobistego </span></td>
					<td><form:input path="idCardNumber" placeholder="idCardNumber" />
						<form:errors class="iderrors" path="idCardNumber" /></td>
				</tr>
				<tr>
					<td id="td_add_doc"><span class="description2">Unikalna nazwa pliku zdjęcia na
							serwerze </span></td>
					<td><form:input path="photo" readonly="true"
							value="${sessionScope.photopath}" placeholder="photo" /></td>
				</tr>
				<tr>
					<td id="td_add_doc"><span class="description2">Wprowadź datę wydania </span></td>
					<td><form:input type="date" path="dateOfIssue"
							placeholder="dateOfIssue" /> <form:errors class="iderrors" path="dateOfIssue" /></td>
				</tr>
				<tr>
					<td id="td_add_doc"><span class="description2">Ustal datę ważności </span></td>
					<td><form:input type="date" path="expiryDate"
							placeholder="expiryDate" /> <form:errors class="iderrors" path="expiryDate" /></td>
				</tr>


			</table>

			<input class="buttons" type="submit" value = "Zapisz">

		</form:form>


		




		<%@include file="../jspf/footer.jspf"%>
</body>
</html>