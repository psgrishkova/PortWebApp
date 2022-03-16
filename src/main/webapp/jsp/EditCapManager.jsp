<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%@ page import="services.CapService" %>
        <%@ page import="models.Cap" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>
        <title>Title</title>
</head>
<body>
<%
    Long id = Long.parseLong(request.getParameter("id"));
    String name = request.getParameter("name");
    String tel = request.getParameter("tel");

    CapService.setCap(new Cap(id, name, tel));

    response.sendRedirect("/PortWebApp/AllCapsServlet");
%>
</body>
</html>
</title>
</head>
<body>

</body>
</html>
