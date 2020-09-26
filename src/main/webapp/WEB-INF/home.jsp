<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 25.09.2020
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Renata's Library</title>
    <jsp:include page="bootstrap.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
    MAM ROLE USER
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <p>test</p>
    <p>Zalogowany jako: ${currentUser.username}</p>
<%--    <sec:authentication property="username"/>--%>
<%--    <p>Posiada role: <sec:authentication property="authorities"/></p>--%>
</sec:authorize>
</body>
</html>
