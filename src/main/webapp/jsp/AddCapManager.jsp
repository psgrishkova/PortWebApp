<%@ page import="models.Cap" %>
<%@ page import="services.CapService" %><%--
  Created by IntelliJ IDEA.
  User: Полина
  Date: 16.03.2022
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new cap</title>
</head>
<body>
<%
      String name = request.getParameter("name");
      String tel = request.getParameter("tel");

      Cap s = new Cap(0L, name, tel);
      CapService.add(s);

    response.sendRedirect("/PortWebApp/AllCapsServlet");
%>
</body>
</html>
