<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 26.09.2020
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Renata's Library</title>
    <jsp:include page="bootstrap.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form:form method="post" modelAttribute="user">
                    <h1 class="text-color-darker" style="color: white">Register</h1>
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <form:input path="username" class="form-control" placeholder="podaj imię"/>
                        <form:errors path="username"/>
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <form:input path="lastName" class="form-control" placeholder="podaj nazwisko"/>--%>
<%--                        <form:errors path="lastName"/>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <form:input path="email" class="form-control" placeholder="podaj email"/>--%>
<%--                        <form:errors path="email"/>--%>
<%--                    </div>--%>
                    <div class="form-group">
                        <form:password path="password" class="form-control" placeholder="podaj haslo" />
                        <form:errors path="password"/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="password2" placeholder="powtórz hasło">
                    </div>
                    <button class="btn btn-success" type="submit">Zarejestruj</button>
                </form:form>
            </div>
        </div>
    </div>
</section>

</body>
</html>
