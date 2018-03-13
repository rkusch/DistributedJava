<%-- 
    Document   : index
    Created on : Feb 6, 2018, 6:20:44 PM
    Author     : ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
            <h1> Search!</h1>
        <form method=get action="NameController">
                <input type="text" name="search" />
                <input type="submit" value="Search"/>
        </form>
    </body>
</html>
