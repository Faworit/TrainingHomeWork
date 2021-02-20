<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="articleDTO" action="addArticle.html" >
    <p>
        <form:label path="title">News Title</form:label>
        <form:input path="title" maxlength="100"></form:input>
        <form:errors path="title"/>
    </p>
    <p>
        <form:label path="start">News Date</form:label>
        <form:input path="start"></form:input>
        <%--<input type="text" placeholder="${currentDate}"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="Enter a date in this format YYYY-MM-DD" name="start">--%>
    </p>
    <p>
        <form:label path="brief">Brief</form:label>
        <form:textarea path="brief" maxlength="500"></form:textarea>
        <%--<textarea maxlength="500" name="brief" required></textarea>--%>
    </p>

    <p>
        <form:label path="content">Content</form:label>
        <form:textarea path="content" maxlength="2048"></form:textarea>
        <%--<textarea maxlength="2048" name="content" required></textarea>--%>
    </p>
    <p>
        <input type="submit" value="Add News"/>        
    </p>
</form:form>

</body>
</html>
