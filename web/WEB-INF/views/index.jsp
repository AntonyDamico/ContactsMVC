<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Main Menu</title>
</head>
<body>
    <h1>Main Menu</h1>
    <a href="${contextPath}/contacts/list">Contacts</a>
    <a href="${contextPath}/countries/list">Countries</a>
</body>
</html>
