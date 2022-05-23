<%-- 
    Document   : addItem
    Created on : 2022 May 21, 11:39:41
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Admin</title>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <jsp:include page="adminNav.jsp" /><br><br>
        <form action ="./AddAdminController" method ="post">
        <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Add Admin</h1>
            </div>
            <div class = "container form-outline mb-4">
                Admin Id : <input type = "text" id = "aid" class = "form-control" name = "aid" placeholder = "Enter admin id" required/>
            </div>
            <div class = "container form-outline mb-4">
                Admin Name : <input type = "text" id = "aname" class = "form-control" name = "aname" placeholder = "Enter admin name" required/>
            </div>
            <div class = "container form-outline mb-4">
                Admin Email : <input type = "email" id = "aemail" class = "form-control" name = "aemail" placeholder = "Enter admin email" required/>
            </div>
            <div class = "container form-outline mb-4">
                Mobile No : <input type = "text" id = "mobile" class = "form-control" name = "mobile" placeholder = "Enter your name" required/>
            </div>
            <div class = "container form-outline mb-4">
                Password : <input type = "password" id = "password" class = "form-control" name = "apassword" placeholder = "Enter your name" required/>
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" >Add Admin</button>
            </div>
        </div>
        </form><br><br>
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