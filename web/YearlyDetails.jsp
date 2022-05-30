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
        <form method ="Get" action ="./YearlyDetailsController"><br><br>
            <div class ="container form-outline border">
                <select name = year placeholder="YYYY">
                    <option name="" value="" style="display:none;">YYYY</option>
                    <option value="2019">2019</option>
                    <option value="2020">2020</option>
                    <option value="2021">2021</option>
                    <option value="2022">2022</option>
                </select>
                <div class = "container text-center ">
                    <button type="submit" class="btn btn-primary btn-block mb-2">Get Details</button>
                </div>
            </div>
        </form>
        <div class = "container form-outline border mb-4">
        <% 
            String year = (String) request.getAttribute("year");
            %>Year : <%=year%><br><%
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
