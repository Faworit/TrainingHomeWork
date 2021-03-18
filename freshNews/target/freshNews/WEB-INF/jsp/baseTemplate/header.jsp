<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div style="display: flex; flex-direction: row-reverse">
    <div style="flex-direction: row">
        <form action="/logout" method="post">
            <spring:message code="label.button.logout" var="logout"></spring:message>
            <input type="submit" value="${logout}">
        </form>

    </div>
    <div style="flex-direction: row-reverse">
        <form:form action="/registration" method="get">
            <spring:message code="label.button.register" var="SignUp"></spring:message>
            <input type="submit" value="${SignUp}">
        </form:form>
    </div>
    <div style="flex-direction: row-reverse; margin-left: 10px; margin-right: 10px">
        <form:form action="/login" method="get">
            <spring:message code="label.button.signIn" var="signIn"></spring:message>
            <input type="submit" value="${signIn}">
        </form:form>
    </div>

</div>



<hr/>