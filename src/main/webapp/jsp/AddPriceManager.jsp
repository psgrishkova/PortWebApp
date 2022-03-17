<%@ page import="java.util.logging.LogManager" %>
<%@ page import="models.Price" %>
<%@ page import="services.PriceService" %><%--
  Created by IntelliJ IDEA.
  User: Полина
  Date: 17.03.2022
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Long id = Long.parseLong(request.getParameter("id"));
    String category=request.getParameter("category");
    Double price = Double.parseDouble(request.getParameter("price"));
    Long routeId = Long.parseLong(request.getParameter("route"));

    Price s = new Price(id,category,price,routeId);
    PriceService.add(s);

    response.sendRedirect("/PortWebApp/AllPricesServlet");
%>
</body>
</html>
