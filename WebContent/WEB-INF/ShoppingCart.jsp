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
		<h1>Todo ShoppingCartPage .. . .</h1>

		<c:forEach items="${sc.productList}" var="items">
			<table>
				<tr>
					<fmt:message key='${items.PName}' />
				</tr>
				
				<fmt:formatNumber value="${items.priceInEuro}" type="currency" />


			</table>
		</c:forEach>

		<p>
			<a href="index.jsp"><fmt:message key="home" /> </a>  &emsp;
			<a href="ProductPage"><fmt:message key="products" /> </a>
		</p>
	</fmt:bundle>
</body>
</html>