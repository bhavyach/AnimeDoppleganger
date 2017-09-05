<%-- 
    Document   : index
    Author     : joemertz
    Source     : https://gist.github.com/joemertz/449a26fe12ec1ae901e0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%= request.getAttribute("doctype")%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/basic.css">
        <title>Project1Task4</title>
    </head>
    <body>
        <h1>Anime Doppelganger</h1>
        <jsp:include page="prompt.jsp" />
    </body>
</html>
