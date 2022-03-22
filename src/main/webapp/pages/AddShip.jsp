<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PortWebApp</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'
          href="<c:url value='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'/>">
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
        <form action="AddShipServlet" method="post">
            <div class="title">Add new ship</div>

            <div class="input">
                <input type="text" name="name" id="name" required>
                <span class="spin"></span>
            </div>
            <label for="name">Name</label>

            <div class="input">
                <input type="text" name="num" id="num" required
                       placeholder="AA000A00" pattern="[A-Z]{2}[0-9]{3}[A-Z]{1}[0-9]{2,3}"
                >
                <span class="spin"></span>
            </div>
            <label for="num">Registration number</label>

            <div class="input">
                <input type="number" name="capacity" id="capacity" min="4" max="50" required>
                <span class="spin"></span>
            </div>
            <label for="capacity">Capacity</label>

            <div class="button login">
                <button style="width: 50%" type="submit">GO</button>
                <button style="width: 50%"
                        onclick="window.location.href = 'http://localhost:8080/PortWebApp/AllShipsServlet';">Cancel
                </button>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    <%@include file="../js/Effects.js"%>
</script>
<script src='<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"/> '></script>

</body>
</html>
