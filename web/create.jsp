<%-- 
    Document   : create
    Created on : 17.07.2017, 17:33:53
    Author     : Administrator
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.hemmerling.aufgabe01e_personenverwaltung_v3.model.persistence.Person"%>
<%@page import="com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person anlegen [Web Components ( aufgabe01e_personenVerwaltung_v3 )]</title>
    </head>
    <body>
        <jsp:include page = "header.jsp"/>
        <h1>Person anlegen</h1>

        <script type="text/javascript">
            function fillForm1() {
                document.getElementsByName("vorname")[0].value = 'Joe';
                document.getElementsByName("nachname")[0].value = 'Doe';
            }
            function fillForm2() {
                document.getElementsByName("vorname")[0].value = 'Mary';
                document.getElementsByName("nachname")[0].value = 'Doe';
            }
        </script>
        <form method="post" action="FrontController" name="theForm">
            <%
//            Enumeration paramNames = request.getParameterNames();
//            while (paramNames.hasMoreElements()) {
//                String paramName = (String) paramNames.nextElement();
//                String paramValue = request.getParameter(paramName);
//                if (paramValue != null && !paramValue.trim().isEmpty()) {
//                    out.print(paramValue + "</BR>");
//                }
//            } 
            if ((request.getParameter("action")!=null) &&
                (request.getParameter("action").equals("update")) &&
                (request.getParameter("id")!=null)) {
                PersonService personService = PersonService.getInstance(); // Singleton
                String idString = request.getParameter("id");
                int id = Integer.valueOf(idString);
                out.println("<input type='hidden' name='action' value='set' />");
                out.println("<input type='hidden' name='id' value='" + idString + "' />");
                out.println("Vorname: <input type='text' name='vorname' value='" + personService.get().get(id)[0] + "'/>");
                out.println("Nachname: <input type='text' name='nachname' value='" + personService.get().get(id)[1] + "'/>");
            } else { %>
                <input type="hidden" name="action" value="create" />
                Vorname: <input type="text" name="vorname" />
                Nachname: <input type="text" name="nachname" />
            <% } %>
            <input type="button" value="Ausfüllen des Forumulars #1" onclick="fillForm1()"  />
            <input type="button" value="Ausfüllen des Forumulars #2" onclick="fillForm2()"  />
            <input type="reset" value="Reset" />
            <input type="submit" value="Submit" />
        </form>
        <jsp:include page = "footer.jsp" />
    </body>
</html>
