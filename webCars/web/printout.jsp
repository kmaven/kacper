<%--
  Created by IntelliJ IDEA.
  User: Kacper
  Date: 2016-12-01
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodano nowy samochód do bazy !!!</h1><br><br>
<h2>Dane dodanego samochodu:</h2><br>
Marka: <%= session.getAttribute("marka") %><br>
Model: <%= session.getAttribute("model") %><br>
Rocznik: <%= session.getAttribute("rocznik") %><br>
Pojemnosc: <%= session.getAttribute("pojemnosc") %><br>
</body>
</html>
