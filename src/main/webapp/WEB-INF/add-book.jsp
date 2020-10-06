<%--
  Created by IntelliJ IDEA.
  User: kacper
  Date: 26.09.2020
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Renata's Library</title>
    <jsp:include page="bootstrap.jsp"/>
    <jsp:include page="header.jsp"/>
    <script>
        function myFunction() {

            var checkBox = document.getElementById("ifNew");

            var text = document.getElementsByClassName("checked");


            for (let i = 0; i < text.length; i++) {
                if (checkBox.checked == true) {
                    if (text[i].style.display == "block") {
                        text[i].style.display = "none"
                    } else {
                        text[i].style.display = "block"
                    }
                    ;
                } else {
                    if (text[i].style.display == "none") {
                        text[i].style.display = "block"
                    } else {
                        text[i].style.display = "none"
                    }
                    ;
                }
            }

        }
    </script>
</head>
<body>
<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <form:form method="post" modelAttribute="book">
                    <h1 class="text-color-darker" style="color: white">Dodawanie książki</h1>
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <form:input path="title" class="form-control" placeholder="Tytuł"/>
                        <form:errors path="title"/>
                    </div>
                    <div class="form-group">
                        <form:select path="category" class="form-control">
                            <option default>Kategoria</option>
                            <form:options items="${category}"/>
                        </form:select>
                        <form:errors path="category"/>
                    </div>
                    <div class="form-group" title="pages">
                        <form:input path="pages" type="number" min="0" class="form-control" title="pages"/>
                        <form:errors path="pages"/>
                    </div>
                    <input type="checkbox" id="ifNew" onclick="myFunction()"> <label>Nowy autor</label>
                    <div class="form-group checked" style="display:block">
                        <form:select path="author" class="form-control">
                            <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
                        </form:select>
                        <form:errors path="author"/>
                    </div>
                    <%--                    <div class="form-group checked" style="display:none">--%>
                    <%--                        <form>--%>
                    <%--                            <input path="newAuthor" class="form-control" placeholder="Autor" value="newAuthor"/>--%>
                    <%--                            <p></p>--%>
                    <%--                            <input type="submit" value="Dodaj">--%>
                    <%--                        </form>--%>

                    <%--                    </div>--%>
                    <div class="form-group">
                        <form:select path="publisher" class="form-control">
                            <form:options items="${publishers}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <form:errors path="publisher"/>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">Dodaj</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

</body>
</html>
