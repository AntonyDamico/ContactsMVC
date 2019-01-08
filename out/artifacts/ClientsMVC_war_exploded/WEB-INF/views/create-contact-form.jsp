<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Contact List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>

    <form:form action="create" modelAttribute="contact">
        <form:label path="firstName">First Name</form:label>
        <form:input path="firstName"/>
        <br>
        <form:label path="lastName">Last Name</form:label>
        <form:input path="lastName"/>
        <br>
        <form:label path="email">Email</form:label>
        <form:input path="email"/>
        <br>
        <input type="submit" value="Submit">
    </form:form>

<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</body>
</html>