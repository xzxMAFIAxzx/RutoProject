<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
           <form action="login" method="POST">
               <input type="text" id="phone" class="fadeIn second" name="phone" placeholder="Phone">
               <input type="text" id="password" class="fadeIn third" name="password" placeholder="Password">
               <input type="submit" class="fadeIn fourth" value="Log In">
           </form>
           <div id="formFooter">
               <a class="underlineHover" href="#">Forgot Password?</a>
           </div>

       </div>
   </div>
</body>
</html>
