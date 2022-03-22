<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>All routes</title>
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
            <button onclick="window.location.href = 'http://localhost:8080/PortWebApp/AddRouteServlet';"
                    style="background-color: white"><span>Add new route</span> <i class="fa fa-check"></i></button>
        </div>
        <table style="width: 90%;" class="table">
            <tr>
                <th width="5%">ID</th>
                <th width="40%">Name</th>
                <th width="25%">From</th>
                <th width="25%">To</th>
                <th width="5%"></th>
                <th width="5%"></th>
            </tr>
            <c:forEach items="${All}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.from}</td>
                    <td>${s.to}</td>
                    <td><a href="edit_route?id=${s.id}">Edit</a></td>
                    <td><a href="delete_route?id=${s.id}">Delete</a></td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
