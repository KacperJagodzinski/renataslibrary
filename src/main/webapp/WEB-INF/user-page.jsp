<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 04.10.2020
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Renata's Library</title>
        <jsp:include page="bootstrap.jsp"/>
        <jsp:include page="header.jsp"/>
    </head>
</head>
<body>
<h1>User page</h1>
${user.id}
${user.username}
${user.books}
</body>
</html>
