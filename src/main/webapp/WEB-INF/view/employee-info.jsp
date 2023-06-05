<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dzeni
  Date: 05.06.2023
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h2>Employee Info</h2>
<br>

<form:form action="saveEmployee" modelAttribute="newEmp">
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Department <form:input path="department"/>
    <br><br>
    Name <form:input path="salary"/>

    <input type="submit" value="OK">

</form:form>

</body>
</html>
