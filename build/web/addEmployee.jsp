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
        <title>Add Employee</title>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <jsp:include page="adminNav.jsp" /><br><br>
        <form action ="./AddEmployeeController" method ="post">
        <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Add Employee</h1>
            </div>
            <div class = "container form-outline mb-4">
                Employee Id : <input type = "text" id = "eid" class = "form-control" name = "eid" placeholder = "Enter employee id" required/>
            </div>
            <div class = "container form-outline mb-4">
                Employee Name : <input type = "text" id = "ename" class = "form-control" name = "ename" placeholder = "Enter employee name" required/>
            </div>
            <div class = "container form-outline mb-4">
                Employee Email : <input type = "email" id = "eemail" class = "form-control" name = "eemail" placeholder = "Enter employee email" required/>
            </div>
            <div class = "container form-outline mb-4">
                <div class = "container form-outline mb-4">
                Item Category : <select name = "workplace" id = "workplace" required>
                    <option disabled = "disabled" selected = "selected">Choose Workplace</option>
                    <option value = "Accountor">Accountor</option>
                    <option value = "Kitchen">Kitchen</option>
                </select>
            </div>
            <div class = "container form-outline mb-4">
                Mobile No : <input type = "text" id = "mobile" class = "form-control" name = "mobile" placeholder = "Enter mobile no" required/>
            </div>
            <div class = "container form-outline mb-4">
                Password : <input type = "password" id = "password" class = "form-control" name = "epassword" placeholder = "Enter password" required/>
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" >Add Employee</button>
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