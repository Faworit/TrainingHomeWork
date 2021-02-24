<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>
        <form:label path="title">News Title</form:label>
        ${article.title}
    </p>
    <p>
        <form:label path="start">News Date</form:label>
        ${article.start}
    </p>
    <p>
        <form:label path="brief">Brief</form:label>
        ${article.brief}
    </p>

    <p>
        <form:label path="content">Content</form:label>
        ${article.content}
    </p>
</body>
</html>
