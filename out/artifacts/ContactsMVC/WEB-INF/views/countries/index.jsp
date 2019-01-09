<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Country List</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/styles.css">
</head>
<body>

    <h1>Country List</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Code</th>
            <td>Actions</td>
        </tr>
        <c:forEach var="country" items="${countries}">
            <tr>
                <td>${country.name}</td>
                <td>${country.code}</td>
                <td>
                    <a href="${contextPath}/countries/update/${country.id}">Update</a>
                    <a href="${contextPath}/countries/delete/${country.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>