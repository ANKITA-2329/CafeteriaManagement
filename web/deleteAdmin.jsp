<%-- 
    Document   : deleteItem
    Created on : 2022 May 21, 21:46:03
    Author     : Dell
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Rosa.bean.Admin"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Admin</title>
        <style type = "text/css">
            table, th, td{
                border: 1px solid black;
                border-collapse: collapse;
              }
        </style>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <jsp:include page="adminPage.jsp"/>
        <form name = "delete" id = "search" action ="./SearchAdminController" method ="post"><br><br>
        <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Search Admin</h1>
            </div>
            <input type = "hidden" name = "action" value = "delete">
            <div class = "container form-outline mb-4">
                <% if(request.getParameter("aid") != null)
                { %>
                    Admin Id : <input type = "text" id = "aid" class = "form-control" name = "aid" value="<%=request.getParameter("aid")%>" placeholder = "Enter admin id" required/>
                    <% }
                    else
                    { %> Admin Id : <input type = "text" id = "aid" class = "form-control" name = "aid" placeholder = "Enter admin id" required/> <% }
                %>
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" >Get Details</button>
            </div>
        </div>
        </form>
        <form action ="./DeleteAdminServlet" method ="post"><br>
            <div class ="container form-outline border"><br>
            <div class = "container form-outline mb-4">
                <h1>Delete Admin</h1>
            </div>
            <input type = "hidden" name = "action" value = "delete">
            <table style="margin-left:auto; margin-right:auto;" class="table table-striped">
                <%
                    ArrayList <Admin> admin = (ArrayList <Admin>)request.getAttribute("result");
                    if(admin != null)
                    {
                        for(Admin a : admin)
                        { %>
                        <tr>
                            <th>Admin_Title</th>
                            <th>Admin_Value</th>
                        </tr>
                        <tr>
                            <td>Admin_ID</td> 
                            <td><input name = aid value = "<%=a.getAdmin_id()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Admin_Name</td>
                            <td><input name = aname value = "<%=a.getAdmin_name()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Admin Email Id</td>
                            <td><input name = aemail value = "<%=a.getAdmin_emailid()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Mobile No</td>
                            <td><input name = mobile value = "<%=a.getMobile_no()%>" readonly="readonly"></td>
                        </tr>
                    
            </table>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" onclick = "msg()">Delete Admin</button>
            </div>
                        <%
                        }
                    }
                %>
        </div>
            
        </form><br>
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
