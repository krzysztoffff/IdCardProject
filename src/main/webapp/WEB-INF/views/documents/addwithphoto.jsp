<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1 ">
<%@include file="../jspf/head_config.jspf"%>

<title>Nowy dokument</title>
</head>
<body class="idbody">
	<%@include file="../jspf/main_menu.jspf"%><br>
	<%@include file="../jspf/header.jspf"%>


	<p class="description">Nowy dokument dla
		${sessionScope.citizen.firstName} ${sessionScope.citizen.lastName}</p>
	<p class="iderrors">${flashmessage}</p>

	<c:choose>
		<c:when test="${photook!=null}">
		<a href = "${pageContext.request.contextPath}/documents/add/${sessionScope.citizen.id}"><input type="submit" class = "buttons" value="Przejdź dalej"></a>
		</c:when>
		<c:otherwise>

			<form method="POST"
				action="${pageContext.request.contextPath}/documents/upload"
				enctype="multipart/form-data">
				<input type="file" class="addphoto" name="file" /><br /> <br /> <input
					type="submit" class="buttons" value="Dodaj zdjęcie jpg" /> <br>
		</c:otherwise>
	</c:choose>


	</form>







	<%@include file="../jspf/footer.jspf"%>

</body>
</html>