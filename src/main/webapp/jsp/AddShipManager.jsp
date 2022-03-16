<%@ page import="services.ShipService" %>
<%@ page import="models.Ship" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new Voyage</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String num = request.getParameter("num");
    int capacity = Integer.parseInt(request.getParameter("capacity"));

    Ship s = new Ship(0L, num, name, capacity);
    ShipService.add(s);

    response.sendRedirect("/PortWebApp/AllShipsServlet");
%>
</body>
</html>