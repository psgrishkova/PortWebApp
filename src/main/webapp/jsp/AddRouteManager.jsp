<%@ page import="models.Route" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="services.RouteService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String from = request.getParameter("from");
    String to = request.getParameter("to");
    String date = request.getParameter("date");

    Route s = new Route(0L, name, from, to);
    RouteService.add(s);

    response.sendRedirect("/PortWebApp/AllRoutesServlet");
%>
</body>
</html>
