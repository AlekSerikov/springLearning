<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksey
  Date: 28.03.2021
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add employee</title>
</head>
<body>

<h2>Employee info</h2>

<form:form action="saveEmployee" modelAttribute="employee">
    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br>
    Surname <form:input path="surname"/>
    <br>
    Department <form:input path="department"/>
    <br>
    Salary <form:input path="salary"/>
    <br>
    <input type="submit" value="OK">
</form:form>


</body>
</html>
