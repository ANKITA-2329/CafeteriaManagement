<%-- 
    Document   : login
    Created on : May 1, 2022, 8:44:40 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Main Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="mainNav.jsp" />
        <form action = "./CustLoginController" method = "post"><br><br>
            <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>User Login</h1>
                <h6>Please enter your login id and password</h6>
            </div>
            <div class = "container form-outline mb-4">
                Email : <input type = "email" id = "cemail" class = "form-control" name = "email" placeholder="Enter your email id" required/>
            </div>
            <div class = "container form-outline mb-4">
                Password : <input type = "password" id = "cpassword" class = "form-control" name = "password" placeholder="Enter your password" required/>
            </div>
            <div class = "container text-center mb-2">
                <a href = "UserEmailId.jsp">Forget Password</a><br>
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" onclick = "IsEmpty()">Sign in</button>
            </div>
            <div class = "container text-center">
                <a href = "register.jsp"> Register New User</a>
            </div> 
            <div class = "container text-center mb-2">
                <a href = "adminEmpLogin.jsp"> Admin/Employee Login</a>
            </div> 
            </div>
        </form>
    </body>
</html>
