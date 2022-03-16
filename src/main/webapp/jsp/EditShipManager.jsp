<%@ page import="services.ShipService" %>
<%@ page import="models.Ship" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String num = request.getParameter("num");
        int capacity = Integer.parseInt(request.getParameter("capacity"));

        ShipService.setShip(new Ship(id, num, name, capacity));

        response.sendRedirect("/PortWebApp/AllShipsServlet");
    %>
</body>
</html>
