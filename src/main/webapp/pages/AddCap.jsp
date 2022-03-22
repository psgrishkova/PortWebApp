<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Add captain</title>
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch'
          href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&subset=latin,latin-ext'>
    <link rel="stylesheet" href="<c:url value='/resources/css/General.css' />"/>
</head>
<body>
<c:if test="${err!=null}">
    <script>
        prompt("Check your data", "${err}");
    </script>
</c:if>
<div class="materialContainer">
    <div class="box">
        <form action="/PortWebApp/AddCapServlet" method="post">
            <div class="title">Add new cap</div>

            <div class="input">
                <label for="name">Name</label>
                <input type="text" name="name" id="name" pattern="[^0-9]+$" required>
            </div>

            <div class="input">
                <label for="tel">phone</label>
                <input type="tel" name="tel" id="tel"
                       value="+7(___)___-__-__"
                       pattern="\+7\s?[\(]{0,1}[0-9]{3}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}"
                       placeholder="+7(___)___-__-__"
                >
            </div>

            <div class="button login">
                <button style="width: 50%" type="submit">GO</button>
                <button style="width: 50%" onclick="window.location.href = 'http://localhost:8080/PortWebApp/AllCapsServlet';">Cancel</button>
            </div>
        </form>
    </div>
</div>
<script src='<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"/> '></script>
<script type="text/javascript">
    <%@include file="../js/Effects.js"%>
</script>
<script type="text/javascript">
    <%@include file="../js/PhoneNumPattern.js"%>
</script>

</body>
</html>
