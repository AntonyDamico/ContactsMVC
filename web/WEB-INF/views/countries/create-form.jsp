<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Create Country</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/styles.css">
</head>
<body>
<h2>Add Country</h2>
<form:form action="${contextPath}/countries/create" modelAttribute="country">
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