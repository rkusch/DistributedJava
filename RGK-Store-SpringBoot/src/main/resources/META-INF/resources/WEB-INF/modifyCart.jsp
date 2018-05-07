<%-- 
    Document   : removeFromCart
    Created on : Mar 25, 2018, 10:43:49 AM
    Author     : Ryan
--%>

<%@page import="java.util.List"%>
<%@page import="edu.wctc.dj.week9.services.ProductFacade"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.UUID"%>
<%@page import="edu.wctc.dj.week9.entities.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String cartTotalAmount = (String) request.getAttribute("cartTotalAmount");
    String removeDiv = (String) request.getAttribute("removeDiv");
    String removeAll = (String) request.getAttribute("removeAll");
    String scriptToModifyCart = "";

%>
<!DOCTYPE html>
<%
    if (removeDiv != null) {
        scriptToModifyCart = "$('#" + removeDiv + "').remove();";
    }
    
    if (removeAll != null) {
        scriptToModifyCart = "$('#cartItems').remove();";
    }
    

    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    Double cartTotal = Double.valueOf(cartTotalAmount);
    String cartTotalFormatted = formatter.format(cartTotal);
    String cartTotalString = cartTotalFormatted.replace("$", "");
%>
<html>
    <script>
        $('#cartTotalNavbar').html("<%=cartTotalString%>");
        <%=scriptToModifyCart%>
    </script>

</html>
<%
%>


