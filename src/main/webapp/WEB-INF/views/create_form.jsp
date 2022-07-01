<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <META http-equiv="Content-Language" content="ru">
    <title>Feed::(add new article)</title>
</head>
<body>
    <h1>Feed::(add new article)</h1>
    <form:form method="post" action="${pageContext.request.contextPath}/save">
        <label>Title:</label>
        <div><form:input path="title" /></div>

        <label>Content:</label>
        <div><form:textarea path="content" /></div>

        <input type="submit" value="Add new one" />
    </form:form>
</body>
</html>
