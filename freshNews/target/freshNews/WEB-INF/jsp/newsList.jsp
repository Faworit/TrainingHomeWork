<%--
  Created by IntelliJ IDEA.
  User: Faworit
  Date: 12.02.2021
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="deleteNews" method="post" modelAttribute="articleDTO">
<table>
    <c:forEach var="article" items="${listArticle}">

        <tr>
            <td><c:out value="${article.title}"/></td>
            <td><c:out value="${article.start}"/> </td>
        </tr>
        <tr>
            <td><c:out value="${article.brief}"/></td>
            <td></td>
        </tr>
        <tr>
            <td>
                <a href="/showArticle/${article.articleId}/show">view</a>
            </td>
            <td>
                <a href="/showArticle/${article.articleId}/edit">edit</a>
            </td>
            <td>
                <form:checkbox path="idDel" value="${article.articleId}"></form:checkbox>
                <%--<input type="checkbox" name="idDel" value="${article.articleId}">--%>
            </td>

        </tr>
        <div style="border-top:1px solid pink;"></div>
    </c:forEach>
</table>
    <input type="submit" value="delete">
</form:form>


</body>
</html>
