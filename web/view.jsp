<%--
    Document   : createperson
    Created on : 17.07.2017, 17:33:53
    Author     : Administrator
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personenliste [Web Components ( aufgabe01f_personenverwaltung_v4 )]</title>
    </head>
    <body>
        <jsp:include page = "header.jsp" />
        <h1>Personenliste</h1>
        <%
            List<String[]> persons = (ArrayList<String[]>) session.getAttribute("persons");
            if (persons == null /* || items.isEmpty() */) {
        %>
        <% } else { %>
<!--        <ol>
            <% for (String[] person : persons) {%>
            <li><%= person[0]%>&nbsp;<%= person[1]%></li>
                <% } %>
        </ol>-->
        
            <% for (int ii=0; ii<persons.size();ii++) {%>          
            <li><%= ii%>&nbsp;<%= persons.get(ii)[0]%>&nbsp;<%= persons.get(ii)[1]%>&nbsp;
                <a href="FrontController?action=delete&id=<%= ii%>">Löschen</a>&nbsp;
                <a href="FrontController?action=update&id=<%= ii%>">Bearbeiten</a></li>
                <% } %>
        
        <% }%>
        <jsp:include page = "footer.jsp" />
    </body>
</html>
