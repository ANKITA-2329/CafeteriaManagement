<%-- 
    Document   : updateItem
    Created on : 2022 May 22, 22:32:00
    Author     : Dell
--%>

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
        <jsp:include page="adminNav.jsp"/>
        
        <form action ="./SearchEmployeeController" method ="post"><br><br>
        <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Search Item</h1>
            </div>
            <input type = "hidden" name = "action" value = "update">
            <div class = "container form-outline mb-4">
                <% if(request.getParameter("eid") != null)
                { %>
                    Employee Id : <input type = "text" id = "eid" class = "form-control" name = "eid" value="<%=request.getParameter("eid")%>" placeholder = "Enter employee id" required/>
                    <% }
                    else
                    { %> Employee Id : <input type = "text" id = "eid" class = "form-control" name = "eid" placeholder = "Enter employee id" required/> <% }
                %>
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" >Get Details</button>
            </div>
        </div>
        </form>
        <form action ="./UpdateEmployeeController" method ="post"><br>
            <div class ="container form-outline border"><br>
            <div class = "container form-outline mb-4">
                <h1>Update Item</h1>
            </div>
                <!--<input type = "hidden" name = "action" value = "update">-->
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
                            <td><input name = ename value = "<%=e.getEmp_name()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Emp Email Id</td>
                            <td><input name = eemail value = "<%=e.getEmp_emailid()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Emp workplace</td>
                            <td><input name = workplace value = "<%=e.getWorkplace()%>"></td>
                        </tr>
                        <tr>
                            <td>Mobile No</td>
                            <td><input name = mobile value = "<%=e.getMobile_no()%>" readonly="readonly"></td>
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