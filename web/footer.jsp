<%-- 
    Document   : footer
    Created on : 19.07.2017, 08:39:48
    Author     : rhemmerling
--%>
<p>This software is distributed under the Apache 2 license.</p>
<%
    String info = (String)request.getAttribute("info");
    String error = (String)request.getAttribute("error");
    if (info != null || error != null) {
        out.println("<hr>");
    }
    if (info != null) {
        out.println("<div style='color:green'>" + info + "</div>");
    }
    if (error != null) {
        out.println("<div style='color:red'>" + info + "</div>");
    }
%>
