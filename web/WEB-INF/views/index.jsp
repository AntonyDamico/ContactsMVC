<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contact List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<h1>Contact list</h1>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="contact" items="${contactList}">
        <tr>
            <td>${contact.firstName}</td>
            <td>${contact.lastName}</td>
            <td>${contact.email}</td>
            <td>${contact.countryCode}</td>
            <td><a href="">Update</a><a href="">Delete</a></td>
        </tr>
    </c:forEach>

    <a href="add">Create Contact</a>
</table>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</body>
</html>
