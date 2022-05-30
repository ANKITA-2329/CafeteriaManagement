<%@page import = "java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monthly Detail</title>
    </head>
    <body>
        <jsp:include page = "adminNav.jsp"/>
        <form method ="Get" action ="./MontlyDetailsController"><br><br>
            <div class ="container form-outline border">
                <select name = month placeholder="MM">
                    <option name="" value="" style="display:none;">MM</option>
                    <option value="01">January</option>
                    <option value="02">February</option>
                    <option value="03">March</option>
                    <option value="04">April</option>
                    <option value="05">May</option>
                    <option value="06">June</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
                <div class = "container text-center ">
                    <button type="submit" class="btn btn-primary btn-block mb-2">Get Details</button>
                </div>
            </div>
        </form>
        <div class = "container form-outline border mb-4">
        <% 
            String month = (String) request.getAttribute("month");
            %>Month : <%=month%><br><%
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
    </body>
</html>
