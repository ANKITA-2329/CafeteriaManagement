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
    </head>
    <body>
        <jsp:include page="adminPage.jsp"/>
        <form action ="/Rosa/DeleteItemController" method ="post"><br><br>
        <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Delete Item</h1>
            </div>
            <div class = "container form-outline mb-4">
                Item Name : <input type = "text" id = "name" class = "form-control" name = "iname" placeholder = "Enter item name" required/>
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" >Get Details</button>
            </div>
        </div>
<!--        </form>
        <form action ="#" method ="post"><br><br>-->
            <table border ="1">
                <%
                    ArrayList <Item> item = (ArrayList <Item>)request.getAttribute("result");
                    for(Item i : item)
                    {%>
                        <tr>
                            Item_ID : <td><%=i.getItem_id()%></td>
                            Item_Name : <td><%=i.getItem_name()%></td>
                            Item_category : <td><%=i.getItem_category()%></td>
                            Item_Description : <td><%=i.getItem_description()%></td>
                            Price : <td><%=i.getPrice()%></td>
                            Status : <td><%=i.getStatus()%></td>
                        </tr>
                    <%}
                    %>
            </table>
        </form>
    </body>
</html>
