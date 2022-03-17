<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>EditShip</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link rel="stylesheet" href="<c:url value='/resources/css/Ship.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/AllShips.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/EditShip.css' />"/>
</head>

<body>

<div class="materialContainer">
    <div class="box">
        <c:forEach items="${findShipById}" var="p">
            <form action="jsp/EditShipManager.jsp" method="post">
                <div class="title">Edit ship</div>

                <input name="id" type="hidden" value="${p.id}">

                <div class="input">
                    <input type="text" name="name" id="name" value="${p.name}">
                    <span class="spin"></span>
                </div>
                <label for="name">Name</label>

                <div class="input">
                    <input type="text" name="num" id="num" value="${p.regNumber}">
                    <span class="spin"></span>
                </div>
                <label for="num">Registration number</label>

                <div class="input">
                    <input type="number" name="capacity" id="capacity" min="4" max="50" onkeypress="return false"
                           value="${p.capacity}">
                </div>
                <label for="capacity">Capacity</label>
                <div class="button login">
                    <button type="submit"><span>GO</span> <i class="fa fa-check"></i></button>
                </div>
            </form>
        </c:forEach>
    </div>
</div>
</body>
</html>
