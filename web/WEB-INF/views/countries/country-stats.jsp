<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Country Stats</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/styles.css">
</head>
<body>

<h1>Country Stats</h1>
<table>
    <tr>
        <th>Country</th>
        <th>%</th>
    </tr>
    <c:forEach var="country" items="${stats}">
        <tr>
            <td>${country.key}</td>
            <td>${country.value}</td>
        </tr>
    </c:forEach>
</table>

<a href="${contextPath}/countries/list">Go back</a>
<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>