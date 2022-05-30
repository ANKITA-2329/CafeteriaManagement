<%-- 
    Document   : menu
    Created on : 2022 May 7, 10:50:46
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Page</title>
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
				count = count < 1 ? 1 : count;
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
        <jsp:include page="mainNav.jsp" />
        <form method = "POST" action = "login.jsp"><br>
            <div class = "container form-outline rows">
                <img src ="menu.jfif" class="center" style = "display: block;
                    margin-left: auto;
                    margin-right: auto;"></img>
                <div class = "col border">
                    

                    <table style = "width : 500px;" class="table table-striped">
                        <thead>
                            <tr>

                                <th scope="col">Items</th>
                                <th scope="col">Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td colspan = "2" align="center"><b>COFFEE</td>
                            </tr>
                            <tr>
                                <td>Cold Coffee</td>
                                <td>50</td>
                            </tr>
                            <tr>
                                <td>Coffee with crush</td>
                                <td>60</td>
                            </tr>
                            <tr>
                                <td>Cold Chocolate</td>
                                <td>100</td>
                            </tr>


                            <div class="col-1 right">
                            <tr>
                                <td colspan = "2" align="Center"><b>Sandwich</td>
                            </tr>
                            <tr>
                                <td>Veg Cheese Sandwich</td>
                                <td>80</td>
                            </tr>
                            <tr>
                                <td>Tandoori Grilled Sandwich</td>
                                <td>100</td>
                            </tr>
                            <tr>
                                <td>Mexican Cheese Grilled Sandwich</td>
                                <td>150</td>
                            </tr>
                            </div>
                            <tr>
                                <td colspan = "2" align="Center"><b>BURGERS</td>
                            </tr>
                            <tr>
                                <td>CheeseBurger</td>
                                <td>100</td>
                            </tr>
                            <tr>
                                <td>Grilled CheesBurger </td>
                                <td>150</td>
                            </tr>
                            <tr>
                                <td>BigKing Burger</td>
                                <td>170</td>
                            </tr>

                        </tbody>
                    </table>
                    
                </div>
                <div class = "container text-center mt-2">
                        <button style = "width : 150px;" type="submit" class="btn btn-primary btn-block mb-2">Place Order</button>
                    </div>
            </div>
        </form><br><br>
    </body>
</html>
