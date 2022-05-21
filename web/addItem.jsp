<%-- 
    Document   : addItem
    Created on : 2022 May 21, 11:39:41
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Food Item</title>
        <script language="javascript"> 
            function msg(){ 
              <% String message = (String) request.getAttribute("message"); %>
               var s="<%=message%>"; 
               alert(s); 
            } 
        </script>
    </head>
    <body>
        <jsp:include page="adminPage.jsp" /><br><br>
        
        <form action ="/Rosa/AddItemController" method ="post">
        <div class ="container form-outline border">
            <div class = "container form-outline mb-4">
                <h1>Add Food to Item List</h1>
            </div>
            <div class = "container form-outline mb-4">
                Item Name : <input type = "text" id = "name" class = "form-control" name = "iname" placeholder = "Enter item name" required/>
            </div>
            <div class = "container form-outline mb-4">
                Item Category : <select name = "icategory" id = "icategory" required>
                    <option disabled = "disabled" selected = "selected">Choose Food Category</option>
                    <option value = "Coffee">Coffee</option>
                    <option value = "Burger">Burger</option>
                    <option value = "Sandwich">Sandwich</option>
                    <option value = "Pizza">Pizza</option>
                </select>
            </div>
            <div class = "container form-outline mb-4">
                Item Description : <input type = "textarea" id = "name" class = "form-control" name = "idesc" placeholder = "Enter your name" required/>
            </div>
            <div class = "container form-outline mb-4">
                Price : <input type = "text" id = "name" class = "form-control" name = "iprice" placeholder = "Enter your name" required/>
            </div>
            <div class = "container form-outline mb-4">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="i1" value = "Available" id="i1">
                    <label class="form-check-label" for="r1">
                        Available
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="i1" value = "NotAvailable" id="i2">
                    <label class="form-check-label" for="r1">
                        Not Available
                    </label>
                </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2" >Add item</button>
            </div>
        </div>
        </div>
        </form><br><br>
    </body>
</html>
