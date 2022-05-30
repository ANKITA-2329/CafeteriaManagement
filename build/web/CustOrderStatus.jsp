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
        <jsp:include page = "customerPage.jsp"/><br><br>
        <form action ="./ManageCustomerOrderServlet" method ="Post">
            <input type ="hidden" name ="payid" value ="${payment_id}">
         <%
            String message = (String) request.getAttribute("message");
            Payment pay = (Payment) request.getAttribute("pay");
            Order order = (Order) request.getAttribute("order");
            %>
        <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <% if(pay != null && order != null)
                {
                %>Payment Id : ${payment_id}<br>
                <!--<input type = "hidden" name ="orderid" value ="">-->
                Order Id : <%=pay.getOrder_id()%><br>
                Order Date : <%=order.getDate()%><br>
                Order Details : <%=order.getOrder_details()%><br>
                Order Type : <%=order.getOrder_type()%><br>
                Amount : <%=pay.getPayment_amount()%><br>
                Payment Mode : <%=pay.getPayment_mode()%><br>
                Order Status : 
                <div class = "container form-outline mb-4">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="r1" value = "<%=order.getOrder_status()%>" id="r1" checked>
                        <label class="form-check-label" for="r1">
                            <%=order.getOrder_status()%>
                        </label>
                    </div>
                    <%
                        }
                        %>
                </div>
                <div class = "container text-center ">
                    <button type="submit" name = action value = "Delete" class="btn btn-primary btn-block mb-2">Delete Order</button>
                </div>
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
