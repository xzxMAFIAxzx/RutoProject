<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="icon" type="image/png" sizes="32x32" href="/images/icon24.png">
    <link rel="stylesheet" href="assets/css/login.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Login</title>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <div class="fadeIn first">
            <img src="/images/icon24.png" id="icon" alt="User Icon" />
        </div>
        <f:form action="login" method="GET" modelAttribute="message">
            <input type="text" id="phone" class="fadeIn second" name="phone" placeholder="Phone" required>
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="Password" required>
            <input type="submit" class="fadeIn fourth" value="Log In">
        </f:form>
        <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password?</a>
        </div>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
    </div>
</div>
</body>
</html>