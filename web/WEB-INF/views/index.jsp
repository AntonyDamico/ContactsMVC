<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Contact List</title>
  </head>
  <body>
    <h1>Contact list</h1>
    <table>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Country</th>
      </tr>
      <c:forEach var="contact" items="${contactList}">
        <tr>
          <td>${contact.firstName}</td>
          <td>${contact.lastName}</td>
          <td>${contact.email}</td>
        </tr>
      </c:forEach>
    </table>

  </body>
</html>
