<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nowy dokument</title>
</head>
<body>
	Nowy dokument

	 
  <form:form method="post" modelAttribute="documents">
  Wpisz id citizena <form:input path="citizen" value = "${documents.citizen.id}" /><br>
  PESEL ${documents.citizen.pesel }<br>
  <form:input path="idCardNumber" placeholder="idCardNumber"/><form:errors path="idCardNumber"/><br>
  <form:input path="photo" placeholder="photo"/><form:errors path="photo"/><br>
  <form:input path="dateOfIssue" placeholder="dateOfIssue"/><form:errors path="dateOfIssue"/><br>
  <form:input path="expiryDate" placeholder="expiryDate"/><form:errors path="expiryDate"/><br>
  
  <form:input type = "date" path="expiryDate2"  /><form:errors path="expiryDate2"/><br>

 <input type = "submit">
 
 </form:form>
		
		
		


		
</body>
</html>