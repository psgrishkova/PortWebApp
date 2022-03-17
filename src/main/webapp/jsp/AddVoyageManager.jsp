<%@ page import="java.time.LocalDateTime" %>
<%@ page import="models.Voyage" %>
<%@ page import="services.VoyageService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Long capId = Long.parseLong(request.getParameter("cap"));
    Long shipId = Long.parseLong(request.getParameter("ship"));
    Long routeId = Long.parseLong(request.getParameter("route"));
    Long accId=1L;
    LocalDateTime date = LocalDateTime.parse(request.getParameter("date"));

    Voyage s = new Voyage(0L, capId, routeId, shipId, date);
    VoyageService.add(s);

    response.sendRedirect("/PortWebApp/AllVoyagesServlet");
%>
</body>
</html>
