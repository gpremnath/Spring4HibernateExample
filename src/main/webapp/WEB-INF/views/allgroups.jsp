<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>University Enrollments</title>

  <style>
    tr:first-child{
      font-weight: bold;
      background-color: #C6C9C4;
    }
  </style>

</head>


<body>
<h2>List of Groups</h2>
<table>
  <tr>
    <td>NAME</td><td></td>
  </tr>
  <c:forEach items="${groups}" var="group">
    <tr>
      <td>${group.name}</td>
      <td><a href="<c:url value='edit-${group.id}-group' />">${group.id}</a></td>
     </tr>
  </c:forEach>
</table>
<br/>
<a href="<c:url value='new' />">Add New Group</a>
</body>
</html>