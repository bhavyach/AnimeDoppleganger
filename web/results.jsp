<%-- 
    Document   : results
    Author     : bhavya
--%>

<%@page import="bhavya.project1.task4.Doppleganger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%= request.getAttribute("doctype")%>

<%
    final String errorMessage = (String) request.getAttribute("errorMessage");
    final Doppleganger doppleganger = (Doppleganger) request.getAttribute("doppleganger");
    String imageToShow = "";
    if (doppleganger != null) {
        if (request.getAttribute("doctype").equals("mobile")) {
            imageToShow = doppleganger.getThumbNailImage() + "\" style=\"width:500px;height:500px;\"";
%>
<!DOCTYPE html PUBLIC "-//asadWAPFORUM//DTD XHTML Mobile 1.2//EN"
    "http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd">
<%
} else {
    imageToShow = doppleganger.getFullImage();
%>
<!DOCTYPE html>
<%
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/basic.css">
        <title>Doppelganger</title>
    </head>
    <body>
        <h1>Anime Doppelganger</h1>

        <% if (errorMessage != null) {%>
        <p>Error: <%= errorMessage%></p>
        <% } else if (doppleganger == null) { %>
        <p>Sorry! You are too unique and your doppelganger could not be found</p>
        <p>Want to try again?</p>
        <% } else {%>
        <p>Your Anime Doppelganger is name d<%= doppleganger.getName()%></p>
        <div id="doppleganger_image">
            <img alt="<%= doppleganger.getName()%>" src="<%= imageToShow%>"/>
        </div>
        <p>Try again?</p>
        <% }%>

        <jsp:include page="prompt.jsp" />
    </body>
</html>
