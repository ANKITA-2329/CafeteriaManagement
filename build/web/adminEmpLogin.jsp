<%-- 
    Document   : emp
    Created on : May 1, 2022, 4:30:58 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Login</title>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <jsp:include page="mainNav.jsp" /> 
        <form action = "/Rosa/EmpAdminController" method = "POST"><br><br>
            <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Employee/Admin Login</h1>
                <h6>Please enter your login id and password</h6>
            </div>
            <div class = "container form-outline mb-4">
                Email : <input type = "email" id = "cemail" class = "form-control" name = "email" placeholder="Enter your email id" required/>
            </div>
            <div class = "container form-outline mb-4">
                Password : <input type = "password" id = "cpassword" class = "form-control" name = "password" placeholder="Enter your password" required/>
            </div>
            <div class = "container form-outline mb-4">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="r1" value = "admin" id="r1" default>
                    <label class="form-check-label" for="r1">
                        Admin
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="r1" value = "employee" id="r2">
                    <label class="form-check-label" for="r1">
                        Employee
                    </label>
                </div>
            </div>
            <div class = "container text-center mb-4">
                <a href = "forget.jsp">Forget Password</a><br>
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>
            </div>
            </div>
        </form>
        <%
            if(message != null)
            { %>
                <script type="text/javascript">
                    var msg = "<%=message%>";
                    alert(msg);
                </script>
                <% }
        %>
    </body>
</html>
