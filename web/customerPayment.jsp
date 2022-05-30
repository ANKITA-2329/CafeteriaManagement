<%-- 
    Document   : payment.jsp
    Created on : 2022 May 27, 23:50:59
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
    </head>
    <body>
        <jsp:include page="customerPage.jsp"/>
        <form action ="./CustomerPaymentServlet" method ="Post"><br>
            <input type ="hidden" name="order_id" value ="${order_id}">
            <div class ="container form-outline border">
                <div class = "container form-outline mb-4">
                    <h1>Payment Mode</h1>
                </div>
                <div class = "container form-outline mb-4">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="r1" value = "Cash Payment" id="r1" default>
                        <label class="form-check-label" for="r1">
                            Cash Payment
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="r1" value = "Debit/Credit Payment" id="r2" onclick = "text(1)">
                        <label class="form-check-label" for="r2">
                            Debit/Credit Payment
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="r1" value = "UPI ID" id="r3" onclick = "text(2)">
                        <label class="form-check-label" for="r3">
                            UPI ID
                        </label>
                    </div>
                </div>
                <div class = "container text-center ">
                    <button type="submit" class="btn btn-primary btn-block mb-2">Next</button>
                </div>
            </div>    
        </form>
    </body>
</html>
