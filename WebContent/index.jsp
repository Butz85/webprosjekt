<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BokButikken.no</title>
</head>
<body>
	<p><jsp:include page="WEB-INF/languages.jsp" /></p>

	<h1>BokButikken.no</h1>

	<!-- Logo -->
	<img src="images/book-logo.jpg" width="250" height="250"
		alt="Bokklubbens logo">

	<fmt:bundle basename="language.Language">

		<h3>
			<fmt:message key="home" />
		</h3>
		<p>
			<fmt:message key="welcomeMessage" />
		</p>
		<p>
			<a href="ProductPage"><fmt:message key="products" /> </a>
		</p>
	</fmt:bundle>








</body>
</html>