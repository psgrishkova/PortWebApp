<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>AddVoyage</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link rel="stylesheet" href="<c:url value='/resources/css/Voyage.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/Ship.css' />"/>
    <link rel="stylesheet" href="<c:url value='../resources/css/AllShips.css' />"/>
</head>

<body>
<div class="materialContainer">
    <div class="box">
        <form action="jsp/EditVoyageManager.jsp" method="post">
            <c:forEach items="${findVoyageById}" var="v">
                <div>
                    <label for="cap">Captain</label>
                    <select name="cap" id="cap">
                        <c:forEach items="${getAllCaps}" var="c">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                    <span class="spin"></span>
                </div>
                <div>
                    <label for="ship">Ship</label>
                    <select name="ship" id="ship">
                        <c:forEach items="${getAllShips}" var="s">
                            <option value="${s.id}">${s.name}</option>
                        </c:forEach>
                    </select>
                    <span class="spin"></span>
                </div>

                <div>
                    <label for="route">Route</label>
                    <select class="s" name="route" id="route">
                        <c:forEach items="${getAllRoutes}" var="r">
                            <option value="${r.id}">${r.name}</option>
                        </c:forEach>
                    </select>
                    <span class="spin"></span>
                </div>

                <div class="input">
                    <input type="datetime-local" name="date" id="date">
                </div>

                <div class="button login">
                    <button type="submit"><span>GO</span> <i class="fa fa-check"></i></button>
                </div>
            </c:forEach>
        </form>

    </div>
</div>
</body>
</html>
