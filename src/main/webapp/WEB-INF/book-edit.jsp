<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 29.09.2020
  Time: 14:25
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
                <form:form method="post" modelAttribute="book">
                    <h1 class="text-color-darker" style="color: white">Edytowanie książki</h1>
                    <form:hidden path="id"/>
                    <form:hidden path="user"/>
                    <form:hidden path="ifActive"/>
                    <form:hidden path="ifLent"/>
                    <div class="form-group">
                        <form:input path="title" class="form-control"/>
                        <form:errors path="title"/>
                    </div>
                    <div class="form-group">
                        <form:select path="category" class="form-control">
                            <form:options items="${category}"/>
                        </form:select>
                        <form:errors path="category"/>
                    </div>
                    <div class="form-group" title="pages">
                        <form:input path="pages" type="number" min="0" class="form-control" title="pages"/>
                        <form:errors path="pages"/>
                    </div>
                    <div class="form-group checked" style="display:block">
                        <form:select path="author" class="form-control">
                            <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
                        </form:select>
                        <form:errors path="author"/>
                    </div>
                    <div class="form-group">
                        <form:select path="publisher" class="form-control">
                            <form:options items="${publishers}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <form:errors path="publisher"/>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">Edytuj</button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</section>

</body>
</html>
