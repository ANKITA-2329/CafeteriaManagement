<%-- 
    Document   : CustomerDetails
    Created on : 2022 May 27, 22:32:06
    Author     : Dell
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Details</title>
    </head>
    <body>
        <jsp:include page="empPage.jsp" />
        
        <form method = "POST" action = "/Rosa/GetCustomerDetailsServlet" onsubmit ="return verifyPassword()"><br><br>
            <input type = "hidden" name ="order_id" value = "${order_id}">
            <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Customer Details</h1>
            </div>
            <div class = "container form-outline mb-4">
                Email : <input type = "email" id = "email" class = "form-control" name = "email" placeholder="Enter your email id" required/>
            </div>
            <div class = "container form-outline mb-4">
                Name : <input type = "text" id = "name" class = "form-control" name = "name" placeholder = "Enter your name" required/>
            </div>
            <div class = "container form-outline mb-4">
                Address : <input type = "text" id = "address" class = "form-control" name = "address" placeholder="Enter your Address" required/>
            </div>
            <div class = "container form-outline mb-4">
                Pin : <input type = "text" id = "pin" class = "form-control" name = "pin" placeholder="Enter your Pin" maxlength = "6" required/>
            </div>
            <div class = "container form-outline mb-4">
                Mobile Number : <input type = "text" id = "mobile" class = "form-control" name = "mobile" placeholder = "Enter your mobile number" required/>
            </div>
            <div class = "container text-center">
                <button type="submit" class="btn btn-primary btn-block mb-4">Next</button>
            </div>
            </div><br>
        </form>
    </body>
</html>
