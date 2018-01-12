<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="../jspf/head_config.jspf"%>
<title>Podaj pesel</title>
</head>
<body class = "idbody">
	<%@include file="../jspf/main_menu.jspf"%><br>
	<%@include file="../jspf/header.jspf"%>


	 
  <form:form method="post" modelAttribute="citizen">
   <form:label class = "description" path="pesel"> Znajdź po nr PESEL </form:label>
				<form:input path="pesel" /><br>${message}<form:errors class = "iderrors" path = "pesel"/><br>

  

 <input type = "submit">
 
 </form:form>
 

		
		
		<%@include file="../jspf/footer.jspf"%>


		
</body>
</html>