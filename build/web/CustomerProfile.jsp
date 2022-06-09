<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Rosa.bean.Customer"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
    <style type = "text/css">
            table, th, td{
                border: 1px solid black;
                border-collapse: collapse;
              }
        </style>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); %>
        <jsp:include page="customerPage.jsp"/>

            
        <form action ="./CustomerProfileController" method ="post"><br>
            <!--<input type = "hidden" name = "action" value = "updateProfile">-->
            <div class ="container form-outline border"><br>
            <div class = "container form-outline mb-4">
                <h1>Update Customer</h1>
            </div>
                <input type = "hidden" name = "action" value = "update">
            <table style="margin-left:auto; margin-right:auto;" class="table table-striped">
                <%
                    ArrayList <Customer> cust = (ArrayList <Customer>)request.getAttribute("result");
                    if(cust != null)
                    {
                        for(Customer c : cust)
                        { %>
                        <tr>
                            <th>Customer_Title</th>
                            <th>Customer_Value</th>
                        </tr>
                        <tr>
                            <td>Customer_ID</td> 
                            <td><input name = cid value = "<%=c.getC_id()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Customer_Name</td>
                            <td><input name = cname value = "<%=c.getC_name()%>"></td>
                        </tr>
                        <tr>
                            <td>Customer Email Id</td>
                            <td><input name = cemail value = "<%=c.getC_emailid()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Customer address</td>
                            <td><input name = address value = "<%=c.getAddress()%>"></td>
                        </tr>
                        <tr>
                            <td>Customer Pin</td>
                            <td><input name = pin value = "<%=c.getPin()%>"></td>
                        </tr>
                        <tr>
                            <td>Mobile No</td>
                            <td><input name = mobile value = "<%=c.getMobile_no()%>"></td>
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