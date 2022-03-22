<%@ page import="models.Voyage" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>All voyages</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link rel="stylesheet" href="<c:url value='/resources/css/General.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/Tables.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/Nav.css' />"/>
</head>

<body>
<div style="height: 100%; overflow:auto;">
    <div id="navbar">
        <ul>
            <li><a class="a" href="AllRoutesServlet">Routes</a></li>
            <li><a class="a" href="AllCapsServlet">Caps</a></li>
            <li><a class="a" href="AllShipsServlet">Ships</a></li>
            <li><a class="a" href="AllVoyagesServlet">Voyages</a></li>
            <li><a class="a" href="AllPricesServlet">Prices</a></li>
        </ul>
    </div>
    <div style="margin-bottom: 30px">
        <div class="button login">
            <button onclick="window.location.href = 'http://localhost:8080/PortWebApp/AddVoyageServlet';"
                    style="background-color: white"><span>Add new voyage</span> <i class="fa fa-check"></i></button>
        </div>
        <table style="width: 90%" class="table">
            <tr>
                <th width="5%">ID</th>
                <th width="20%">Captain</th>
                <th width="20%">Ship</th>
                <th width="40%">Route</th>
                <th width="20%">Date</th>
                <th width="5%"></th>
                <th width="5%"></th>
            </tr>
            <c:forEach items="${All}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>
                        Name: ${s.cap.name}<br>
                        Tel.: ${s.cap.phone}<br>
                    </td>
                    <td>
                        Name: ${s.ship.name}<br>
                        Num: ${s.ship.regNumber}<br>
                        Capacity: ${s.ship.capacity}<br>
                    </td>
                    <td>
                        Name: ${s.route.name}<br>
                        Route: ${s.route.from} - ${s.route.to}<br>
                    </td>
                    <td>${s.date}</td>
                    <td><a href="edit_voyage?id=${s.id}">Edit</a></td>
                    <td><a href="delete_voyage?id=${s.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
