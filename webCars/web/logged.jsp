<%--
  Created by IntelliJ IDEA.
  User: Kacper
  Date: 2016-12-04
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        if(session.getAttribute("username")==null)
        {
        response.sendRedirect("index.jsp");
        }
    %>

    <h1>Witaj ${username} !</h1>
    <a href="/html/addOne.html">Dodaj samochód</a><br>
    <a href="viewTable">Obejrzyj dostępne auta</a><br>

    <form action="Logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
