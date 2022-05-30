<%-- 
    Document   : changePassword
    Created on : May 1, 2022, 8:35:12 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <jsp:include page="empPage.jsp"/>
        <form action = "./EmpChangePassword" method = "POST"><br><br>
        <div class ="container form-outline border">
        <div class = "container form-outline mb-4">
            <h1>Change Password</h1>
            <p>Enter change password : </p>
        </div>
        <div class = "container form-outline mb-4">
            New Password : <input type = "password" id = "password" class = "form-control" name = "password" placeholder="Enter your password" required/>
        </div>
        <div class = "container form-outline mb-4">
            Confirm Password : <input type = "password" id = "cpassword" class = "form-control" name = "cpassword" placeholder="Enter your password" required/>
        </div>
        <div class = "container text-center">
            <button type="submit" class="btn btn-primary btn-block mb-4">Change Password</button>
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
