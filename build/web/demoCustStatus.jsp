<%@page import="com.Rosa.bean.Order"%>
<%@page import="com.Rosa.bean.Payment"%>
<%@page import = "java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Status</title>
    </head>
    <body>
        <jsp:include page = "customerPage.jsp"/>
        <form action ="./CustomerOrderServlet" method ="Post"><r><br>
            <div class = "col border" style="width : 720px;  margin-left: auto; margin-right: auto;">
            <table style = "width : 680px;margin-left: auto; margin-right: auto;" class="table table-striped">
                <tr>
                    <th>Selected</th>
                    <th>Order_id</th>
                    <th>Order_Status</th>
                </tr>
        <%
            ArrayList <Order> order = (ArrayList <Order>)request.getAttribute("order");
            
            for(Order o : order)
            {
            %>
            <tr>
                <td><input type ="radio" name ="order_id" value ="<%=o.getOrder_id()%>"></td>
                <td><%=o.getOrder_id()%></td>
                <td><%=o.getOrder_status()%></td>
            </tr>
            <%
            }
            
            %>
            </table>
            <div class = "container text-center ">
                <button type="submit" name = action value = "Deleta" class="btn btn-primary btn-block mb-2">Delete Order</button>
            </div>
            </div><br><br>
        </form>
    </body>
</html>
