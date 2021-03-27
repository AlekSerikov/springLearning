<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Ask Details</title>
</head>
<body>

<br>
<br>

<form:form action="showDetails" modelAttribute="employee">

    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>
    Email <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    Department <form:select path="department">
    <form:option value="Information Techology" label="IT"/>
    <form:option value="Human resources" label="Hr"/>
    <form:option value="Sales" label="Sales"/>
    </form:select>
    <br><br>

    Which car do you wont?
    BMV <form:radiobutton path="carBrand" value="BMW"/>
    Audi <form:radiobutton path="carBrand" value="AUDI"/>
    Mercedes <form:radiobutton path="carBrand" value="Mercrdes"/>
    <br><br>
     Foreign languages
    EN<form:checkbox path="languages" value="English"/>
    DE<form:checkbox path="languages" value="Deutch"/>
    FR<form:checkbox path="languages" value="French"/>


    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>
