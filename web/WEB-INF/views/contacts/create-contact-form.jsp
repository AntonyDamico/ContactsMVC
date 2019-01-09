<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Contact List</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/styles.css">
</head>
<body>
<h2>Add Contact</h2>
<form:form action="${contextPath}/contacts/create" modelAttribute="contact">
    <form:label path="firstName">First Name</form:label>
    <form:input path="firstName"/>
    <br><br>
    <form:label path="lastName">Last Name</form:label>
    <form:input path="lastName"/>
    <br><br>
    <form:label path="email">Email</form:label>
    <form:input path="email"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>

<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>