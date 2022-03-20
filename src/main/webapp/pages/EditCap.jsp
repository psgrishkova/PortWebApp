<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>EditCap</title>
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
        <c:forEach items="${findCapById}" var="p">
            <form action="edit_cap?id=${p.id}" method="post">
                <div class="title">Edit cap</div>

                <input name="id" type="hidden" value="${p.id}" required>

                <div class="input">
                    <input type="text" name="name" id="name" value="${p.name}" required>
                    <span class="spin"></span>
                </div>
                <label for="name">Name</label>

                <div class="input">
                    <input type="tel" name="tel" id="tel"
                           value="${p.phone}" required
                           value="+7(___)___-__-__"
                           pattern="\+7\s?[\(]{0,1}9[0-9]{2}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}"
                           placeholder="+7(___)___-__-__"
                    >
                </div>
                <label for="tel">Phone</label>
                <div class="button login">
                    <button style="width: 50%" type="submit">GO</button>
                    <button style="width: 50%" onclick="window.location.href = 'http://localhost:8080/PortWebApp/AllCapsServlet';">Cancel</button>
                </div>
            </form>
        </c:forEach>
    </div>
</div>
</body>
<script type="text/javascript">
    <%@include file="../js/PhoneNumPattern.js"%>
</script>
</html>
