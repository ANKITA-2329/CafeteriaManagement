<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Rosa.bean.Employee"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Delete</title>
    <style type = "text/css">
            table, th, td{
                border: 1px solid black;
                border-collapse: collapse;
              }
        </style>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <jsp:include page="empPage.jsp"/>

            
        <form action ="./UpdateEmployeeProfileController" method ="post"><br>
            <!--<input type = "hidden" name = "action" value = "updateProfile">-->
            <div class ="container form-outline border"><br>
            <div class = "container form-outline mb-4">
                <h1>Update Employee</h1>
            </div>
                <input type = "hidden" name = "action" value = "update">
            <table style="margin-left:auto; margin-right:auto;" class="table table-striped">
                <%
                    ArrayList <Employee> emp = (ArrayList <Employee>)request.getAttribute("result");
                    if(emp != null)
                    {
                        for(Employee e : emp)
                        { %>
                        <tr>
                            <th>Employee_Title</th>
                            <th>Employee_Value</th>
                        </tr>
                        <tr>
                            <td>Emp_ID</td> 
                            <td><input name = eid value = "<%=e.getEmp_id()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Emp_Name</td>
                            <td><input name = ename value = "<%=e.getEmp_name()%>"></td>
                        </tr>
                        <tr>
                            <td>Emp Email Id</td>
                            <td><input name = eemail value = "<%=e.getEmp_emailid()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Emp workplace</td>
                            <td><input name = workplace value = "<%=e.getWorkplace()%>" readonly = "readonly"></td>
                        </tr>
                        <tr>
                            <td>Mobile No</td>
                            <td><input name = mobile value = "<%=e.getMobile_no()%>"></td>
                        </tr>
                    
            </table>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" onclick = "msg()">Update Employee</button>
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