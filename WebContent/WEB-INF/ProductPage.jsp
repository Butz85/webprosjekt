<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p><jsp:include page="languages.jsp" /></p>

	<fmt:bundle basename="language.Language">

		<c:forEach items="${plist}" var="items">

			<p>
				<h3><fmt:message key='${items.PName}'/></h3>
				<!--FYI: måtte escape whitespace i language filer med \-->
			<p>
				<fmt:message key="price"/>
				<fmt:message key="currencySymbol" />
				<fmt:formatNumber value="${items.priceInEuro*currencyRate}" type="currency"/>
			<p>
				<img src="images/<c:out value='${items.imageFile}'/>" width="250"
					height="250">
			<p>
				<br>
				<c:out value=""></c:out>
				<fmt:message key="description" />
			<p>
				<fmt:message key="description${items.pNo}" />
			<p>
			<form name="${items.pNo}" action="ShopCartServlet" method="post">
				<input type="hidden" value="${items.pNo}" name="produktId"/>
				<input type="submit" value="<fmt:message key="addItem" />"
					name="${items.pNo}"/>
			</form>
			<p></p>
			<br>
		</c:forEach>

		<p>
			<a href="index.jsp"><fmt:message key="home" /> </a> &emsp;             
			<a href="ShopCartServlet"><fmt:message key="cart" /> </a>
		</p>
	</fmt:bundle>

</body>
</html>