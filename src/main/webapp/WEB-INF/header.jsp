<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<nav class="navbar navbar-expand-lg navbar navbar-dark">
    <a class="navbar-brand" href="/">Renata's Library</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/book/list">My Books<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/book/add">Add book</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/walk/alllist">Third</a>
            </li>
        </ul>
        <sec:authorize access="!isAuthenticated()">

            <a class="btn btn-primary" href="/login">Login</a>

            <a class="btn btn-success" href="/register">Register</a>
            </sec:authorize>
        <sec:authorize access="isAuthenticated()">
                <span style="color: white">Witaj,</span>
                <div class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: white">
                        ${currentUser.username}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/user/edit">Edit</a>
                        <div class="dropdown-divider"></div>
                        <form action="<c:url value="/logout"/>" method="post">
                            <input class="dropdown-item" type="submit" value="Wyloguj">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </div>
                </div>
        </sec:authorize>

    </div>
</nav>
</html>