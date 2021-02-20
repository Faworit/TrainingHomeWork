<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Faworit
  Date: 15.02.2021
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<form:form method="post" action="update.html">
    <input type="text" value="${article.articleId}" name="articleId" hidden>
    <p>
        <form:label path="title">News Title</form:label>
        <input type="text" name="title" value="${article.title}"  maxlength="100">
    </p>
    <p>
        <form:label path="start">News Date</form:label>
        <input type="text" value="${article.start}" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="Enter a date in this format YYYY-MM-DD" name="start">
    </p>
    <p>
        <form:label path="brief">Brief</form:label>
        <textarea maxlength="500" name="brief" placeholder="article.brief" required>${article.brief}</textarea>
    </p>

    <p>
        <form:label path="content">Content</form:label>
        <textarea maxlength="2048" name="content" required>${article.content}</textarea>
    </p>
    <p>
        <input type="submit" value="Add News"/>
    </p>
</form:form>

</body>
</html>
