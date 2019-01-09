<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Edit Contact</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/styles.css">
</head>
<body>

<h2>Edit Country: ${country.name}</h2>
<br><br>
<form:form action="${contextPath}/countries/update" modelAttribute="country">
    <form:hidden path="id"/>
    <form:label path="name">Name</form:label>
    <form:input path="name"/>
    <br><br>
    <form:label path="code">Code</form:label>
    <form:input path="code"/>
    <br><br>
    <input type="submit" value="Submit">
</form:form>

<script src="${contextPath}/resources/js/app.js"></script>
</body>
</html>