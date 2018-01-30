<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="jspf/head_config.jspf"%>
<title>Id Card Project</title>
</head>
	
	<body class = "idbody">
	
	
	<%@include file="jspf/header.jspf"%>
	<%@include file="jspf/main_menu.jspf"%><br>
	</center>
	<div class="guide">
	Witam!<br>
	To jest mój projekt końcowy kursu Java EE w Coders Lab.
	W tym prostokąciku będę opisywał co program robi.<br>
	W tej chwili działają następujące funkcje.
	<ul>
	<li>Dodawanie/edycja/usuwanie osoby z bazy PESEL.</li>
	<li>Osoba z bazy może mieć utworzony dowód osobisty ze zdjęciem.</li>
	<li>W bazie jest trochę zmyślonych danych oraz kilka zdjęć zapożyczonych z sieci.</li>
	</ul>
	Zapraszam do klikania.
	
	
	</div>
	<%@include file="jspf/footer.jspf"%>


</body>
</html>