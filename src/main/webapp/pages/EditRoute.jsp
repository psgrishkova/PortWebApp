<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>EditRoute</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link rel="stylesheet" href="<c:url value='/resources/css/General.css' />"/>
    <link rel="stylesheet" href="<c:url value='/resources/css/Label.css' />"/>
</head>

<body>
<c:if test="${err!=null}">
    <script>
        prompt("Check your data", "${err}");
    </script>
</c:if>
<div class="materialContainer">
    <div class="box">
        <c:forEach items="${findRouteById}" var="p">
            <form action="edit_route?id=${p.id}" method="post">
                <div class="title">Edit route</div>

                <input name="id" type="hidden" value="${p.id}" required>

                <div class="input">
                    <input type="text" name="name" id="name" value="${p.name}" required>
                    <span class="spin"></span>
                </div>
                <label for="name">Name</label>

                <div class="input">
                    <input type="text" name="from" id="from" value="${p.from}" required>
                    <span class="spin"></span>
                </div>
                <label for="from">From</label>

                <div class="input">
                    <input type="text" name="to" id="to"
                           value="${p.to}" required>
                </div>
                <label for="to">To</label>
                <div class="button login">
                    <button style="width: 50%" type="submit">GO</button>
                    <button style="width: 50%"
                            onclick="window.location.href = 'http://localhost:8080/PortWebApp/AllRoutesServlet';">Cancel
                    </button>
                </div>
            </form>
        </c:forEach>
    </div>
</div>
</body>
</html>
