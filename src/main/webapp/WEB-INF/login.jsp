<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 25.09.2020
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Renata's Library</title>
    <jsp:include page="bootstrap.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<section class="dashboard-section">
    <form method="post">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                    <h1 class="text-color-darker" style="color: black">Logowanie</h1>
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="login"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="haslo"/>
                    </div>
                    <input type="submit" value="Zaloguj" class="btn btn-success"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </div>
    </div>
    </form>
</section>

</body>
</html>
