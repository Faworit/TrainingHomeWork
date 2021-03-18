<%--
  Created by IntelliJ IDEA.
  User: fawor
  Date: 15.03.2021
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: flex">
    <form:form action="/signUp" method="post" modelAttribute="UserDTO">
    <div>
        <form:label path="userName">user name</form:label>
        <form:input path="userName" cssStyle="width: 200px; background: darkgray"></form:input>
        <form:errors path="userName"></form:errors>
    </div>
    <div>
        <form:label path="password">password</form:label>
        <form:password path="password" cssStyle="width: 200px; background: darkgray"></form:password>
        <form:errors path="password"></form:errors>
    </div>
    <div>
        <form:label path="email">email</form:label>
        <form:input path="email" cssStyle="width: 200px; background: darkgray"></form:input>
        <form:errors path="email"></form:errors>
    </div>
        <spring:message code="label.button.register" var="SignUp"></spring:message>
    <input type="submit" value="${SignUp}">
    </form:form>
</body>
</html>
