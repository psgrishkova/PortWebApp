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
    <link rel="stylesheet" href="<c:url value='/resources/css/Price.css' />"/>
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
        <form action="/PortWebApp/AddPriceServlet" method="post">
            <div class="title">Add price</div>
            <div >
                <select class="s" name="route" id="route">
                    <c:forEach items="${getAllRoutes}" var="r">
                        <option value="${r.id}">${r.name}</option>
                    </c:forEach>
                </select>
            </div>
            <label for="route" style="padding-bottom: 10px">Route</label>
            <div>
                <select name="category" id="category">
                    <option value="pensioner">pensioner</option>
                    <option value="children">children</option>
                    <option value="invalid">invalid</option>
                    <option value="bicycle">bicycle</option>
                    <option value="adult">adult</option>
                </select>
            </div>
            <label for="category" style="padding-bottom: 10px">Category</label>

            <div class="input">
                <input type="text" name="price" id="price" pattern="\d+(\.\d{*})?" placeholder="1.23" step="any"
                       required>
            </div>
            <label for="price" style="padding-bottom: 10px">Price</label>



            <div class="button login">
                <button style="width: 50%" type="submit">GO</button>
                <button style="width: 50%" onclick="window.location.href = 'http://localhost:8080/PortWebApp/AllPricesServlet';">Cancel</button>
            </div>
        </form>

    </div>
</div>
</body>
</html>
