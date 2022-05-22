<%-- 
    Document   : deleteItem
    Created on : 2022 May 21, 21:46:03
    Author     : Dell
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Rosa.bean.Item"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Item</title>
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
        <form name = "delete" id = "search" action ="./SearchItemController" method ="post"><br><br>
        <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Search Item</h1>
            </div>
            <input type = "hidden" name = "action" value = "delete">
            <div class = "container form-outline mb-4">
                Item Name : <input type = "text" id = "name" class = "form-control" name = "iname" value="<%=request.getParameter("iname")%>" placeholder = "Enter item name" required/>
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" >Get Details</button>
            </div>
        </div>
        </form>
        <form action ="/Rosa/DeleteItemServlet" method ="post"><br>
            <div class ="container form-outline border"><br>
            <div class = "container form-outline mb-4">
                <h1>Delete Item</h1>
            </div>
<!--            <input type = "hidden" name = "action" value = "delete">-->
            <table style="margin-left:auto; margin-right:auto;" class="table table-striped">
                <%
                    ArrayList <Item> item = (ArrayList <Item>)request.getAttribute("result");
                    if(item != null)
                    {
                        for(Item i : item)
                        { %>
                        <tr>
                            <th>Item_Title</th>
                            <th>Item_Value</th>
                        </tr>
                        <tr>
                            <td>Item_ID</td> 
                            <td><input name = iid value = "<%=i.getItem_id()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Item_Name</td>
                            <td><input name = iname value = "<%=i.getItem_name()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Item_category</td>
                            <td><input name = icategory value = "<%=i.getItem_category()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Item_Description</td>
                            <td><input name = idesc value = "<%=i.getItem_description()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Price</td>
                            <td><input name = iprice value = "<%=i.getPrice()%>" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td>Status</td>
                            <td><input name = istatus value = "<%=i.getStatus()%>" readonly="readonly"></td>
                        </tr>
                    <%
                        }
                    }
                %>
            </table>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" onclick = "msg()">Delete Item</button>
            </div>
        </div>
            
        </form><br>
        <script type="text/javascript">
                var msg = "<%=message%>";
                alert(msg);
        </script>
    </body>
</html>
