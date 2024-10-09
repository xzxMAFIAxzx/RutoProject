<%@ page import="entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.impl.UserDaoImpl" %>
<%@ page import="main.Context" %>
<%@ page import="dao.inter.UserDaoInter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <title>Ruto.az</title>
</head>
<body>

<%
    User user = (User) session.getAttribute("loggedInUser");
%>
<%="Welcome  " + user.getName()%>
<style class="img_background">
    body {
        background-image: url('/images/sty.jpg');
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <form action="login" method="GET">
                <input type="hidden" name="action" value="login"/>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Log In <span class="sr-only">(login)</span></a>
                </li>
            </form>
            <form action="userdetail" method="GET">
                <input type="hidden" name="action" value="profile"/>
                <input type="hidden" name="id" value="<%=user.getId()%>"/>
                <li class="nav-item">
                    <button class="btnMain" type="submit" class="nav-link" value="profile">
                        Profile
                    </button>
                </li>
            </form>
            <form action="logout" method="POST">
                <input type="hidden" name="action" value="logout"/>
                <li>
                    <button name="logout" type="submit" class="btnMain">Log Out</button>
                </li>
            </form>
            <form action="users" method="GET">
                <input type="hidden" name="action" value="adminpanel"/>
                <li>
                    <button type="submit" class="btnMain" value="adminpanel">Admin Panel</button>
                </li>
            </form>
        </ul>
    </div>
</nav>
</body>
</html>
