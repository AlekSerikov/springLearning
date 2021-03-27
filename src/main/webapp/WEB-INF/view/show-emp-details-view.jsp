<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<h5>Employee name: ${employee.name}</h5>
<h5>Employee name: ${employee.surname}</h5>
<h5>Employee name: ${employee.salary}</h5>
<h5>Employee department: ${employee.department}</h5>
<h5>Employee department: ${employee.carBrand}</h5>
<br>
Languages
<ul>
    <c:forEach var="lang" items="${employee.languages}">
        <li>${lang}</li>
    </c:forEach>
</ul>
</body>
</html>
