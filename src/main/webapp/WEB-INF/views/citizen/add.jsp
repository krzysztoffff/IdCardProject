<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="../jspf/head_config.jspf"%>
<title>Add citizen</title>
</head>
<body class = "idbody">
	<%@include file="../jspf/main_menu.jspf"%><br>
	<%@include file="../jspf/header.jspf"%>
	
	<div class="guide">
	Dodawanie/Edycja osoby do bazy PESEL.<br>
	<ul>
	<li>Najważniejsze dane są walidowane.</li>
	<li>Aby wprowadzić PESEL trzeba wpisać prawdziwy nr. Można skorzystać z generatora numerów PESEL dostępnych w sieci.</li>
	<li>W przyszłości chciałbym wprowadzić rozkodowywanie nr PESEL oraz autouzupełnianie danych. Np miasta po kodzie pocztowym.</li>

	
	</ul>
	Zapraszam do klikania.
	
	
	</div>
	<p class = "description">Dodaj osobę</p>

<center>
	<form:form method="post" modelAttribute="citizen">
		<Table>
			<tr>
				<td><form:label path="pesel">PESEL </form:label></td>
				<td><form:input path="pesel" /><form:errors path = "pesel"/></td>
			</tr>
			<tr>
				<td><form:label path="firstName">Imię </form:label></td>
				<td><form:input path="firstName" /><form:errors path = "firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="secondName">Drugie imie </form:label></td>
				<td><form:input path="secondName" /><form:errors path = "secondName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Nazwisko </form:label></td>
				<td><form:input path="lastName" /><form:errors path = "lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="sex">Płeć </form:label></td>
				<td><form:input path="sex" /><form:errors path = "sex"/></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Data urodzenia</form:label></td>
				<td><form:input type="date" path="dateOfBirth" /><form:errors path = "dateOfBirth" /></td>
			</tr>
			<tr>
				<td><form:label path="street">Ulica </form:label></td>
				<td><form:input path="street" /><form:errors path = "street" /></td>
			</tr>
			<tr>
				<td><form:label path="numberOfBuilding">Nr lokalu </form:label></td>
				<td><form:input path="numberOfBuilding" /><form:errors path = "numberOfBuilding" /></td>
			</tr>
			<tr>
				<td><form:label path="city">Miasto </form:label></td>
				<td><form:input path="city" /><form:errors path = "city" /></td>
			</tr>
			<tr>
				<td><form:label path="postalCode">Kod pocztowy </form:label></td>
				<td><form:input path="postalCode" /><form:errors path="postalCode" /></td>
			</tr>
		</Table>
		
		
		
   


	<br><br>


		<input type="submit" class="buttons2" value="Zapisz"/>
		</center>

	</form:form>
	
	<%@include file="../jspf/footer.jspf"%>
</body>
</html>