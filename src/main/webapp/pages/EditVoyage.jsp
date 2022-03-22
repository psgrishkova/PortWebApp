<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>EditVoyage</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link rel="stylesheet" href="<c:url value='/resources/css/Select.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/General.css' />"/>
</head>

<body>
<c:if test="${err!=null}">
    <script>
        prompt("Check your data", "${err}");
    </script>
</c:if>
<div class="materialContainer">
    <div class="box">

        <c:forEach items="${findVoyageById}" var="v">
            <form action="edit_voyage?id=${v.id}" method="post">
                <div>
                    <input type="text" hidden value="${v.id}" id="id" name="id" required>
                    <label for="cap">Captain</label>
                    <select name="cap" id="cap">
                        <c:forEach items="${getAllCaps}" var="c">
                            <c:if test="${c.id==v.capId}">
                                <option value="${c.id}" selected>${c.name}</option>
                            </c:if>
                            <c:if test="${not (c.id==v.capId)}">
                                <option value="${c.id}">${c.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <label for="ship">Ship</label>
                    <select name="ship" id="ship">
                        <c:forEach items="${getAllShips}" var="s">
                            <c:if test="${s.id==v.shipId}">
                                <option value="${s.id}" selected>${s.name}</option>
                            </c:if>
                            <c:if test="${not (s.id==v.shipId)}">
                                <option value="${s.id}">${s.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <label for="route">Route</label>
                    <select class="s" name="route" id="route">
                        <c:forEach items="${getAllRoutes}" var="r">
                            <c:if test="${r.id==v.routeId}">
                                <option value="${r.id}" selected>${r.name}</option>
                            </c:if>
                            <c:if test="${not (r.id==v.routeId)}">
                                <option value="${r.id}">${r.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    <span class="spin"></span>
                </div>

                <div class="input">
                    <input type="datetime-local" name="date" id="date" value="${v.date}" required>
                </div>

                <div class="button login">
                    <button style="width: 50%" type="submit">GO</button>
                    <button style="width: 50%"
                            onclick="window.location.href = 'http://localhost:8080/PortWebApp/AllVoyagesServlet';">
                        Cancel
                    </button>
                </div>
            </form>
        </c:forEach>


    </div>
</div>
</body>
</html>
