<%-- 
    Document   : nameList
    Created on : Feb 6, 2018, 6:40:49 PM
    Author     : ryan
--%>

<%@page import="edu.wctc.dj.week3.model.StaticPage"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.List"%>
<%@page import="edu.wctc.dj.week3.model.Name"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
//    InputStream is = getServletContext().getResourceAsStream("/header.html");
// try(BufferedReader br = new BufferedReader(new FileReader(is))) {
//    for(String line; (line = br.readLine()) != null; ) {
//        // process the line.
//    }
//    // line is not visible here.
//}

    %>





    <body>
            Test
     
        <table>
            <%
                List<StaticPage> pageList = (List<StaticPage>) request.getAttribute("pageList");
                for (StaticPage aPage : pageList) {
                    %>
                    <tr>
                        <td> <%= aPage.getId() %> </td>
                        <td> 
                         <a href="?id=<%= aPage.getId() %> "> <%= aPage.getId() %> </a></td>
                    </tr>
                    <%
                }

                %>
            
        </table>
    </body>
</html>
