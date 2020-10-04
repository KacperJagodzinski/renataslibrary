<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 04.10.2020
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Renata's Library</title>
    <jsp:include page="bootstrap.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div class="mt-1">
<table class="table" style="background-color: white;opacity: 0.8">
    <thead>
    <tr>
        <th scope="col">Tytuł</th>
        <th scope="col">Autor</th>
        <th scope="col">Wydawca</th>
        <th scope="col">Kategoria</th>
        <th scope="col">Stron</th>
        <th scope="col">Właściciel</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <c:if test="${book.ifActive==true}">
            <tr>
                <td>${book.title}</td>
                <td>${book.author.fullName}</td>
                <td>${book.publisher.name}</td>
                <td>${book.category}</td>
                <td>${book.pages}</td>
                <td>${book.user.username}</td>

                <td>
<%--                    <a class="btn btn-primary" href="/user/${book.user.id}">User</a>--%>
                    <a class="btn btn-success" href="/book/lend/${book.id}">Wypożycz</a>
                </td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
