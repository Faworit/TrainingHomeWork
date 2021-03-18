<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--
  Created by IntelliJ IDEA.
  User: fawor
  Date: 15.03.2021
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <div style="display: flex">
        <form action="/login" method="POST">
            <div style="display: flex; margin-bottom: 5px; margin-top: 5px">
                <div style="width: 100px">
                    <spring:message code="label.username" var="username"></spring:message>
                    <label>${username}</label>
                </div>
                <div style="width: 100px">
                    <input type="text" name="username">
                </div>
            </div>
            <div style="display: flex; margin-bottom: 5px; margin-top: 5px">
                <div style="width: 100px">
                    <spring:message code="label.password" var="pass"></spring:message>
                    <label>${pass}</label>
                </div>
                <div style="width: 100px">
                    <input type="password" name="password">
                </div>
            </div>

            <spring:message code="label.button.signIn" var="SignIn"></spring:message>
            <input type="submit" value="${SignIn}">
        </form>
        <%--<form:form action="/j_spring_security_check" method="POST" modelAttribute="user">
            <div>
                <form:label path="username">user name</form:label>
                <form:input path="username" cssStyle="width: 200px; color: darkgray"></form:input>
                <form:errors path="username"></form:errors>
            </div>
            <div>
                <form:label path="password">password</form:label>
                <form:password path="password" cssStyle="width: 200px; color: darkgray"></form:password>
                <form:errors path="password"></form:errors>
            </div>

            <spring:message code="label.button.signIn" var="SignIn"></spring:message>
            <input type="submit" value="${SignIn}">
        </form:form>--%>

    </div>

</body>
</html>
