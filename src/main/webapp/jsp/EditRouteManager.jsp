<%@ page import="services.RouteService" %>
<%@ page import="models.Route" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Long id = Long.parseLong(request.getParameter("id"));
    String name = request.getParameter("name");
    String from = request.getParameter("from");
    String to = request.getParameter("to");

    RouteService.setRoute(new Route(id, name, from, to));

    response.sendRedirect("/PortWebApp/AllRoutesServlet");
%>
</body>
</html>
