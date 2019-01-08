<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Edit Contact</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/styles.css">
</head>
<body>

<h2>Edit contact ${contact.firstName} ${contact.lastName}</h2>
<br><br>
<form:form action="${contextPath}/update" modelAttribute="contact">
    <form:hidden path="id"/>
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