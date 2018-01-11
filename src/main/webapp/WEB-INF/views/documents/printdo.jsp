<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wniosek</title>
</head>
<body>
	<h3>Wniosek o wydanie dowodu osobistego</h3>

	<p>Dane wnioskodawcy:</p>
	<table class = "toPrint">
		
		

			<tr><td>Imie: </td><td>${citizen.firstName}</td></tr>
			<tr><td>Drugie imie: </td><td>${citizen.secondName}</td></tr>
			<tr><td>Nazwisko: </td><td>${citizen.lastName}</td></tr>
			<tr><td>PESEL: </td><td>${citizen.pesel}</td></tr>
			<tr><td>Płeć: </td><td>${citizen.sex}</td></tr>
			<tr><td>Data urodzenia</td><td>${citizen.dateOfBirth}</td></tr>
			<tr><td colspan ="2"><br>Adres zameldowania: <br>&nbsp</td></tr>
			<tr><td>Ulica:</td><td>${citizen.street}</td></tr>
			<tr><td>Nr domu</td><td>${citizen.numberOfBuilding}</td></tr>
			<tr><td>Kod pocztowy</td><td>${citizen.postalCode}</td></tr>
			<tr><td>Miejscowość</td><td>${citizen.city}</td></tr>
	</table>
	<br><br><br>
	
podpis







</body>
</html>