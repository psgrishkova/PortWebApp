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
<c:if test="${err!=null}">
    <script>
        prompt("Check your data", "${err}");
    </script>
</c:if>
<div class="materialContainer">
    <div class="box">
        <c:forEach items="${findShipById}" var="p">
            <form action="edit_ship?id=${p.id}" method="post">
                <div class="title">Edit ship</div>

                <input name="id" type="hidden" value="${p.id}" required>

                <div class="input">
                    <input type="text" name="name" id="name" value="${p.name}" required>
                    <span class="spin"></span>
                </div>
                <label for="name">Name</label>

                <div class="input">
                    <input type="text" name="num" id="num" value="${p.regNumber}" required
                           placeholder="AA000A00" pattern="[A-Z]{2}[0-9]{3}[A-Z]{1}[0-9]{2,3}"
                    >
                    <span class="spin"></span>
                </div>
                <label for="num">Registration number</label>

                <div class="input">
                    <input type="number" name="capacity" id="capacity" min="4" max="50" onkeypress="return false"
                           value="${p.capacity}" required>
                </div>
                <label for="capacity">Capacity</label>
                <div class="button login">
                    <button style="width: 50%" type="submit">GO</button>
                    <button style="width: 50%" onclick="window.location.href = 'http://localhost:8080/PortWebApp/AllShipsServlet';">Cancel</button>
                </div>
            </form>
        </c:forEach>
    </div>
</div>
</body>
</html>
