<%-- 
    Document   : welcome.jsp
    Created on : Feb 20, 2023, 7:36:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Successfully</title>
    </head>
    <body>
        <%
            String user = (String)request.getAttribute("user");
        %>
        <h1 style="color:blue">Welcome <%= user %>!!</h1>
    </body>
</html>
