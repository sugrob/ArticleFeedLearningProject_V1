<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <META http-equiv="Content-Language" content="ru">
    <title>Feed::edit</title>
</head>
<body>
    <h1>Feed::edit</h1>
    <form:form method="post" action="${pageContext.request.contextPath}/update">
        <form:hidden  path="id" />
        <label>Title:</label>
        <div><form:input path="title" /></div>

        <label>Content:</label>
        <div><form:textarea path="content" /></div>

        <input type="submit" value="Save" />
    </form:form>
</body>
</html>
