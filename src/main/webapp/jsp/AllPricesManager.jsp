<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>All prices</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link rel="stylesheet" href="<c:url value='/resources/css/Ship.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/AllShips.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/Nav.css' />"/>
</head>

<body>
<div style="height: 100%; overflow:auto;">
    <div id="navbar">
        <ul>
            <li><a class="a" href="AllRoutesServlet">Routes</a></li>
            <li><a class="a" href="AllCapsServlet">Caps</a></li>
            <li><a class="a" href="AllShipsServlet" >Ships</a></li>
            <li><a class="a" href="AllVoyagesServlet" >Voyages</a></li>
            <li><a class="a" href="AllPricesServlet" >Prices</a></li>
        </ul>
    </div>
<div >
    <div class="button login">
        <button onclick="window.location.href = 'http://localhost:8080/PortWebApp/AddPriceServlet';"
                style="background-color: white">Add new price list</button>
    </div>
    <c:forEach items="${All}" var="s">
        <div style="margin-bottom: 30px;">
            <table class="table">
                <caption style="font-size: 25px; color: white">Route : ${s.name}<br>
                    <a style="color: white" href="delete_price?id=${s.id}">Delete price list</a><br>
                </caption>

                <tr>
                    <th width="20%">Category</th>
                    <th width="20%">Price</th>
                </tr>
                    <c:forEach items="${s.priceList}" var="p">
                    <tr>
                        <td>${p.category}</td>
                        <td>${p.price}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </c:forEach>
</div>
</div>
</body>
</html>
