<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>AddPrice</title>
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
        <form action="jsp/AddPriceManager.jsp" method="post">
            <div class="title">Add price</div>
            <div>
                <label for="id">ID</label>
                <input type="number" name="id" id="id" value="${id}">
            </div>

            <div>
                <label for="category">Category</label>
                <select name="category" id="category">
                    <option value="pensioner">pensioner</option>
                    <option value="children">children</option>
                    <option value="invalid">invalid</option>
                    <option value="bicycle">bicycle</option>
                    <option value="adult">adult</option>
                </select>
            </div>

            <div>
                <label for="price">Price</label>
                <input type="text" name="price" id="price">
            </div>

            <div>
                <label for="route">Route</label>
                <select class="s" name="route" id="route">
                    <c:forEach items="${getAllRoutes}" var="r">
                        <option value="${r.id}">${r.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="button login">
                <button type="submit"><span>GO</span> <i class="fa fa-check"></i></button>
            </div>
        </form>

    </div>
</div>
</body>
</html>
