<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 27.09.2020
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Renata's Library</title>
    <jsp:include page="bootstrap.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1>Book List</h1>
<div class="mt-1">
    <a href="/book/add" class="btn btn-success">Dodaj Książke</a>
</div>
<div class="mt-1">
    <table class="table" style="background-color: white;opacity: 0.8">
        <thead>
        <tr>
            <th scope="col">Tytuł</th>
            <th scope="col">Autor</th>
            <th scope="col">Wydawca</th>
            <th scope="col">Kategoria</th>
            <th scope="col">Stron</th>
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

                <td>
                    <a class="btn btn-primary" href="/book/edit/${book.id}">Edit</a>
                    <a class="btn btn-danger" href="/book/delete/${book.id}">Delete</a>
                </td>
            </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
