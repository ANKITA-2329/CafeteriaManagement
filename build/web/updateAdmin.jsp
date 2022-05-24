<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Rosa.bean.Admin"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Admin</title>
    <style type = "text/css">
            table, th, td{
                border: 1px solid black;
                border-collapse: collapse;
              }
        </style>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <jsp:include page="adminNav.jsp"/>
        <form action ="./UpdateAdminController" method ="post"><br>
            <input type ="hidden" name ="action" value ="update">
            <div class ="container form-outline border"><br>
            <div class = "container form-outline mb-4">
                <h1>Update Admin</h1>
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
                            <td><input name = aname value = "<%=a.getAdmin_name()%>"></td>
                        </tr>
                        <tr>
                            <td>Admin Email Id</td>
                            <td><input name = aemail value = "<%=a.getAdmin_emailid()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Mobile No</td>
                            <td><input name = mobile value = "<%=a.getMobile_no()%>"></td>
                        </tr>
                    
            </table>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" onclick = "msg()">Update Admin</button>
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