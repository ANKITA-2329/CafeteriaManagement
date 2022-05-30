<%@page import="com.Rosa.bean.Item"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <style type = "text/css">
            span {cursor:pointer; }
            .number{
			margin:0px;
                    }
            .minus, .plus{
                            width:20px;
                            height:20px;
                            background:#f2f2f2;
                            border-radius:4px;
                            padding:0px 0px 0px 0px;
                            border:1px solid #ddd;
                            display: inline-block;
                            vertical-align: middle;
                            text-align: center;
                         }
            input{
			height:25px;
                        width: 80px;
                        text-align: center;
                        font-size: 26px;
			border:1px solid #ddd;
			border-radius:4px;
                        display: inline-block;
                        vertical-align: middle;
                     }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
        </script>
        <script>
            	$(document).ready(function() {
			$('.minus').click(function () {
				var $input = $(this).parent().find('input');
				var count = parseInt($input.val()) - 1;
				count = count < 0 ? 0 : count;
				$input.val(count);
				$input.change();
				return false;
			});
			$('.plus').click(function () {
				var $input = $(this).parent().find('input');
				$input.val(parseInt($input.val()) + 1);
				$input.change();
				return false;
			});
		});
        </script>
    </head>
    <body>
        <jsp:include page = "customerPage.jsp"/>
        <% String message = (String) request.getAttribute("message"); %>
        <form action ="./GetMenuController", method ="Post">
        <div class = "container form-outline rows">
            <img src ="menu.jfif" class="center" style = "display: block;
                margin-left: auto;
                margin-right: auto;"></img>
            <div class = "col border" style="width : 720px;  margin-left: auto; margin-right: auto;">
            <table style = "width : 680px;margin-left: auto; margin-right: auto;" class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Items</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan = "2" align="center"><b>COFFEE</td>
                    </tr>
        <%
            ArrayList <Item> item = (ArrayList <Item>)request.getAttribute("coffee");
            if(item != null)
            {
                for(Item i : item)
                {
                        %>
                            <tr>
                                <td><input style="width: 250px; text-align: left; border: none transparent; background-color: transparent;" name = iname value = "<%=i.getItem_name()%>" readonly = readonly><br>
                                    <p style="font-size: 12px"><%=i.getItem_description()%></p></td>
                                <td><input name = iprice value = "<%=i.getPrice()%>" readonly = readonly></td>
                                <td><div class="number">
                                    <span class="minus">-</span>
                                    <input type="text" name = "qty" value="0"/>
                                    <span class="plus">+</span>
                                    </div>
                                </td>
                            </tr>
                        <%  
                            }
            }
            %>
                    <tr>
                        <td colspan = "2" align="center"><b>Burger</td>
                    </tr>
            <%
            ArrayList <Item> item1 = (ArrayList <Item>)request.getAttribute("burger");
            if(item != null)
            {
                for(Item i : item1)
                {
                        %>
                            <tr>
                                <td><input style="width: 250px; text-align: left; border: none transparent; background-color: transparent;" name = iname value = "<%=i.getItem_name()%>" readonly = readonly><br>
                                    <p style="font-size: 12px"><%=i.getItem_description()%></p></td>
                                <td><input name = iprice value = "<%=i.getPrice()%>" readonly = readonly></td>
                                <td><div class="number">
                                    <span class="minus">-</span>
                                    <input type="text" name = "qty" value="0"/>
                                    <span class="plus">+</span>
                                    </div>
                                </td>
                            </tr>
                        <%  
                            }
            }
            %>
                    <tr>
                        <td colspan = "2" align="center"><b>Sandwich</td>
                    </tr>
            <%
            ArrayList <Item> item2 = (ArrayList <Item>)request.getAttribute("sandwich");
            if(item != null)
            {
                for(Item i : item2)
                {
                        %>
                            <tr>
                                <td><input style="width: 250px; text-align: left; border: none transparent; background-color: transparent;" name = iname value = "<%=i.getItem_name()%>" readonly = readonly><br>
                                    <p style="font-size: 12px"><%=i.getItem_description()%></p></td>
                                <td><input name = iprice value = "<%=i.getPrice()%>" readonly = readonly></td>
                                <td><div class="number">
                                    <span class="minus">-</span>
                                    <input type="text" name = "qty" value="0"/>
                                    <span class="plus">+</span>
                                    </div>
                                </td>
                            </tr>
                        <%  
                            }
            }
            %>        
                </tbody>
        </table>
        <div class = "container text-center mt-2">
            <button style = "width : 150px;" type="submit" class="btn btn-primary btn-block mb-2">Place Order</button>
        </div><br>
        </div><br>
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
