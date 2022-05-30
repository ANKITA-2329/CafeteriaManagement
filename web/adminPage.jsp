<%-- 
    Document   : customerPage
    Created on : 2022 May 5, 11:54:56
    Author     : Dell
--%>
<%@page import = "java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>-->
        <!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>-->

        <title>Admin Page</title>
    </head>
    <body>
        <% String message = (String) request.getAttribute("message"); 
            String date = (String) request.getAttribute("date");
        %>
        <jsp:include page = "adminNav.jsp"></jsp:include>
        <form action ="./AdminMainController" method ="Get"><br><br>

            <div class = "container form-outline mb-4">
                <input type ="date" name ="date" id ="date" class = "form-control">
            </div>
            <div class = "container text-center ">
                <button type="submit" class="btn btn-primary btn-block mb-2">Get Details</button>
            </div>
        </form>
        <div class = "container form-outline border mb-4">
        <% 
            %>Date : <%=date%><br><%
            Map<String, Object> reportMap = (LinkedHashMap) request.getAttribute("reportMap");
            if(reportMap != null)
            {
            for(Map.Entry<String, Object> entry: reportMap.entrySet()) {
        %>
        <p><%=entry.getKey()%>: <%=entry.getValue() %></p>    
        <%
            }
}
        %>
        </div>
        <form method = "Post">
        <div class = "container text-center ">
            <button type="submit" formaction = "./MontlyDetailsController"class="btn btn-primary btn-block mb-2">Monthly Details</button>
            <button type="submit" formaction = "./YearlyDetailsController"class="btn btn-primary btn-block mb-2">Yearly Details</button>
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
