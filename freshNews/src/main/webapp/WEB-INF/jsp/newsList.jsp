<%--
  Created by IntelliJ IDEA.
  User: Faworit
  Date: 12.02.2021
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Title</title>
    <link href="/css/body.css" rel="stylesheet" type="text/css">
</head>
<body>
<a id="en" href="/?lang=en">English</a>
<a id="fr" href="/?lang=ru">Russian</a>

<form:form action="deleteNews" method="post" modelAttribute="articleDTO">

    <c:forEach var="article" items="${listArticle}">
        <table style="width: 100%">
            <tr>
                <td style="width: 70%"><c:out value="${article.title}"/></td>
                <td colspan="3", rowspan="2" style="width: 30%"><c:out value="${article.start}"/></td>
            </tr>
            <tr>
                <td rowspan="2" style="width: 70%"><c:out value="${article.brief}"/></td>
            </tr>
            <tr>
                <td style="width: 10%"><a href="/showArticle/${article.articleId}/show">view</a></td>
                <td style="width: 10%"><a href="/showArticle/${article.articleId}/edit">edit</a></td>
                <td style="width: 10%">
                    <form:checkbox path="idDel" value="${article.articleId}"></form:checkbox>
                </td>
            </tr>
        </table>

        <div style="border-top:1px solid pink;"/>
    </c:forEach>
    <br>
    <spring:message code="label.button.delete" var="labelSubmit"></spring:message>
    <input type="submit" value="${labelSubmit}" />
    <%--<input type="submit" value="delete">--%>
</form:form>


</body>
</html>
