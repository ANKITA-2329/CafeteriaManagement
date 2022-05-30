<%@page import="com.Rosa.bean.Item"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <style type="text/css">
            td {
              padding: 0 25px;
            }
        </style>
    </head>
    <body>
        <jsp:include page = "customerPage.jsp"/>
        <form action ="./MakeCustServlet" method ="post"><br>
            <!--<input type = "hidden" name = "action" value = "updateProfile">-->
            <div class ="container form-outline border" style = "width : 50%; margin-left: auto; margin-right: auto;"><br>
            <div class = "container form-outline mb-4">
                <h1>Selected Order</h1>
            </div>
            <div class = "container form-outline rows">
            <div class = "col border" style="width : 600px;  margin-left: auto; margin-right: auto;">
                <table style="margin-left:auto; margin-right:auto;" class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Items_name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <!--<th scope="col">Total</th>-->
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList <Item> selected_item = (ArrayList <Item>)request.getAttribute("selected_Item");
                            if(selected_item != null)
                            {
                            for(Item i : selected_item)
                            {
                                %>
                                    <tr>
                                        <td><input style="width: 250px; text-align: left; border: none transparent; background-color: transparent;" type = text name = iname value = "<%=i.getItem_name()%>"></td>
                                        <td><%=i.getPrice()%></td>
                                        <td><input style="border: none transparent; background-color: transparent;" type = text name = qty value = "<%=i.getQty()%>"></td>
                                        <!--<td><%=i.getTotal()%></td>-->
                                    </tr>
                                <%
                            }
                            }
                            else
                            {
                                %>Cart is empty <%
                            }   
                            %>
                    </tbody>
                </table>
                    
            </div><br>
            </div>
            <div class = "container form-outline mb-4">
                <h1>Bill Details</h1>
            </div>
            <div class = "col border" style="width : 600px;  margin-left: auto; margin-right: auto; column-gap: 40px;">
                <table style="margin-left:auto; margin-right:auto; border : 1px; column-gap: 80px;">
                    <tbody>
                        <%
                            ArrayList <Item> selected_items = (ArrayList <Item>)request.getAttribute("selected_Item");
                            if(selected_item != null)
                            {
                            for(Item i : selected_items)
                            {
                                %>
                                    <tr>
                                        <td><%=i.getItem_name()%></td>
                                        <td><%=i.getPrice()%></td>
                                        <td><%=i.getQty()%></td>
                                        <td> <%=i.getTotal()%></td>
                                    </tr>
                                <%
                            }
                            }  
                            %>
                            <tr>
                                <td>Total</td>
                                <td colspan = "3" style = "text-align: right;"><input style="text-align: right; border: none transparent; background-color: transparent;" type = text name = stotal value = "${subTotal}"></td>
                            </tr>
                            <tr>
                                <td>GST Tax %</td>
                                <td colspan = "3" style = "text-align: right;"><input style="text-align: right; border: none transparent; background-color: transparent;" type = text name = gst value = "${gst}"><td>
                            </tr>
                            <tr>
                                <td>CGST Tax %</td>
                                <td colspan = "3" style = "text-align: right;"><input style="text-align: right; border: none transparent; background-color: transparent;" type = text name = cgst value = "${cgst}"><td>
                            </tr>
                            <tr>
                                <td>Grand Total</td>
                                <td colspan = "3" style = "text-align: right;"><input style="text-align: right; border: none transparent; background-color: transparent;" type = text name = gtotal value = "${grandTotal}"><td>
                            </tr>
                    </tbody>
                </table>
                <div class = "container form-outline mb-4">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="r1" value = "Dine-In" id="r1">
                    <label class="form-check-label" for="r1">
                        Dine-In
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="r1" value = "Take-Away" id="r2">
                    <label class="form-check-label" for="r1">
                        Take-Away
                    </label>
                </div>
            </div>
            </div><br>
            
            </div><br>
            <div class = "container text-center ">
                    <button type="submit" class="btn btn-primary btn-block mb-2">Next</button>
            </div>
            </form>
    </body>
</html>
